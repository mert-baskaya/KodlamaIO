package classes;

public class ProductManager {

	Product product;
	
	
	public ProductManager() {

	}

	public ProductManager(Product product) {
		this.product = product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Product calculateDiscountedPrice() {

		if (product.getDiscountPercentage() == 0)
			return product;

		else if (product.getDiscountPercentage() != 0 && product.getDiscountPercentage() > 0) {
			product.setDiscountedPrice(
					product.getPrice() - (product.getPrice() * product.getDiscountPercentage() / 100));

			System.out.println(product.getId() + " ID'li ürünün indirimi hesaplandi!");
		}

		else {
			System.out.println("Ürün indirim orani hatali girildi!");
			product.setDiscountedPrice(-1);
			return product;
		}

		return product;
	}
	
	// TODO product üretip geri döndürecek metod
	
}
