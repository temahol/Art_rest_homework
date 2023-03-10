import model.lombok.TestBaseLombok;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;
import static specs.Specs.*;

public class RestTests {

    @Test
    @Tag("homework")
    void createNewUser() {

        TestBaseLombok testLombok = new TestBaseLombok();
        testLombok.setName("morpheus");
        testLombok.setJob("leader");


        step("create new user", () ->
                given(requestSpec)
                        .when()
                        .body(testLombok)
                        .post("/api/users")
                        .then()
                        .spec(responseSpec)
        );

    }

    @Test
    @Tag("homework")
    void updateUser() {

        TestBaseLombok testLombok = new TestBaseLombok();
        testLombok.setUpdateName("update-user");
        testLombok.setUpdateJob("update-job");


        step("update user by put method", () ->
                given(requestSpec)
                        .when()
                        .body(testLombok)
                        .put("/api/users/2")
                        .then()
                        .spec(responseUpdateSpec));
    }

    @Test
    @Tag("homework")
    void deleteUser() {

        step("delete created user", () ->
                given(requestSpec)
                        .when()
                        .delete("/api/users/2")
                        .then()
                        .spec(responseDeleteSpec));
    }

    @Test
    @Tag("homework")
    void checkTotal() {

        step("check total pages in response", () ->
                given(requestSpec)
                        .when()
                        .get("/api/users?page=2")
                        .then()
                        .spec(responseTotalSpec));
    }

    @Test
    @Tag("homework")
    void checkAllLastNames() {

        step("check all last names of users", () ->
                given(requestSpec)
                        .when()
                        .get("/api/users?page=2")
                        .then()
                        .spec(responseLastNamesSpec)
                        .body("data.last_name",
                                hasItems("Lawson", "Ferguson", "Funke", "Fields", "Edwards", "Howell")));
    }
}
