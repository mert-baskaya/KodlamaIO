package kodlamaio.hrms.core.utilities;

public class EmailChecker {
	public static boolean checkEmailDomainConsistancy(String webAdress, String email) {
		return webAdress.contains(email.split("@")[1]);
	}
	
	//TODO regex email dogrulama
}
