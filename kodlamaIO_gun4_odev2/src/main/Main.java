package main;

import abstractEntitites.CustomerCheckService;
import adapters.MernisServiceAdapter;
import concrete.CustomerCheckManager;
import concrete.DuplicateCustomerCheckService;
import concrete.MernisCustomerCheckService;
import concrete.StarbucksCustomerManager;
import entities.Customer;

public class Main {
	
	public static void main(String[] args) {
		
		// end my misery
		
		MernisServiceAdapter mernisServiceAdapter = new MernisServiceAdapter();
		
		//MernisCustomerCheckService mernisCustomerCheckService = new MernisCustomerCheckService();
		
		DuplicateCustomerCheckService duplicateCheckService = new DuplicateCustomerCheckService();
		
		CustomerCheckService[] checkServices = {duplicateCheckService, mernisServiceAdapter};
		
		CustomerCheckManager customerCheckManager = new CustomerCheckManager(checkServices);
		
		StarbucksCustomerManager starbucksCustomerManager = new StarbucksCustomerManager(customerCheckManager);
		
		starbucksCustomerManager.save(new Customer(0, "Mert", "Başkaya", "11111111111", 1998));
	}

}
