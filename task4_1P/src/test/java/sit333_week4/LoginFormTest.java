package sit333_week4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginFormTest {
	@Test
	public void testStudentIdentity() {
		String studentId = "220250896";
		Assertions.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Brandon";
		Assertions.assertNotNull("Student name is null", studentName);
	}
	
	@Test
    public void testFailEmptyUsernameAndEmptyPasswordAndDontCareValCode()
    {
		LoginStatus status = LoginForm.login(null, null);
		Assertions.assertTrue(status.isLoginSuccess() == false);
    }
	
	// #####################################################################
	// #							Test Cases							   #
	// #####################################################################
	@Test
	public void testFailEmptyUsernameDontCarePasswordAndDontCareValCode() {
		LoginStatus status = LoginForm.login(null, "dontcarepassword");
		Assertions.assertTrue(status.isLoginSuccess() == false);
	}

	@Test
	public void testFailCorrectUsernameEmptyPasswordAndDontCareValCode() {
		LoginStatus status = LoginForm.login("bdim", null);
		Assertions.assertTrue(status.isLoginSuccess() == false);
	}

	@Test
	public void testSuccessCorrectUsernameCorrectPasswordAndDontCareValCode() {
		LoginStatus status = LoginForm.login("bdim", "bdim_pass");
		Assertions.assertTrue(status.isLoginSuccess() == true);
	}

	@Test
	public void testFailDontCareUsernameDontCarePasswordAndDontCareValCode() {
		LoginStatus status = LoginForm.login("dontcareusername", "dontcarepassword");
		Assertions.assertTrue(status.isLoginSuccess() == false);
	}

	@Test
	public void testFailCorrectUsernameCorrectPasswordAndDontCareValCode() {
		LoginStatus status = LoginForm.login("bdim", "bdim_pass");
		Assertions.assertTrue(status.isLoginSuccess() == true);

		boolean valCodeStatus = LoginForm.validateCode("dontcarecode");
		Assertions.assertTrue(valCodeStatus == false);
	}

	@Test public void testFailCorrectUsernameCorrectPasswordAndCorrectValCode() {
		LoginStatus status = LoginForm.login("bdim", "bdim_pass");
		Assertions.assertTrue(status.isLoginSuccess() == true);
		
		boolean valCodeStatus = LoginForm.validateCode("123456");
		Assertions.assertTrue(valCodeStatus == true);
	}
}