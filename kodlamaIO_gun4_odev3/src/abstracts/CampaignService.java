package abstracts;

import entities.Campaign;

public interface CampaignService {
	void add(Campaign campaign);
	
	Campaign get(int id);
	
	void edit(Campaign campaign);
	
	void delete(int id);
}
