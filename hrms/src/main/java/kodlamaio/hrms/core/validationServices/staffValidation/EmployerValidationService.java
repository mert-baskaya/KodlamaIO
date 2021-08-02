package kodlamaio.hrms.core.validationServices.staffValidation;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.Employer;

public interface EmployerValidationService {
	DataResult<Employer> validate(Employer employer);
}
