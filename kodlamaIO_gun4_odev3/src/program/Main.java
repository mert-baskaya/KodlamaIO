package program;

import abstracts.CustomerCheckService;
import abstracts.DatabaseService;
import adapters.MernisServiceAdapter;
import adapters.MySqlAdapter;
import concrete.CampaignManager;
import concrete.CustomerCheckManager;
import concrete.CustomerManager;
import concrete.GameManager;
import concrete.TransactionManager;
import entities.Campaign;
import entities.Customer;
import entities.Game;

public class Main {

	public static void main(String[] args) {
		
		CustomerCheckService mernisCheckService = new MernisServiceAdapter();
		
		DatabaseService customerDb = new MySqlAdapter();
		DatabaseService gameDb = new MySqlAdapter();
		DatabaseService campaignDb = new MySqlAdapter();
		
		CustomerCheckManager checkManager = new CustomerCheckManager(mernisCheckService);
		CustomerManager customerManager = new CustomerManager(customerDb, checkManager);
		GameManager gameManager = new GameManager(gameDb);
		CampaignManager campaignManager = new CampaignManager(campaignDb, gameManager);
		TransactionManager transactionManager = new TransactionManager(customerManager);
		
		Game oyun = new Game(0, 120, "Oyun 1", "oyun 1");
		Game oyun2 = new Game(1, 60,"Oyun 2", "oyun 2");
		gameManager.add(oyun);
		gameManager.add(oyun2);
		
		Game[] games = {oyun, oyun2};
		
		Campaign kampanya = new Campaign(0, 15, "yaz kampanyasi");
		campaignManager.add(kampanya);
		campaignManager.addGameToCampaign(kampanya, oyun);
				
		
		Customer mert = new Customer(7, "kisi", "kisi", "01234567890", 1998);
		Customer fatma = new Customer(11, "kisi", "kisi", "01234567890", 1999);
		
		customerManager.add(mert);
		customerManager.add(fatma);
		
		customerManager.addFundsToWallet(mert, 200);
		
		transactionManager.buy(mert, oyun);
		
		transactionManager.buyMultiple(mert, games);
		
	}

}
