package kodlamaio.hrms.core.validationServices.staffValidation;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerValidationManager implements EmployerValidationService {

	@Override
	public DataResult<Employer> validate(Employer employer) {
		// kullanici yasakli olmasi durumunda ekstra onlem alinabilir

		employer.setActivated(true);

		return new SuccessDataResult<Employer>(employer, "Hesap aktive edildi: " + employer.getEmail());
	}

}
