package adapters;

import io.restassured.mapper.ObjectMapperType;
import models.User;
import org.apache.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.EndPoints;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class UserAdapter {
    Logger logger = LogManager.getLogger(UserAdapter.class);

    public User createUser(User user) {

        logger.info("Creating user method... ");

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

    public User logIn(User user) {

        logger.info("Logging user method... ");

        return given()
                .body(user, ObjectMapperType.GSON)
                .when()
                .post(EndPoints.LOGIN_USER)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body()
                .extract()
                .as(User.class, ObjectMapperType.GSON);
    }

    public void failedLogIn(User user) {

        logger.info("Failing login method ... ");

        String expectedResult = "User authorization failed.";

        given()
                .body(user, ObjectMapperType.GSON)
                .when()
                .post(EndPoints.GENERATE_TOKEN_USER)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body()
                .body("result", is(expectedResult));
    }

    public void failedAuthorizedUser(User user) {

        logger.info("Failed authorized user method ...");

        String message = "User not found!";

        given()
                .body(user, ObjectMapperType.GSON)
                .when()
                .post(EndPoints.AUTHORIZED_USER)
                .then()
                .statusCode(HttpStatus.SC_NOT_FOUND)
                .log().body()
                .body("message", is(message));

    }

    public void getUser(User user) {

        logger.info("Get user method ...");

        given()
                .pathParams("uuid", user.getUserId())
                .when()
                .get(EndPoints.GET_USER)
                .then()
                .statusCode(HttpStatus.SC_OK);
    }

    public void deleteUser(User user) {

        logger.info("Delete user method ...");

        given()
                .pathParams("uuid", user.getUserId())
                .when()
                .delete(EndPoints.DELETE_USER)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_NO_CONTENT);

    }


}
