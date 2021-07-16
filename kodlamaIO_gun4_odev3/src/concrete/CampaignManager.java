package concrete;

import java.util.*;

import abstracts.CampaignService;
import abstracts.DatabaseService;
import entities.Campaign;
import entities.Game;

public class CampaignManager implements CampaignService{
	
	GameManager gameManager;
	
	/* Dependency injection */
	DatabaseService dbService;
	
	public CampaignManager(DatabaseService dbService, GameManager gameManager) {
		this.dbService = dbService;
		this.gameManager = gameManager;
	}
	/* Dependency injection */
	
	@Override
	public void add(Campaign campaign) {
		dbService.addToDb(campaign);
		gameManager.refreshPrices(campaign);
	}
	//bunu duzelt olmaz boyle
	@Override
	public Campaign get(int id) {
		return (Campaign) dbService.selectById(id);
	}

	@Override
	public void edit(Campaign campaign) {
		dbService.editSelected(campaign);
	}

	@Override
	public void delete(int id) {
		dbService.deleteById(id);
	}
	
	public void addGameToCampaign(Campaign campaign, Game game) {
		ArrayList<Integer> list = (ArrayList<Integer>) campaign.getGameIDs();
		list.add(game.getId());
		campaign.setGameIDs(list);
	}
	//coklu ekleme, duzenleme ve silme de yapilmali 
}
