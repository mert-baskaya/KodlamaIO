package concrete;

import abstractEntitites.CustomerCheckService;
import adapters.MernisServiceAdapter;
import entities.Customer;

public class MernisCustomerCheckService implements CustomerCheckService {

	public boolean checkCustomer(Customer customer) {
		return true;
	}

}
