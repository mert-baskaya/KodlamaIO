package eCommerce.business.abstracts;

import eCommerce.entities.concretes.Customer;

public interface CustomerCheckService {
	boolean checkCustomer(Customer customer);
}
