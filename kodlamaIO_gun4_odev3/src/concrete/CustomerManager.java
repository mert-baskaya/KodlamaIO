package concrete;

import abstracts.CustomerCheckService;
import abstracts.CustomerService;
import abstracts.DatabaseService;
import entities.Customer;

public class CustomerManager implements CustomerService {

	/* Dependency injection */
	DatabaseService dbService;
	CustomerCheckService checkService;

	public CustomerManager(DatabaseService dbService, CustomerCheckService checkService) {
		this.dbService = dbService;
		this.checkService = checkService;
	}
	/* Dependency injection */

	// Sadece customer eklenirken kontrol saglaniyor, gelistirilebilir

	@Override
	public void add(Customer customer) {
		if (checkService.checkCustomer(customer)) {
			dbService.addToDb(customer);
		} else {
			System.out.println("Hatali musteri girdisi!");
		}
	}

	@Override
	public Customer get(int id) {
		return (Customer) dbService.selectById(id);
	}

	@Override
	public void edit(Customer customer) {
		dbService.editSelected(customer);
	}

	@Override
	public void delete(int id) {
		dbService.deleteById(id);
	}

	public Customer getCustomerById(int id) {
		return (Customer) dbService.selectById(id);
	}

	public void addFundsToWallet(Customer customer, float funds) {
		float walletBalance = customer.getWalletBalance();
		walletBalance += funds;
		customer.setWalletBalance(walletBalance);
		edit(customer);
		System.out.println(customer.getFirstName() + " adli musterinin hesabina bakiye eklendi: " + funds);
	}

}
