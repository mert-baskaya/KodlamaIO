package eCommerce.business.abstracts;

import eCommerce.entities.concretes.Customer;

public interface TwoFactorAuthenticationService {
	boolean authenticateCustomer(Customer customer);
}
