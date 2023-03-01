package adapters;

import io.restassured.mapper.ObjectMapperType;
import models.User;
import org.apache.http.HttpStatus;
import utils.EndPoints;

import java.io.File;

import static io.restassured.RestAssured.given;

public class UserAdapter {
    private File userFile = new File("src/test/resources/user.json");
    private File userNewFile = new File("src/test/resources/userOne.json");

    public User createUser() {
        return given()
                .body(userNewFile)
                .when()
                .post(EndPoints.CREATE_USER)
                .then()
                .statusCode(HttpStatus.SC_CREATED)
                .log().body()
                .extract()
                .as(User.class, ObjectMapperType.GSON);
    }

    public User logIn(User user) {

        return given()
                .body(userNewFile)
                .when()
                .post(EndPoints.LOGIN_USER)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body()
                .extract()
                .as(User.class, ObjectMapperType.GSON);
    }

    public void authorized() {
        given()
                .body(userFile)
                .when()
                .post(EndPoints.AUTHORIZED_USER)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body();
    }

    public void generateToken() {
        given()
                .body(userFile)
                .when()
                .post(EndPoints.GENERATE_TOKEN_USER)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body();
    }

    public void deleteUser(User user) {
        given()
                .pathParams("uuid", user.getUserId())
                .when()
                .delete(EndPoints.DELETE_USER)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body();

    }

}
