package entities;

import java.util.ArrayList;
import java.util.List;

import abstracts.Entity;

public class Campaign extends Entity {
	private float discountRate;
	private String campaignName;
	private List<Integer> discountedGameIDs;

	public Campaign(int id, float discountRate, String campaignName) {
		super(id);
		this.discountRate = discountRate;
		this.campaignName = campaignName;
		this.discountedGameIDs = new ArrayList<Integer>();
	}
	
	public Campaign(int id, float discountRate, String campaignName, ArrayList<Integer> disountedGameIDs) {
		super(id);
		this.discountRate = discountRate;
		this.campaignName = campaignName;
		this.discountedGameIDs = disountedGameIDs;
	}
	
	public float getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(float discountRate) {
		this.discountRate = discountRate;
	}

	public String getCampaignName() {
		return campaignName;
	}

	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}
	//bu sanki campaign managerda da yapilabilirdi
	public List<Integer> getGameIDs(){
		return discountedGameIDs;
	}
	
	public void setGameIDs(ArrayList<Integer> discountedGameIDs) {
		this.discountedGameIDs = discountedGameIDs;
	}

}
