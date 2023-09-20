package CampusAPI.CountryAPI;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class CountryAPITest {

   /*  Country countryRequest;
    Country countryResponse;

    @Test
   void loginTest(){
        given()
                .body(credentials)
                .contentType(ContentType.JSON)
                .when()
                .post("https://test.mersys.io/auth/login")
                .then()
                .log().body();
    }

    @Test()
    void createCountry() {

        //countryRequest = new Country();
        //countryRequest.setName(randomCountryName());
        //countryRequest.setCode(randomCountryCode());
        //countryRequest.setHasState(false);

        countryResponse = given()
                //.body(countryRequest)
               // .cookies(cookies)
               // .contentType(ContentType.JSON)
                .when()
                .post("")
                .then()
                .statusCode(201)
                .log().body()
                .extract().jsonPath().getObject("", Country.class);
    }


    @Test(dependsOnMethods = "createCountry")
    void deleteCountry(){
        given()
                .pathParam("countryId", countryResponse.getId())
               // .cookies(cookies)
                .when()
                .delete("/{countryId}")
                .then()
                .statusCode(200);
    }*/
}
