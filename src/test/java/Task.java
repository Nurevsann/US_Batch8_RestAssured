import POJOClasses.ToDo;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
public class Task {

    /**
     * Task 1
     * create a request to https://jsonplaceholder.typicode.com/todos/2
     * expect status 200
     * Convert Into POJO
     */

    @Test
    void task1(){
      ToDo todo = given()
                .when()
                .get("https://jsonplaceholder.typicode.com/todos/2")
                .then()
               // .log().body()
                .statusCode(200)
                .extract().as(ToDo.class);

        System.out.println("todo = " + todo);
    }


}
