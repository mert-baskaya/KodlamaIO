package inheritance;

public class Main {

	public static void main(String[] args) {
		IndividialCustomer engin = new IndividialCustomer();
		engin.id = 0;
		engin.customerNumber = "012";
		CorporateCustomer hepsiBurada = new CorporateCustomer();
		hepsiBurada.id = 1;
		hepsiBurada.customerNumber = "123";
		CustomerManager customerManager = new CustomerManager();
		
		customerManager.add(hepsiBurada);
		customerManager.add(engin);
		
		System.out.println(hepsiBurada.customerNumber + " " + engin.customerNumber);
		
		
	}

}
