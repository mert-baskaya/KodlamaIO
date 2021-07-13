package abstractEntitites;

import concrete.CustomerCheckManager;
import entities.Customer;

public abstract class BaseCustomerManager implements CustomerService {
	
	CustomerCheckManager checkManager;
	
	public BaseCustomerManager(CustomerCheckManager checkManager) {
		this.checkManager = checkManager;
	}

	public void save(Customer customer) {
		if(checkManager.checkCustomer(customer)) {
			System.out.println("Veri tabanina kaydedildi: " + customer.getDateOfBirth());
		}
	}

}
