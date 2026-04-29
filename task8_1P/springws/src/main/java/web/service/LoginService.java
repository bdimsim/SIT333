package web.service;

public class LoginService {
	// Static method returns true for successful login, false otherwise.
	public static boolean login(String username, String password, String dob) {
		// Match a fixed user name and password.
		if ("bdim".equals(username) && "bdim_pass".equals(password)) return true;
		return false;
	}
}