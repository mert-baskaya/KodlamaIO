package entities;

import abstracts.Entity;

public class Game extends Entity {

	private float price;
	private float discountedPrice;
	private String name;
	private String description;

	public Game(int id, float price, String name, String description) {
		super(id);
		this.price = price;
		this.name = name;
		this.description = description;
		this.discountedPrice = -1;
	}

	public float getPrice() {
		if(discountedPrice != -1) return getDiscountedPrice();
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getDiscountedPrice() {
		return discountedPrice;
	}

	public void setDiscountedPrice(float discountedPrice) {
		this.discountedPrice = discountedPrice;
	}

}
