package baseEntities;

import adapters.BooksAdapter;
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
    protected BooksAdapter booksAdapter;
    protected User user;
    protected User actualUser;
    protected CollectionBooks collectionBooks;

    @BeforeTest
    public void setupApi() {

        ObjectMapper mapper = new ObjectMapper();

        try {
            user = mapper.readValue(new File("src/test/resources/userOne.json"), User.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

//        System.out.println(userLogin.toString()); // удалить

        RestAssured.baseURI = ReadProperties.getUrl();
        RestAssured.requestSpecification = given()
                .header(HTTP.CONTENT_TYPE, ContentType.JSON);

        userAdapter = new UserAdapter();
        booksAdapter = new BooksAdapter();
        collectionBooks = new CollectionBooks();
        userAdapter.createUser(user);
        actualUser = userAdapter.logIn(user);
//        userAdapter.generateToken(user);

        System.out.println(actualUser.toString());

        RestAssured.requestSpecification = given()
                .auth().preemptive().basic(user.getUserName(), user.getPassword())
                .header(HTTP.CONTENT_TYPE, ContentType.JSON); // *обязательно, тип формата передачи данных

    }


    @AfterTest
    public void tearDown() {
//        userAdapter.deleteUser(actualUser); // почему то не удаляется пользователь, хотя при тех же степах в Postman и в Swagger сайта все получается
    }
}