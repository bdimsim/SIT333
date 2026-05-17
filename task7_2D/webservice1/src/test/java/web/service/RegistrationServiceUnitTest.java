package web.service;
import web.model.User;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RegistrationServiceUnitTest {
    @Test
    public void testNullInputRegistrationFailure() {
        User user = RegistrationService.register(
            null,
            "dimoski",
            "bdimoski@deakin.edu.au",
            "bdim_pass",
            "2002-02-03"
        );

        Assertions.assertNull(user);
    }

    @Test
    public void testEmptyInputRegistrationFailure() {
        User user = RegistrationService.register(
            "brandon",
            "",
            "bdimoski@deakin.edu.au",
            "bdim_pass",
            "2002-02-03"
        );

        Assertions.assertNull(user);
    }

    @Test
    public void testInvalidInputRegistrationFailure() {
        User user = RegistrationService.register(
            "brandon",
            "dimoski",
            "bdimoski@deakin.edu.au",
            "bdim_pass",
            "abc"
        );

        Assertions.assertNull(user);
    }

    @Test
    public void testValidInputRegistrationSuccess() {
        User user = RegistrationService.register(
            "brandon",
            "dimoski",
            "bdimoski@deakin.edu.au",
            "bdim_pass",
            "2002-02-03"
        );

        Assertions.assertNotNull(user);
    }
}