package concrete;

import abstractEntitites.CustomerCheckService;
import entities.Customer;

public class CustomerCheckManager implements CustomerCheckService {
	
	int comparisonLength;


	/* Dependency injection */
	private CustomerCheckService[] checkServices;
	private CustomerCheckService checkService;

	public CustomerCheckManager(CustomerCheckService checkService) {
		this.checkService = checkService;
	}
	
	public CustomerCheckManager(CustomerCheckService[] checkServices) {
		this.checkServices = checkServices;
		this.comparisonLength = checkServices.length;
	}
	/* Dependency injection */
	
	@Override
	public boolean checkCustomer(Customer customer) {
		
		if(checkService != null) {
			if(checkService.checkCustomer(customer)) {
				System.out.println("Tek kontrol yapildi, sonuc basarili");
				return true;
			}else {
				System.out.println("Tek kontrol yapildi, sonuc basarisiz");
				return false;
			}
		}
		for (CustomerCheckService checkService : checkServices) {
			comparisonLength--;
			if (checkService.checkCustomer(customer) && comparisonLength == 0) {
				System.out.println("Coklu kontrol yapildi, sonuc basarili");
				return true;
			}
		}
		System.out.println("Coklu kontrol yapildi, sonuc basarisiz");
		return false;
	}

}
