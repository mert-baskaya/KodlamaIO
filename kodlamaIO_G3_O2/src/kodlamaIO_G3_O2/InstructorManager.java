package kodlamaIO_G3_O2;

public class InstructorManager extends UserManager{
	@Override
	public void add(User user) {
		System.out.println(user.id + " eklendi (Instructor)");
	}
	@Override
	public void addBulk(User[] users) {
		for (User user : users) {
			System.out.println(user.id + " coklu eklendi (Instructor)");
		}
	}
}
