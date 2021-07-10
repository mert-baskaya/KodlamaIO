package classesWithAttributes;

public class Main {

	public static void main(String[] args) {
		ProductManager productManager = new ProductManager();
		Product product = new Product();
		product.id = 0;
		product.name = "HP Laptop";
		product.description = "16\" laptop";
		product.price = 5000;
		product.stockAmount = 75;
		
		productManager.ekle(product);
		
	}

}
