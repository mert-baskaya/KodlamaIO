package classesWithAttributes;

public class Main {

	public static void main(String[] args) {
		ProductManager productManager = new ProductManager();
		Product product = new Product();
		product.setId(0);
		product.setName("HP Laptop");
		product.setDescription("16\" laptop");
		product.setPrice(5000);
		product.setStockAmount(75);
		
		productManager.ekle(product);
		
	}

}
