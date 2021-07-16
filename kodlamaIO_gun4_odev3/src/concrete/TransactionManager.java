package concrete;

import entities.Customer;
import entities.Game;

public class TransactionManager {
	private CustomerManager customerManager;

	public TransactionManager(CustomerManager customerManager) {
		this.customerManager = customerManager;
	}

	public void buy(Customer customer, Game game) {

		float balance = customer.getWalletBalance() - game.getPrice();

		if (balance >= 0) {
			System.out.println(
					"Alisveris basarili, musteri oyunu aldi: " + game.getName() + ". Kalan bakiyesi: " + balance);
			customer.setWalletBalance(balance);
			customer.addGameToLibrary(game);
			customerManager.edit(customer);
		} else {
			System.out.println("Alisveris basarisiz, cuzdanda yeterli para yok: " + balance);
		}
	}

	public void buyMultiple(Customer customer, Game[] games) {
		float sum = 0, balance = 0;
		for (Game game : games) {
			sum += game.getPrice();
		}

		balance = balance - sum + customer.getWalletBalance();

		if (balance >= 0) {
			for (Game game : games) {
				customer.addGameToLibrary(game);
			}
			customer.setWalletBalance(balance);
			customerManager.edit(customer);
			System.out.println("Alisveris basarili, kalan bakiye: " + customer.getWalletBalance());
		} else {
			System.out.println("Alisveris basarisiz, cuzdanda yeterli para yok: " + balance);
		}
	}
}