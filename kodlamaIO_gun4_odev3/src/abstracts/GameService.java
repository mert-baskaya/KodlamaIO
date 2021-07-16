package abstracts;

import entities.Campaign;
import entities.Game;

public interface GameService {
	void add(Game game);

	Game get(int id);

	void edit(Game game);

	void delete(int id);
	
	void refreshPrices(Campaign campaign);
}
