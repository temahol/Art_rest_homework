import helpers.TestBase;
import io.restassured.response.Response;
import model.lombok.TestBaseLombok;
import model.lombok.TestBaseLombokResponse;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.Matchers.*;
import static helpers.CustomAllureListener.withCustomTemplates;

public class RestTests {

    @Test
    void createNewUser() {

        TestBaseLombok testLombok = new TestBaseLombok();
        testLombok.setCreateUser(testLombok.createUserBody);
        testLombok.setBaseUrl(testLombok.baseUrl);
        testLombok.setCreateUser(testLombok.createUser);

        TestBaseLombokResponse lombokResponse = given()
                .filter(withCustomTemplates())
                .when()
                .body(testLombok.createUserBody)
                .post(testLombok.baseUrl + testLombok.createUser)
                .then()
                .statusCode(201)
                .log().body()
                .body("$", hasKey("id"))
                .body("$", hasKey("createdAt"))
                .extract().as(TestBaseLombokResponse.class);

        assertThat(lombokResponse.getId()).isNotNull();
        assertThat(lombokResponse.getCreatedAt()).isNotNull();
    }

    @Test
    void updateUser() {

        TestBaseLombok testLombok = new TestBaseLombok();
        testLombok.setUpdateUserBody(testLombok.updateUserBody);
        testLombok.setBaseUrl(testLombok.baseUrl);
        testLombok.setPutUpdateUser(testLombok.putUpdateUser);

        given()
                .filter(withCustomTemplates())
                .when()
                .body(testLombok.updateUserBody)
                .put(testLombok.baseUrl  + testLombok.putUpdateUser)
                .then()
                .statusCode(200)
                .log().all()
                .body("$", hasKey("updatedAt"));
    }

    @Test
    void deleteUser() {

        TestBaseLombok testLombok = new TestBaseLombok();
        testLombok.setBaseUrl(testLombok.baseUrl);
        testLombok.setDeleteUser(testLombok.deleteUser);

        given()
                .filter(withCustomTemplates())
                .when()
                .delete(testLombok.baseUrl + testLombok.deleteUser)
                .then()
                .statusCode(204)
                .log().all();
    }

    @Test
    void checkTotal() {

        TestBaseLombok testLombok = new TestBaseLombok();
        testLombok.setBaseUrl(testLombok.baseUrl);
        testLombok.setListOfUsers(testLombok.listOfUsers);

        given()
                .filter(withCustomTemplates())
                .when()
                .get(testLombok.baseUrl + testLombok.listOfUsers)
                .then()
                .statusCode(200)
                .log().all()
                .assertThat()
                .body("total_pages", is(2));
    }

    @Test
    void checkAllLastNames() {

        TestBaseLombok testLombok = new TestBaseLombok();
        testLombok.setBaseUrl(testLombok.baseUrl);
        testLombok.setListOfUsers(testLombok.listOfUsers);

        given()
                .filter(withCustomTemplates())
                .when()
                .get(testLombok.baseUrl + testLombok.listOfUsers)
                .then()
                .statusCode(200)
                .log().all()
                .assertThat()
                .body("data.last_name", hasItems("Lawson", "Ferguson", "Funke", "Fields", "Edwards", "Howell"));
    }

}
