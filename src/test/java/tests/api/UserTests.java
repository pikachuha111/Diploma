package tests.api;

import baseEntities.BaseApiTest;
import models.User;
import org.testng.annotations.Test;

public class UserTests extends BaseApiTest {

    @Test
    public void failedLogInTest() {
        userAdapter.failedLogIn(incorrectUser);
    }

    @Test
    public void authorizedUserIsNotFoundTest() {
        userAdapter.failedAuthorizedUser(incorrectUser);
    }

    @Test
    public void adminAuthorization() {
        User admin = new User();
        admin.setUserName(System.getProperty("adminLogin"));
        admin.setPassword(System.getProperty("adminPassword"));
        userAdapter.logIn(admin);
    }
}
