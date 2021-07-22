package eCommerce.business.abstracts;

import eCommerce.entities.concretes.Customer;

public interface CustomerService {
	boolean signIn(Customer customer);	
	boolean signUp(Customer customer);
	boolean deleteAccount(Customer customer);
}
