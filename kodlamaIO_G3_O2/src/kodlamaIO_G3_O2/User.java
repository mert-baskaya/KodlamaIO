package kodlamaIO_G3_O2;

public class User {
	
	public User() {
		
	}
	
	public User(int id) {
		this.id = id;
	}
	
	public User(int id, String nationalIdentity, String phoneNumber) {
		this.id = id;
		this.nationalIdentity = nationalIdentity;
		this.phoneNumber = phoneNumber;
	}
	
	int id;
	String nationalIdentity;
	String phoneNumber;
}
