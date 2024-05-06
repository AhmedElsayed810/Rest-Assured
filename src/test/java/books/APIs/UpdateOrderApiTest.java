package books.APIs;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class UpdateOrderApiTest {

    @Test
    public void testUpdateOrder() {
        RestAssured.baseURI = "https://simple-books-api.glitch.me";

        String requestBody = "{ \"customerName\": \"Ahmad\" }";

        Response response = given()
                .header("Authorization", "Bearer 08b45c969fc2ae847364441ce1637bb620eac7b2dfb677a3f1807c732b8ebfdb")
                .body(requestBody)
                .when()
                .patch("/orders/GOcbVe3wn4MT7EbsxRqN7");


        assertEquals(response.getStatusCode(), 204);


    }
}
