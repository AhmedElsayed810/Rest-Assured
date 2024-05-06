package books.APIs;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import objects.Order;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.*;

public class ViewOrdersApiTest {

    @Test
    public void testViewOrders() {
        RestAssured.baseURI = "https://simple-books-api.glitch.me";

        Response response = given()
                .header("Authorization", "Bearer 08b45c969fc2ae847364441ce1637bb620eac7b2dfb677a3f1807c732b8ebfdb")
                .when()
                .get("/orders")
                .then()
                .extract()
                .response();

        assertEquals(response.getStatusCode(), 200, "Expected status code 200");

        // Deserialize the response body into an array of Order objects
        Order[] orders = response.as(Order[].class);

        // Iterate through each Order object and perform detailed assertions
        for (Order order : orders) {
            assertNotNull(order.getId(), "Order ID should not be null");
            assertFalse(order.getId().isEmpty(), "Order ID should not be empty");


            assertNotNull(order.getBookId(),"Book ID should not be null");

            assertNotNull(order.getCustomerName(), "Customer Name should not be null");
            assertFalse(order.getCustomerName().isEmpty(), "Customer Name should not be empty");

            assertNotNull(order.getCreatedBy(), "Created By should not be null");
            assertFalse(order.getCreatedBy().isEmpty(), "Created By should not be empty");
            assertNotNull(order.getQuantity(), "Quantity should not be null");
            assertTrue(order.getQuantity() == 1, "Quantity should be 1");

            assertNotNull(order.getTimestamp(), "Timestamp should not be null");
            assertTrue(order.getTimestamp() > 0, "Timestamp should be a positive value");

            // Print the details of each order (optional)
            System.out.println("Order Details: " + order);
        }
    }
}
