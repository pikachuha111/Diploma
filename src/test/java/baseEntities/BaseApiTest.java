package baseEntities;

import adapters.BookAdapter;
import adapters.UserAdapter;
import configuration.ReadProperties;
import io.qameta.allure.internal.shadowed.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import models.CollectionBooks;
import models.User;
import org.apache.http.protocol.HTTP;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;

import static io.restassured.RestAssured.given;

public class BaseApiTest {
    protected UserAdapter userAdapter;
    protected BookAdapter bookAdapter;
    protected User user;
    protected User actualUser;
    protected User incorrectUser;
    protected CollectionBooks collectionBooks;

    @BeforeTest
    public void setupApi() {

        ObjectMapper mapper = new ObjectMapper();

        try {
            user = mapper.readValue(new File("src/test/resources/testUser.json"), User.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        RestAssured.baseURI = ReadProperties.getUrl();
        RestAssured.requestSpecification = given()
                .header(HTTP.CONTENT_TYPE, ContentType.JSON);

        userAdapter = new UserAdapter();
        bookAdapter = new BookAdapter();
        collectionBooks = new CollectionBooks();
        userAdapter.createUser(user);
        actualUser = userAdapter.logIn(user);
        incorrectUser = new User();

        RestAssured.requestSpecification = given()
                .auth().preemptive().basic(user.getUserName(), user.getPassword())
                .header(HTTP.CONTENT_TYPE, ContentType.JSON);

    }


    @AfterTest
    public void tearDown() {
        userAdapter.deleteUser(actualUser); // сам сайт при удалении пользователя возвращает 204, пользователь удаляется но это несоответсвие спеки swagger, на удивление postman отдает 200, если повторить те же действия
    }
}