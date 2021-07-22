package eCommerce.business.concretes;

import eCommerce.business.abstracts.CustomerCheckService;
import eCommerce.business.abstracts.CustomerService;
import eCommerce.business.abstracts.TwoFactorAuthenticationService;
import eCommerce.dataAccess.abstracts.CustomerDao;
import eCommerce.entities.concretes.Customer;

public class CustomerManager implements CustomerService {

	private CustomerCheckService checkService;
	private TwoFactorAuthenticationService authenticationService;
	private CustomerDao dao;

	public CustomerManager(CustomerCheckService checkService, TwoFactorAuthenticationService authenticationService,
			CustomerDao dao) {
		this.checkService = checkService;
		this.authenticationService = authenticationService;
		this.dao = dao;
	}

	@Override
	public boolean signIn(Customer customer) {
		// buraya gelen customer'in guvenilirligi yok, dolayisi ile sadece eposta-sifre
		// kombinasyonuna bakilmali
		if (dao.get(customer.getCustomerEmail()) == null) {
			System.out.println("Email sisteme kayitli degil");
			return false;
		}
		if (dao.get(customer.getCustomerEmail()).getCustomerPassword() == customer.getCustomerPassword()) {
			System.out.println("Sifre dogru, iki adimli dogrulama cagirildi");
			if (authenticate(customer)) {
				System.out.println("Dogrulama basarili, giris yapildi");
				return true;
				// buraya timeout eklemek gerek, gelen linke tiklanmazsa ne olacak?
			} else {
				System.out.println("Dogrulama basarisiz, giris yapilamadi");
				return false;
			}
		} else {
			// gercek hayatta bunu yapma mert
			System.out.println("Sifre yanlis, giris yapilamadi");
			return false;
		}
	}

	@Override
	public boolean signUp(Customer customer) {
		if (checkService.checkCustomer(customer)) {
			// eger kayit olurken mail dogrulama yapmazsak giris yaparken yaptigimiz mail
			// dogrulama anlamsiz olur
			if (authenticate(customer)) {
				System.out.println("Dogrulama basarili, kayit yapildi");
				dao.add(customer);
				return true;
				// buraya timeout eklemek gerek, gelen linke tiklanmazsa ne olacak?
			} else {
				System.out.println("Dogrulama basarisiz, kayit yapilamadi");
				return false;
			}
		} else {
			System.out.println("Musteri bilgileri gecersiz");
			return false;
		}
	}

	private boolean authenticate(Customer customer) {
		return authenticationService.authenticateCustomer(customer);
	}

	@Override
	public boolean deleteAccount(Customer customer) {
		if (signIn(customer)) {
			dao.delete(customer);
			return true;
		}else {
			return false;
		}

	}

}
