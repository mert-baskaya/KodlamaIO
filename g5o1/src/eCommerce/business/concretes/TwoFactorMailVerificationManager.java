package eCommerce.business.concretes;

import eCommerce.business.abstracts.TwoFactorAuthenticationService;
import eCommerce.entities.concretes.Customer;

public class TwoFactorMailVerificationManager implements TwoFactorAuthenticationService {

	private Mail mail = new Mail();

	@Override
	public boolean authenticateCustomer(Customer customer) {
		sendEmail(mail);
		if (response()) {
			System.out.println("Mail dogrulama gerceklesti: " + customer.getCustomerEmail());
			return true;
		} else {
			System.out.println("Mail dogrulama basarisiz: " + customer.getCustomerEmail());
			return false;
		}

	}

	private void sendEmail(Mail mail) {

	}

	private boolean response() {
		return true;
	}

	private class Mail {
		// mail objesi uretilip gonderilir

		@SuppressWarnings("unused")
		String text;
	}
}
