package CampusAPI.CountryAPI;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class CountryAPITest {
    @Test
    void Login(){
        Map<String,String> credentials = new HashMap<>();
        credentials.put("username","turkeyts");
        credentials.put("password","Technostudy123");
        credentials.put("rememberMe","true");
        given()
                .body(credentials)
                .contentType(ContentType.JSON)
                .when()
                .post("https://test.mersys.io/auth/login")
                .then()
                .log().body();
    }





}
