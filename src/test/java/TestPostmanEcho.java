import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestPostmanEcho {
    private final static String URI = "https://postman-echo.com";

    @Test
    public void testGetRequest() {
        given()
                .when()
                .get(URI + "/get")
                .then()
                .statusCode(200).assertThat()
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.connection", equalTo("close"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.accept", equalTo("*/*"))
                .body("url", equalTo("https://postman-echo.com/get"));
    }

    @Test
    public void testPostRawText() {
        String requestBody = "Penguin";
        given()
                .contentType(ContentType.TEXT)
                .body(requestBody)
                .when()
                .post(URI + "/post")
                .then()
                .assertThat()
                .statusCode(200)
                .body("data", equalTo(requestBody))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.connection", equalTo("close"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.accept", equalTo("*/*"))
                .body("url", equalTo("https://postman-echo.com/post"))
                .body("json", equalTo(null));
    }

    @Test
    public void testPutRequest() {
        String requestBody = "I don't understand anything";
        given()
                .contentType(ContentType.TEXT)
                .body(requestBody)
                .when()
                .put(URI + "/put")
                .then()
                .assertThat()
                .statusCode(200)
                .body("data", equalTo(requestBody))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.connection", equalTo("close"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.accept", equalTo("*/*"))
                .body("url", equalTo("https://postman-echo.com/put"))
                .body("json", equalTo(null));
    }

    @Test
    public void testPatchRequest() {
        String requestBody = "This is expected to be sent back as part of response body.";
        given()
                .contentType(ContentType.TEXT)
                .body(requestBody)
                .when()
                .patch(URI + "/patch")
                .then()
                .assertThat()
                .statusCode(200)
                .body("data", equalTo(requestBody))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.connection", equalTo("close"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.accept", equalTo("*/*"))
                .body("url", equalTo("https://postman-echo.com/patch"))
                .body("json", equalTo(null));
    }
}
