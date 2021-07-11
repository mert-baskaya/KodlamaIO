package classes;

public class Product {
	
	private int id;
	private String name;
	private float price;
	private int discountPercentage;
	private float discountedPrice;

	public Product() {

	}

	public Product(int id, String name, float price, int discountPercentage) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.discountPercentage = discountPercentage;
	}

	

	// Get-Set section
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getDiscountPercentage() {
		return discountPercentage;
	}

	public void setDiscountPercentage(int discount) {

		this.discountPercentage = discount;
	}

	public float getDiscountedPrice() {
		return discountedPrice;
	}

	public void setDiscountedPrice(float discountedPrice) {
		this.discountedPrice = discountedPrice;
	}

}
