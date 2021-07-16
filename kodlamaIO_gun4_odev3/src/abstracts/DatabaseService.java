package abstracts;

import entities.Campaign;

public interface DatabaseService {
	// Secilecek database'in hangi tipten entity'lere mudehale edecegini bildirmek
	// gerek
	public void addToDb(Entity entity);

	public Entity selectFromDb(int index);

	public void editSelected(Entity entity);
	
	public void updateForCampaign(Campaign campaign);

	public void deleteSelected();

	public void deleteById(int id);

	public Entity selectById(int id);
}
