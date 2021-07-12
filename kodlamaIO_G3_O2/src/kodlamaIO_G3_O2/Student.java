package kodlamaIO_G3_O2;

public class Student extends User{
	
	public Student(int id) {
		super(id);
	}
	
	public Student(int id, String schoolNumber) {
		super(id);
		this.schoolNumber = schoolNumber;
	}
	
	public Student(int id, String nationalIdentity, String phoneNumber, String schoolNumber) {
		super(id, nationalIdentity, phoneNumber);
		this.schoolNumber = schoolNumber;
	}
	
	String schoolNumber;
}
