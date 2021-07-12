package kodlamaIO_G3_O2;

public class Instructor extends User{
	
	public Instructor(int id) {
		super(id);
	}
	
	public Instructor(int id, String instructorID, String instructorPW) {
		super(id);
		this.instructorID = instructorID;
		this.instructorPW = instructorPW;
	}
	
	public Instructor(int id, String nationalIdentity, String phoneNumber, String instructorID, String instructorPW) {
		super(id, nationalIdentity, phoneNumber);
		this.instructorID = instructorID;
		this.instructorPW = instructorPW;
	}
	
	String instructorID;
	String instructorPW;
}
