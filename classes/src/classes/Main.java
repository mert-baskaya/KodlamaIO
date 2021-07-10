package classes;

public class Main {

	public static void main(String[] args) {

		// setting product instances
		Product hp = new Product(0, "hp-15", 2500, 20);
		Product lenovo = new Product(1, "yi-16", 4500, 5);
		Product dell = new Product(2, "inspiron-15", 3100, -5);

		ProductManager productManager = new ProductManager();

		Product[] products = { hp, lenovo, dell };

		for (Product product : products) {
			productManager.setProduct(product);
			product = productManager.calculateDiscountedPrice();
		}

		for (Product product : products) {
			System.out.println(product.getName() + " " + product.getPrice() + " " + product.getDiscountPercentage()
					+ " " + product.getDiscountedPrice());
		}

		
		
	}
}
