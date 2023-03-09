import helpers.TestBase;
import io.restassured.response.Response;
import model.lombok.TestBaseLombok;
import model.lombok.TestBaseLombokResponse;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.Matchers.*;
import static helpers.CustomAllureListener.withCustomTemplates;
import static specs.Specs.*;

public class RestTests {

    @Test
    @Tag("homework")
    void createNewUser() {

        TestBaseLombok testLombok = new TestBaseLombok();
        testLombok.setBaseUrl(testLombok.baseUrl);
        testLombok.setCreateUserBody(testLombok.createUserBody);
        testLombok.setCreateUser(testLombok.createUser);

        step("create new user", () ->
        given(requestSpec)
                .body(testLombok.createUserBody)
                .post(testLombok.createUser)
                .then()
                .spec(responseSpec)
        );

    }

    @Test
    @Tag("homework")
    void updateUser() {

        TestBaseLombok testLombok = new TestBaseLombok();
        testLombok.setUpdateUserBody(testLombok.updateUserBody);
        testLombok.setBaseUrl(testLombok.baseUrl);
        testLombok.setPutUpdateUser(testLombok.putUpdateUser);

        step("update user by put method", () ->
                given(requestSpec)
                .body(testLombok.updateUserBody)
                .put(testLombok.putUpdateUser)
                .then()
                        .spec(responseUpdateSpec));
    }

    @Test
    @Tag("homework")
    void deleteUser() {

        TestBaseLombok testLombok = new TestBaseLombok();
        testLombok.setBaseUrl(testLombok.baseUrl);
        testLombok.setDeleteUser(testLombok.deleteUser);

        step("delete created user", () ->
        given(requestSpec)
                .delete( testLombok.deleteUser)
                .then()
                .spec(responseDeleteSpec));
    }

    @Test
    @Tag("homework")
    void checkTotal() {

        TestBaseLombok testLombok = new TestBaseLombok();
        testLombok.setBaseUrl(testLombok.baseUrl);
        testLombok.setListOfUsers(testLombok.listOfUsers);

        step("check total pages in response", () ->
        given(requestSpec)
                .get(testLombok.listOfUsers)
                .then()
                .spec(responseTotalSpec));
    }

    @Test
    @Tag("homework")
    void checkAllLastNames() {

        TestBaseLombok testLombok = new TestBaseLombok();
        testLombok.setBaseUrl(testLombok.baseUrl);
        testLombok.setListOfUsers(testLombok.listOfUsers);

        step("check all last names of users", () ->
        given(requestSpec)
                .get(testLombok.listOfUsers)
                .then()
                .spec(responseLastNamesSpec)
                .body("data.last_name",
                        hasItems("Lawson", "Ferguson", "Funke", "Fields", "Edwards", "Howell")));
    }
}
