package interfaces;

public class Main {

	public static void main(String[] args) {
		//CustomerManager customerManager = new CustomerManager(new DatabaseLogger());
		DatabaseLogger databaseLogger = new DatabaseLogger();
		SmsLogger smsLogger = new SmsLogger();
		FileLogger fileLogger = new FileLogger();
		Logger[] loggers = new Logger[] {databaseLogger, smsLogger, fileLogger};
		CustomerManager customerManager = new CustomerManager(loggers);
		Customer engin = new Customer(1, "Engin", "Demirog");
		customerManager.add(engin);
	}

}
