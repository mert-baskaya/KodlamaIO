package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.validationServices.mailValidation.MailValidationService;
import kodlamaio.hrms.core.validationServices.userValidation.UserNationalIdValidationService;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;
	private UserNationalIdValidationService nationalIdValidationService;
	private MailValidationService mailValidationService;

	@Autowired
	public CandidateManager(CandidateDao candidateDao, UserNationalIdValidationService nationalIdValidationService,
			MailValidationService mailValidationService) {
		super();
		this.candidateDao = candidateDao;
		this.nationalIdValidationService = nationalIdValidationService;
		this.mailValidationService = mailValidationService;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(), "Data listelendi");
	}

	@Override
	public Result add(Candidate candidate) {
		if (!nullControl(candidate)) {
			return new ErrorResult("Alanlar bos birakilamaz: " + candidate.getEmail());
		}
		if (!nationalIdValidationService.validate(candidate.getNationalIdentityNumber(), candidate.getFirsName(),
				candidate.getLastName(), candidate.getBirthYear()).isSuccess()) {
			return new ErrorResult("Kimlik numarasi hatali: " + candidate.getNationalIdentityNumber());
		}
		if (candidateDao.existsByEmail(candidate.getEmail())) {
			return new ErrorResult("Eposta daha once sisteme kaydolmus: " + candidate.getEmail());
		}
		if (candidateDao.existsByNationalIdentityNumber(candidate.getNationalIdentityNumber())) {
			return new ErrorResult(
					"Tc kimlik numarasi daha once sisteme kaydolmus: " + candidate.getNationalIdentityNumber());
		}
		if (!mailValidationService.validate(candidate.getEmail()).isSuccess()) {
			return new ErrorResult("E posta dogrulamasi gerekli zamanda yapilmadi: " + candidate.getEmail());
		}
		if (!candidate.getPassword().equals(candidate.getPasswordRepeat())) {
			return new ErrorResult("Girilen sifreler birbiriyle eslesmiyor: " + candidate.getPassword() + " - "
					+ candidate.getPasswordRepeat());
		} else {
			this.candidateDao.save(candidate);
			return new SuccessResult("Uyelik basarili");
		}
	}

	private boolean nullControl(Candidate candidate) {
		if (candidate.getBirthYear() == null || candidate.getFirsName() == null || candidate.getLastName() == null
				|| candidate.getNationalIdentityNumber() == null) {
			return false;
		}

		return true;
	}

}
