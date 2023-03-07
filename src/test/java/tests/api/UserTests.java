package tests.api;

import baseEntities.BaseApiTest;
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
}
