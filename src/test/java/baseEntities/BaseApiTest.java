package baseEntities;

import adapters.UserAdapter;
import configuration.ReadProperties;
import io.qameta.allure.internal.shadowed.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import models.UserLogin;
import org.apache.http.protocol.HTTP;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;

import static io.restassured.RestAssured.given;

public class BaseApiTest {
    protected UserAdapter userAdapter;
    protected UserLogin userLogin;
    protected UserLogin actualUser;

    @BeforeTest
    public void setupApi() {

        ObjectMapper mapper = new ObjectMapper();

        try {
            userLogin = mapper.readValue(new File("src/test/resources/userOne.json"), UserLogin.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(userLogin.toString()); // удалить

        RestAssured.baseURI = ReadProperties.getUrl();
        RestAssured.requestSpecification = given()
                .header(HTTP.CONTENT_TYPE, ContentType.JSON);

        userAdapter = new UserAdapter();
        actualUser = userAdapter.createUser(userLogin);

        System.out.println(actualUser.toString());

        RestAssured.requestSpecification = given()
                .auth().preemptive().basic(userLogin.getUserName(),userLogin.getPassword())
                .header(HTTP.CONTENT_TYPE, ContentType.JSON); // короче очень важно для того, чтобы

    }


//    @AfterTest
}