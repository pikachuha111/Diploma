package tests.api;

import baseEntities.BaseApiTest;
import models.User;
import org.testng.annotations.Test;

public class UserTests extends BaseApiTest {

    @Test (description = "POST failed Log In test")
    public void failedLogInTest() {
        userAdapter.failedLogIn(incorrectUser);
    }

    @Test (description = "POST user is not found test")
    public void authorizedUserIsNotFoundTest() {
        userAdapter.failedAuthorizedUser(incorrectUser);
    }

    @Test (description = "POST authorization by secure data")
    public void adminAuthorization() {
        User admin = new User();
        admin.setUserName(System.getProperty("adminLogin"));
        admin.setPassword(System.getProperty("adminPassword"));
        userAdapter.logIn(admin);
    }
}
