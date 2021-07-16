package concrete;

import abstracts.DatabaseService;
import abstracts.GameService;
import entities.Campaign;
import entities.Game;

public class GameManager implements GameService {
	// oyunlarin fiyat takibi burada olacak, refreshPrices metodu ile kampanya
	// eklenip silindiginde fiyatlar guncellenecek

	DatabaseService dbService;

	public GameManager(DatabaseService dbService) {
		this.dbService = dbService;
	}

	@Override
	public void add(Game game) {
		dbService.addToDb(game);
	}

	@Override
	public Game get(int id) {
		return (Game) dbService.selectById(id);
	}

	@Override
	public void edit(Game game) {
		dbService.editSelected(game);
	}

	@Override
	public void delete(int id) {
		dbService.deleteById(id);
	}

	@Override
	public void refreshPrices(Campaign campaign) {
		dbService.updateForCampaign(campaign);
	}
}
