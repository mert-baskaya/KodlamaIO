package concrete;

import abstracts.CustomerCheckService;
import entities.Customer;

public class CustomerCheckManager implements CustomerCheckService{
	
	/* dependency injection */
	CustomerCheckService checkService;
	public CustomerCheckManager(CustomerCheckService checkService) {
		this.checkService = checkService;
	}
	/* dependency injection */	

	@Override
	public boolean checkCustomer(Customer customer) {
		return checkService.checkCustomer(customer);
	}

}
