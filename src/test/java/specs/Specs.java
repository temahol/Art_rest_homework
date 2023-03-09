package specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import model.lombok.TestBaseLombok;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.ALL;
import static io.restassured.filter.log.LogDetail.BODY;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.notNullValue;

public class Specs {
    static TestBaseLombok testLombok = new TestBaseLombok();

    public static RequestSpecification requestSpec = with()
            .filter(withCustomTemplates())
            .when()
            .baseUri(testLombok.baseUrl);

    public static ResponseSpecification responseSpec = new ResponseSpecBuilder()
            .log(BODY)
            .expectStatusCode(201)
            .expectBody("$", hasKey("id"))
            .expectBody("createdAt", notNullValue())
            .build();

    public static ResponseSpecification responseUpdateSpec = new ResponseSpecBuilder()
            .log(BODY)
            .expectStatusCode(200)
            .expectBody("updatedAt", notNullValue())
            .build();

    public static ResponseSpecification responseDeleteSpec = new ResponseSpecBuilder()
            .log(ALL)
            .expectStatusCode(204)
            .build();

    public static ResponseSpecification responseTotalSpec = new ResponseSpecBuilder()
            .log(ALL)
            .expectStatusCode(200)
            .expectBody("total_pages", notNullValue())
            .build();

    public static ResponseSpecification responseLastNamesSpec = new ResponseSpecBuilder()
            .log(ALL)
            .expectStatusCode(200)
            .build();
}
