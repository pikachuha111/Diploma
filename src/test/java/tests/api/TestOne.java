package tests.api;

import adapters.UserAdapter;
import baseEntities.BaseApiTest;
import models.User;
import org.testng.annotations.Test;

public class TestOne extends BaseApiTest {
    UserAdapter userAdapter = new UserAdapter();

    @Test
    public void testOne() {
//        userAdapter.logIn();
//        userAdapter.authorized();
        userAdapter.generateToken();
//        User.builder()
//                .userName("nSolovev")
//                .userPassword("test!N_01")
//                .build()
    }

    @Test
    public void deleteUser() {
        userAdapter.deleteUser(
                userAdapter.logIn(
                        userAdapter.createUser()));
    }

    @Test
    public void checkIT() {

    }
}
