package books.APIs;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class DeleteOrderApiTest {

    @Test
    public void testDeleteOrder() {
        RestAssured.baseURI = "https://simple-books-api.glitch.me";

        Response response = given()
                .header("Authorization", "Bearer 08b45c969fc2ae847364441ce1637bb620eac7b2dfb677a3f1807c732b8ebfdb")
                .when()
                .delete("/orders/GOcbVe3wn4MT7EbsxRqN7")
                .then()
                .extract()
                .response();


        assertEquals(response.getStatusCode(), 200);

    }
}
