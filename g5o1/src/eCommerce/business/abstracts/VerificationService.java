package eCommerce.business.abstracts;

import eCommerce.entities.concretes.Customer;

public interface VerificationService {
	boolean verify(Customer customer);
}
