package baseEntities;

//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import configuration.ReadProperties;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import models.User;
import org.apache.http.protocol.HTTP;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;

import static io.restassured.RestAssured.given;

public class BaseApiTest {
    protected Gson gson;

    @BeforeTest
    public void setupApi() {

        gson = new Gson();
        gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();

        File file = new File("src/test/resources/userOne.json");

        User userLogin = gson.fromJson(file)

        RestAssured.baseURI = ReadProperties.getUrl();

        RestAssured.requestSpecification = given()
                .auth().preemptive().basic(ReadProperties.username(), ReadProperties.password())
                .header(HTTP.CONTENT_TYPE, ContentType.JSON); //?

    }


//    @AfterTest
}