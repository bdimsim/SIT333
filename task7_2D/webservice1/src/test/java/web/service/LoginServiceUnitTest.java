package web.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginServiceUnitTest {
    // Decision Table Testing
    @Test
    public void testLoginSuccess() {
        Assertions.assertTrue(
            LoginService.login("bdim", "bdim_pass", "2002-02-03")
        );
    }

    @Test
    public void testDontCareValuesLoginFailure() {
        Assertions.assertFalse(
            LoginService.login("dontcareusername", "dontcarepassword", "dontcaredate")
        );
    }

    // Boundary Value Testing
    @Test
    public void testNullUsernameLoginFailure() {
        Assertions.assertFalse(
            LoginService.login(null, "bdim_pass", "2002-02-03")
        );
    }

    @Test
    public void testNullPasswordLoginFailure() {
        Assertions.assertFalse(
            LoginService.login("bdim", null, "2002-02-03")
        );
    }

    @Test
    public void testNullDobLoginFailure() {
        Assertions.assertFalse(
            LoginService.login("bdim", "bdim_pass", null)
        );
    }

    @Test
    public void testInvalidDobRangeLoginFailure() {
        Assertions.assertFalse(
            LoginService.login("bdim", "bdim_pass", "2002-02-29")
        );
    }

    @Test
    public void testInvalidDobFormatLoginFailure() {
        Assertions.assertFalse(
            LoginService.login("bdim", "bdim_pass", "abc")
        );
    }

    // Coverage Testing
    @Test 
    public void testWrongDobLoginFailure() {
        Assertions.assertFalse(
            LoginService.login("bdim", "bdim_pass", "2002-02-04")
        );
    }

    @Test
    public void testLoginServiceConstructor() {
        LoginService obj = new LoginService();
        Assertions.assertNotNull(obj);
    }
}