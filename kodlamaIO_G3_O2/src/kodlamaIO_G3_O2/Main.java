package kodlamaIO_G3_O2;

public class Main {

	public static void main(String[] args) {
		InstructorManager instructorManager = new InstructorManager();
		StudentManager studentManager = new StudentManager();
		
		Instructor engin = new Instructor(0,"engin-demirog", "1234");
		Student mert = new Student(1,"b181210395");
				
		UserUI userUI = new UserUI();
		
		userUI.addUser(instructorManager, engin);
		userUI.addUser(studentManager, mert);
		
		
	}

}
