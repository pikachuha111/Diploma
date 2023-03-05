package adapters;

import io.restassured.mapper.ObjectMapperType;
import models.User;
import org.apache.http.HttpStatus;
import utils.EndPoints;

import static io.restassured.RestAssured.given;

public class UserAdapter {

    public User createUser(User user) {

        return given()
                .body(user, ObjectMapperType.GSON)
                .when()
                .post(EndPoints.CREATE_USER)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_CREATED)
                .extract()
                .as(User.class, ObjectMapperType.GSON);
    }

//    public void generateToken(User user) {
//        given()
//                .body(user, ObjectMapperType.GSON)
//                .when()
//                .post(EndPoints.GENERATE_TOKEN_USER)
//                .then()
//                .statusCode(HttpStatus.SC_OK);
//    }

    public User logIn(User user) {

        return given()
                .body(user, ObjectMapperType.GSON)
                .log().body()
                .when()
                .post(EndPoints.LOGIN_USER)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body()
                .extract()
                .as(User.class, ObjectMapperType.GSON);
    }

    public void authorized(User user) {
        given()
                .body(user, ObjectMapperType.GSON)
                .when()
                .post(EndPoints.AUTHORIZED_USER)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body();
    }

    public void getUser(User user) {
        given()
                .pathParams("uuid", user.getUserId())
                .when()
                .get(EndPoints.GET_USER)
                .then()
                .statusCode(HttpStatus.SC_OK);
    }

    public void deleteUser(User user) {
        given()
                .pathParams("uuid", user.getUserId())
                .when()
                .delete(EndPoints.DELETE_USER)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_NO_CONTENT);

    }



}
