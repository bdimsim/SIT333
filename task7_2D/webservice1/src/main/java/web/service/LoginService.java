package web.service;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

// Business logic to handle login functions.
public class LoginService {
	// Static method returns true for successful login, false otherwise.
	public static boolean login(String username, String password, String dob) {
		if (dob == null) return false;
	
		LocalDate date;

		try {
			date = LocalDate.parse(dob);
		} catch (DateTimeParseException e) {
			return false;
		}

		return "bdim".equals(username) 
			&& "bdim_pass".equals(password)
			&& date.equals(
				LocalDate.of(2002, 2, 3) // YYYY-MM-DD
			   ); 
	}
}