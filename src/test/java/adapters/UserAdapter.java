package adapters;

import io.restassured.mapper.ObjectMapperType;
import models.User;
import org.apache.http.HttpStatus;
import utils.EndPoints;

import static io.restassured.RestAssured.given;

public class UserAdapter {

    public User logIn(User user) {

        return  given()
                .body(user, ObjectMapperType.GSON)
                .when()
                .post(EndPoints.LOGIN_USER)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .log().body()
                .extract()
                .as(User.class, ObjectMapperType.GSON);
    }
}
