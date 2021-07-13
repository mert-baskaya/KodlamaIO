package main;

import java.util.Date;

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
		
		// MernisCustomerCheckService mernisCustomerCheckService = new MernisServiceAdapter();
		
		MernisCustomerCheckService mernisCustomerCheckService = new MernisCustomerCheckService();
		
		DuplicateCustomerCheckService duplicateCheckService = new DuplicateCustomerCheckService();
		
		CustomerCheckService[] checkServices = {mernisCustomerCheckService,duplicateCheckService};
		
		CustomerCheckManager customerCheckManager = new CustomerCheckManager(checkServices);
		
		StarbucksCustomerManager starbucksCustomerManager = new StarbucksCustomerManager(customerCheckManager);
		
		starbucksCustomerManager.save(new Customer(0, "Mert", "Başkaya", "19684062692", new Date(2323223232L)));
	}

}
