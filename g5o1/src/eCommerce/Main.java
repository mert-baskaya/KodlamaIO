package eCommerce;

import eCommerce.business.abstracts.CustomerCheckService;
import eCommerce.business.abstracts.CustomerService;
import eCommerce.business.abstracts.TwoFactorAuthenticationService;
import eCommerce.business.abstracts.VerificationService;
import eCommerce.business.concretes.CustomerCheckManager;
import eCommerce.business.concretes.CustomerManager;
import eCommerce.business.concretes.MailVerificationManager;
import eCommerce.business.concretes.TwoFactorMailVerificationManager;
import eCommerce.dataAccess.abstracts.CustomerDao;
import eCommerce.dataAccess.concretes.HibernateCustomerDao;
import eCommerce.entities.concretes.Customer;

public class Main {

	public static void main(String[] args) {

		VerificationService mailVerification = new MailVerificationManager();
		TwoFactorAuthenticationService mailAuthentication = new TwoFactorMailVerificationManager();
		CustomerCheckService customerVerification = new CustomerCheckManager(mailVerification);
		CustomerDao customerDao = new HibernateCustomerDao();
		CustomerService customerManager = new CustomerManager(customerVerification, mailAuthentication, customerDao);

		Customer musteri1 = new Customer(0, "Mert", "Baskaya", "mert@gmail.com", "123456");
		Customer musteri1Deneme = new Customer(0, "Mert", "Baskaya", "mert@gmail.com", "12344456");
		Customer musteri2 = new Customer(1, "Mert", "Baskaya", "mert11@gmail.com", "123456");
		
		System.out.println();
		customerManager.signUp(musteri1);
		System.out.println();
		customerManager.signIn(musteri1Deneme);
		System.out.println();
		customerManager.signIn(musteri1);
		System.out.println();
		customerManager.deleteAccount(musteri1);
		System.out.println();
		customerManager.signIn(musteri1);
		System.out.println();
		
		

	}

}
