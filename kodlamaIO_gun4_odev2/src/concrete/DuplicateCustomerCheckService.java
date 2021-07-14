package concrete;

import abstractEntitites.CustomerCheckService;
import entities.Customer;

public class DuplicateCustomerCheckService implements CustomerCheckService {

	@Override
	public boolean checkCustomer(Customer customer) {
		System.out.println("Veritabanina tekrar eden musteri icin bakildi: true");
		return true;
	}

}
