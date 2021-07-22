package eCommerce.business.googleServices;

import eCommerce.business.abstracts.CustomerCheckService;
import eCommerce.business.abstracts.CustomerService;
import eCommerce.business.abstracts.TwoFactorAuthenticationService;
import eCommerce.dataAccess.abstracts.CustomerDao;
import eCommerce.entities.concretes.Customer;

@SuppressWarnings("unused")
public class GoogleAccountAuthAdapter implements CustomerService {

	private CustomerCheckService checkService;
	private TwoFactorAuthenticationService authenticationService;
	private CustomerDao dao;
	// google servisi simulasyonu...

	public GoogleAccountAuthAdapter(CustomerCheckService checkService, TwoFactorAuthenticationService authenticationService,
			CustomerDao dao) {
		this.checkService = checkService;
		this.authenticationService = authenticationService;
		this.dao = dao;
	}
	@Override
	public boolean signIn(Customer customer) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean signUp(Customer customer) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean deleteAccount(Customer customer) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
