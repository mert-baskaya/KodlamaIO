package adapters;

import abstractEntitites.CustomerCheckService;
import entities.Customer;
import utils.Utils;

public class MernisServiceAdapter implements CustomerCheckService{

	@Override
	public boolean checkCustomer(Customer customer) {
		System.out.println(Utils.isTCKNCorrect(customer.getNationalIdentity()));
		return (Utils.isTCKNCorrect(customer.getNationalIdentity()));
	}
	
	
	
}
