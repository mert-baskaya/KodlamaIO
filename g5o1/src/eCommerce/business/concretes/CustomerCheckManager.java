package eCommerce.business.concretes;

import eCommerce.business.abstracts.CustomerCheckService;
import eCommerce.business.abstracts.VerificationService;
import eCommerce.entities.concretes.Customer;

public class CustomerCheckManager implements CustomerCheckService {

	private VerificationService verificationService;

	public CustomerCheckManager(VerificationService verificationService) {
		this.verificationService = verificationService;
	}

	@Override
	public boolean checkCustomer(Customer customer) {
		if (checkPassword(customer) && checkNames(customer) && verificationService.verify(customer)) {
			return true;
		}else {
			return false;
		}

	}

	private boolean checkPassword(Customer customer) {
		String password = customer.getCustomerPassword();
		if (password.length() >= 6) {
			return true;
		} else {
			return false;
		}
	}

	private boolean checkNames(Customer customer) {
		String firstName = customer.getCustomerName();
		String lastName = customer.getCustomerSurname();
		//best practice degil farkindayim
		if(firstName.length() >= 2 && lastName.length() >= 2) {
			return true;
		}else {
			return false;
		}
		
	}

}
