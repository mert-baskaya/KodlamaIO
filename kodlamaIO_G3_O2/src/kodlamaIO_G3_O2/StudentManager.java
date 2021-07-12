package kodlamaIO_G3_O2;

public class StudentManager extends UserManager{
	@Override
	public void add(User user) {
		System.out.println(user.id + " eklendi (Student)");
		//gelen ogrencinin bilgilerine nasil erisilebilir? (ogrenci numarasi)
		//gelen user'i database'e inject ederken onun ogrenci olup olmadiginin ayrimini nerede yapacagiz?
	}
	@Override
	public void addBulk(User[] users) {
		for (User user : users) {
			System.out.println(user.id + " coklu eklendi (Student)");
		}
	}
}
