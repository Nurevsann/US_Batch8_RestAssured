import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ZippoTest {

    @Test
    void test1() {

        given() // preparation(token, request body, parameters, cookies...)
                .when() //for url, request method(get, post, put, patch, delete)
                            //get, post, put, patch, delete don't belong to postman.
                            // they are known as http methods. All programming languages use these methods
                        .then();// response(response body, tests, extract data from the response)
    }

    @Test
    void statusCodeTest(){
        given()
                .when()
                .get("http://api.zippopotam.us/us/90210")
                .then()
                .log().body() // prints the response body to the console
                .log().status() // prints the status of the request
                .statusCode(200); // tests if the status code is the same as the expected
    }
}
