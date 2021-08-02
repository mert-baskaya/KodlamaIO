package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.EmailChecker;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.validationServices.mailValidation.MailValidationService;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	private MailValidationService mailValidationService;

	@Autowired
	public EmployerManager(EmployerDao employerDao, MailValidationService mailValidationService) {
		super();
		this.employerDao = employerDao;
		this.mailValidationService = mailValidationService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), "Data listelendi");
	}

	@Override
	public Result add(Employer employer) {
		// TODO business logic
		// try-catch kullanmak kulaga cok mantikli geliyor

		if (!nullControl(employer)) {
			return new ErrorResult("Alanlar bos birakilamaz: " + employer.getEmail());
		}
		if (!EmailChecker.checkEmailDomainConsistancy(employer.getWebAddress(), employer.getEmail())) {
			return new ErrorResult(
					"Email ve web adresi uyumlu degil: " + employer.getEmail() + " - " + employer.getWebAddress());
		}
		if (employerDao.existsByEmail(employer.getEmail())) {
			return new ErrorResult("E posta adresi daha once kullanilmis: " + employer.getEmail());
		} else {
			// burada mail gönderilip delay suresi konulabilir
		}
		if (!mailValidationService.validate(employer.getEmail()).isSuccess()) {
			return new ErrorResult("E posta dogrulamasi gerekli zamanda yapilmadi: " + employer.getEmail());
		}
		if (!employer.getPassword().equals(employer.getPasswordRepeat())) {
			return new ErrorResult("Girilen sifreler birbiriyle eslesmiyor: " + employer.getPassword() + " - "
					+ employer.getPasswordRepeat());
		} else {
			employerDao.save(employer);
			return new SuccessResult(
					"Uyelik basarili, yoneticinin hesabi aktive etmesi bekleniyor: " + employer.getEmail());
		}

	}

	@Override
	public Result update(Employer employer) {
		// burasi boyle olmamali, random bir yerden gelen obje kontrol edilmeden
		// eklenebilir
		employerDao.save(employer);
		return new SuccessResult("Is veren guncellendi: " + employer.getEmail());
	}

	private boolean nullControl(Employer employer) {
		if (employer.getEmail() == null || employer.getEmail().isBlank() || employer.getPassword() == null
				|| employer.getPassword().isBlank() || employer.getCompanyName() == null
				|| employer.getCompanyName().isBlank() || employer.getWebAddress() == null
				|| employer.getWebAddress().isBlank()) {

			return false;
		}
		return true;
	}

}
