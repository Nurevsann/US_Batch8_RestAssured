import POJOClasses.User;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class GoRestUsersTest {

    public String createRandomName() {
        return RandomStringUtils.randomAlphabetic(8);
    }

    public String createRandomEmail() {
        return RandomStringUtils.randomAlphabetic(10) + "@techno.com";
    }

    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;

    @BeforeClass
    public void setUp() {

        baseURI = "https://gorest.co.in/public/v2/users";

        requestSpecification = new RequestSpecBuilder()
                .addHeader("Authorization", "Bearer 07a0637daa1168c03f668358e917ecafd9ee10fbc7b0df4899707e3476af87fe")
                .setContentType(ContentType.JSON)
                .build();

        responseSpecification = new ResponseSpecBuilder()
                .log(LogDetail.BODY)
                .expectContentType(ContentType.JSON)
                .build();
    }


    @Test
    void createNewUser() {
        given()
                .spec(requestSpecification)
                .body("{\"name\":\"" + createRandomName() + "\",\"gender\":\"male\",\"email\":\"" + createRandomEmail() + "\",\"status\":\"active\"}")
                .when()
                .post("")
                .then()
                .statusCode(201)
                .spec(responseSpecification);
    }

    @Test
    void createNewUserWithMaps() {
        Map<String, String> user = new HashMap<>();
        user.put("name", createRandomName());
        user.put("gender", "female");
        user.put("email", createRandomEmail());
        user.put("status", "active");

        given()
                .spec(requestSpecification)
                .body(user)
                .when()
                .post("")
                .then()
                .statusCode(201)
                .spec(responseSpecification)
                .body("email", equalTo(user.get("email")));
    }

    User user;
    Response response;

    @Test
    void createNewUserWithObject() {
        user = new User();
        user.setName(createRandomName());
        user.setEmail(createRandomEmail());
        user.setGender("female");
        user.setStatus("active");

        response = given()
                .spec(requestSpecification)
                .body(user)
                .when()
                .post("")
                .then()
                .statusCode(201)
                .spec(responseSpecification)
                .body("email", equalTo(user.getEmail()))
                .extract().response();
    }
    //TODO

    /**
     * Write create user negative test
     **/

    @Test(dependsOnMethods = "createNewUserWithObject")
    void createUserNegativeTest() {
        user.setName(createRandomName());
        user.setGender("male");

        given()
                .spec(requestSpecification)
                .body(user)
                .when()
                .post("")
                .then()
                .statusCode(422)
                .spec(responseSpecification)
                .body("[0].message", equalTo("has already been taken"));
        // [0].message -> body[0].message
    }

    /**
     * get the user you created in createAUserWithObjects test
     **/

    @Test(dependsOnMethods = "createNewUserWithObject")
    void getUserById() {
        given()
                .spec(requestSpecification)
                .pathParam("userId", response.path("id"))
                .when()
                .get("/{userId}")
                .then()
                .statusCode(200)
                .spec(responseSpecification)
                .body("name", equalTo(user.getName()))
                .body("email", equalTo(user.getEmail()));
    }


}
