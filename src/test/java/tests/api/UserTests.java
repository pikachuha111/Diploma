package tests.api;

import baseEntities.BaseApiTest;
import org.testng.annotations.Test;

public class UserTests extends BaseApiTest {

    @Test
    public void testOne() {
//        userAdapter.logIn();
//        userAdapter.authorized();
//        userAdapter.generateToken();
//        User.builder()
//                .userName("nSolovev")
//                .userPassword("test!N_01")
//                .build()
    }

//    @Test
//    public void createUser() {
//        userAdapter.createUser();
//    }

    @Test(dependsOnMethods = "generateToken")
    public void deleteUser() {
        userAdapter.deleteUser(actualUser);
    }

    @Test(dependsOnMethods = "generateToken")
    public void logIn() {
        userAdapter.logIn(userLogin);
    }

    @Test
    public void generateToken() {
       userAdapter.generateToken(userLogin);
    }
}
