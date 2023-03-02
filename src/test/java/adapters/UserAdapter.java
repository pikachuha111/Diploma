package adapters;

import io.restassured.mapper.ObjectMapperType;
import models.UserLogin;
import org.apache.http.HttpStatus;
import utils.EndPoints;

import java.io.File;

import static io.restassured.RestAssured.given;

public class UserAdapter {
//    private File userFile = new File("src/test/resources/user.json");

    public UserLogin createUser(UserLogin user) {

        return given()
                .body(user, ObjectMapperType.GSON)
                .when()
                .post(EndPoints.CREATE_USER)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_CREATED)
                .extract()
                .as(UserLogin.class, ObjectMapperType.GSON);
    }

    public UserLogin logIn(UserLogin user) {

        return given()
                .body(user, ObjectMapperType.GSON)
                .log().body()
                .when()
                .post(EndPoints.LOGIN_USER)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body()
                .extract()
                .as(UserLogin.class, ObjectMapperType.GSON);
    }

    public void authorized(UserLogin user) {
        given()
                .body(user, ObjectMapperType.GSON)
                .when()
                .post(EndPoints.AUTHORIZED_USER)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body();
    }

    public void generateToken(UserLogin user) {
        given()
                .body(user, ObjectMapperType.GSON)
                .when()
                .post(EndPoints.GENERATE_TOKEN_USER)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body();
    }

    public void deleteUser(UserLogin user) {
        given()
                .pathParams("uuid", user.getUserID())
                .when()
                .delete(EndPoints.DELETE_USER)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK);

    }

}
