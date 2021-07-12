package interfaces;

public class CustomerManager {
	
	/*----------------- loosely bound -----------------*/
	
	//private Logger logger;
	
	private Logger[] loggers;
	
	public CustomerManager(Logger[] loggers) {
		this.loggers = loggers;
	}
	
	/*-------------- dependency injection -------------*/
	
	public void add(Customer customer) {
		System.out.println("Musteri eklendi: " + customer.getFirstName());
		
		//this.logger.log(customer.getFirstName());
		
		for (Logger logger : loggers) {
			logger.log(customer.getFirstName());
		}
		
	}
	
	public void delete(Customer customer) {
		System.out.println("Musteri silindi: " + customer.getFirstName());
	}
}
