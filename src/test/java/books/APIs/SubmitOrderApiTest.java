package books.APIs;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class SubmitOrderApiTest {

    @Test
    public void testSubmitOrder() {
        RestAssured.baseURI = "https://simple-books-api.glitch.me";

        String requestBody = "{ \"bookId\": 1, \"customerName\": \"John\" }";

        Response response = given()
                .header("Authorization", "Bearer 08b45c969fc2ae847364441ce1637bb620eac7b2dfb677a3f1807c732b8ebfdb")
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post("/orders");

        assertEquals(response.getStatusCode(), 201);

        assertTrue(response.jsonPath().getBoolean("created"), "Expected 'created' to be true");

        assertFalse(response.jsonPath().getString("orderId").isEmpty(), "Expected 'orderId' to be non-empty");

    }
}
