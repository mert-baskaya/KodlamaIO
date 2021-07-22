package eCommerce.business.concretes;

import java.util.ArrayList;
import java.util.List;

import eCommerce.business.abstracts.VerificationService;
import eCommerce.core.utils.Utils;
import eCommerce.entities.concretes.Customer;

public class MailVerificationManager implements VerificationService {

	//burasi veritabanindan kontrol ederek yapilmali
	List<String> verifiedEmails = new ArrayList<String>();

	@Override
	public boolean verify(Customer customer) {
		String email = customer.getCustomerEmail();
		if (checkIfValidEmail(email) && !checkIfDuplicateEmail(email)) {
			verifiedEmails.add(email);
			return true;
		} else {
			return false;
		}
	}

	private boolean checkIfValidEmail(String email) {
		return Utils.checkEmail(email);
	}

	private boolean checkIfDuplicateEmail(String email) {
		if (verifiedEmails.contains(email)) {
			return true;
		} else {
			return false;
		}
	}
}
