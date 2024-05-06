package books.APIs;

import io.restassured.response.Response;
import objects.Book;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.*;

public class BooksApiTest {

    private final String baseUrl = "https://simple-books-api.glitch.me";

    @Test
    public void testBookAvailability() {
        Response response = given()
                .baseUri(baseUrl)
                .when()
                .get("/books");

        assertEquals(response.getStatusCode(), 200, "Expected status code 200");

        // Parse the response body to extract books
        Book[] books = response.as(Book[].class);

        // Iterate through each book and perform assertions
        for (Book book : books) {
            assertNotNull(book.getId(), "Book ID should not be null");
            assertNotNull(book.getName(), "Book Name should not be null");
            assertFalse(book.getName().isEmpty(), "Book Name should not be empty");

            String bookType = book.getType();
            assertNotNull(bookType, "Book Type should not be null");


            // Validate book availability based on ID
            switch (book.getId()) {
                case 1:
                case 3:
                case 4:
                case 5:
                case 6:
                    assertTrue(book.isAvailable(), "Book should be available: " + book.getName());
                    break;
                case 2:
                    assertFalse(book.isAvailable(), "Book should not be available: " + book.getName());
                    break;
                default:
                    fail("Unexpected book ID: " + book.getId());
            }
        }
    }
}
