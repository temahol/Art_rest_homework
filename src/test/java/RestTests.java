import helpers.TestBase;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;

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
                .extract().path("id")
                ;
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
                .extract().response();
    }

    @Test
    void deleteUser() {
        given()
                .when()
                .delete(baseUrl + deleteUser)
                .then()
                .statusCode(204)
                .log().all()
                .extract().response();
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
