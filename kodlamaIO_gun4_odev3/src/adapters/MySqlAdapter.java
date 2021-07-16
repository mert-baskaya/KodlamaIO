package adapters;

import java.util.ArrayList;
import java.util.List;

import abstracts.DatabaseService;
import abstracts.Entity;
import entities.Campaign;
import entities.Game;
import utils.Utils;

public class MySqlAdapter implements DatabaseService {

	/* Database operation simulation */
	List<Entity> entities = new ArrayList<Entity>();
	/* Database operation simulation */

	Entity entity;
	int selectedIndex;

	// burasi biraz corba oldu lakin sadece bir simulasyon olsugu icin ses etmiyorum

	@Override
	public void addToDb(Entity entity) {
		this.entities.add(entity);
	}

	@Override
	public Entity selectFromDb(int index) {
		this.selectedIndex = index;
		return entities.get(index);
	}

	@Override
	public void editSelected(Entity entity) {
		entities.set(selectedIndex, entity);
	}

	@Override
	public void deleteSelected() {
		entities.remove(selectedIndex);
	}

	@Override
	public Entity selectById(int id) {
		return Utils.findEntityById(id, entities);
	}

	@Override
	public void deleteById(int id) {

		entity = selectById(id);

		System.out.println(entity.getId() + " removed");

		entities.remove(selectById(id));
	}
	//burasi cok spagetti oldu farkindayim
	@Override
	public void updateForCampaign(Campaign campaign) {
		ArrayList<Integer> gameIDs = (ArrayList<Integer>) campaign.getGameIDs();
		Game game;
		for (Integer gameID : gameIDs) {
			game = (Game) Utils.findEntityById(gameID, entities);
			game.setDiscountedPrice(game.getPrice() - (game.getPrice() * (campaign.getDiscountRate() / 100)));
		}
	}

}
