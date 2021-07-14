package concrete;

import abstractEntitites.CustomerCheckService;
import entities.Customer;

public class MernisCustomerCheckService implements CustomerCheckService {

	public boolean checkCustomer(Customer customer) {
		return true;
	}

}
