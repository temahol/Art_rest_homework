import helpers.TestBase;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class RestTests extends TestBase {

    @Test
    void createNewUser() {
        given()
                .when()
                .body(createUserBody)
                .post(baseUrl + createUser)
                .then()
                .statusCode(201)
                .log().body()
                .body("$", hasKey("id"))
                .body("$", hasKey("createdAt"));
    }

    @Test
    void updateUser() {
        given()
                .when()
                .body(updateUserBody)
                .put(baseUrl + putUpdateUser)
                .then()
                .statusCode(200)
                .log().all()
                .body("$", hasKey("updatedAt"));
    }

    @Test
    void deleteUser() {
        given()
                .when()
                .delete(baseUrl + deleteUser)
                .then()
                .statusCode(204)
                .log().all();
    }

    @Test
    void checkTotal() {
        given()
                .when()
                .get(baseUrl + listOfUsers)
                .then()
                .statusCode(200)
                .log().all()
                .assertThat()
                .body("total_pages", is(2));
    }

    @Test
    void checkAllLastNames() {
        given()
                .when()
                .get(baseUrl + listOfUsers)
                .then()
                .statusCode(200)
                .log().all()
                .assertThat()
                .body("data.last_name", hasItems("Lawson", "Ferguson", "Funke", "Fields", "Edwards", "Howell"));
    }

}
