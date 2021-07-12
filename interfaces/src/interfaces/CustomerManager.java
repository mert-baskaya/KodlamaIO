package interfaces;

public class CustomerManager {
	
	/*----------------- loosely bound -----------------*/
	private Logger logger;
	
	public CustomerManager(Logger logger) {
		this.logger = logger;
	}
	/*-------------- dependency injection -------------*/
	
	public void add(Customer customer) {
		System.out.println("Musteri eklendi: " + customer.getFirstName());
		this.logger.log(customer.getFirstName());
	}
	
	public void delete(Customer customer) {
		System.out.println("Musteri silindi: " + customer.getFirstName());
	}
}
