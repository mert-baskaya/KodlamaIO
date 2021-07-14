package concrete;

import abstractEntitites.CustomerCheckService;
import entities.Customer;

public class CustomerCheckManager implements CustomerCheckService {
	
	int comparisonLength,trueLength = 0;


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
			//mantik hatasi, ilk kontrolleri umursamiyor sadece son kontrole bakiyor
			comparisonLength--;
			boolean result = checkService.checkCustomer(customer);
			if (result && comparisonLength == 0) {
				System.out.println("Coklu kontrol yapildi, sonuc basarili");
				return true;
			} else if(!result && comparisonLength !=0) {
				System.out.println("Coklu kontrol yapildi, sonuc basarisiz");
				return false;
			}
		}
		System.out.println("Coklu kontrol yapildi, sonuc basarisiz");
		return false;
	}

}
