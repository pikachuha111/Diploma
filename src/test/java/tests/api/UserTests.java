package tests.api;

import baseEntities.BaseApiTest;
import org.testng.annotations.Test;

public class UserTests extends BaseApiTest {

    @Test
    public void failedLogInTest() {
        incorrectUser.setUserName("IncorrectName0");
        incorrectUser.setPassword("IncorrectPassword0");
        System.out.println(incorrectUser.toString());
        userAdapter.failedLogIn(incorrectUser);
    }
}
