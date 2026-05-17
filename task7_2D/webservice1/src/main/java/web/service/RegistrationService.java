package web.service;

import web.model.User;

import java.util.List;
import java.util.Arrays;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class RegistrationService {
	public static User register(
		String fName, 
		String lName, 
		String email,
		String password,
		String dob
	) {
		List<String> fields = Arrays.asList(fName, lName, email, password, dob);
		
		// Do not register null or empty strings.
		for (String field : fields)
			if (field == null || field.isBlank())
				return null;
		
		LocalDate date;

		try {
			date = LocalDate.parse(dob);
		} catch (DateTimeParseException e) {
			return null;
		}

		return new User(fName, lName, email, password, date);
	}
}