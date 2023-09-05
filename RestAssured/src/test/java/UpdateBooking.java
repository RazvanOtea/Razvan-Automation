import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UpdateBooking extends BaseTest {
    String token = Utils.authenticateAndGetToken();
    int id = Utils.createBookingAndGetId();

    @Test
    public void updateBookingTestPositiveScenario() {
        given()
                .contentType("application/json")
                .header("Accept", "application/json")
                .header("Cookie", "token=" + token)
                .pathParam("bookingid", id)
                .body(Utils.loadJsonFile("createbooking/ValidData.json"))
                .log().all()
                .when()
                .put("booking/{bookingid}")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void updateBookingWithoutContentType() {
        given()
                .header("Accept", "application/json")
                .header("Cookie", "token=" + token)
                .pathParam("bookingid", id)
                .body(Utils.loadJsonFile("createbooking/ValidData.json"))
                .log().all()
                .when()
                .put("booking/{bookingid}")
                .then()
                .log().all()
                .statusCode(400);
    }

    @Test
    public void updateBookingWithoutAccept() {
        given()
                .contentType("application/json")
                .header("Cookie", "token=" + token)
                .pathParam("bookingid", id)
                .body(Utils.loadJsonFile("createbooking/ValidData.json"))
                .log().all()
                .when()
                .put("booking/{bookingid}")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void updateBookingWithoutCookie() {
        given()
                .contentType("application/json")
                .header("Accept", "application/json")
                .pathParam("bookingid", id)
                .body(Utils.loadJsonFile("createbooking/ValidData.json"))
                .log().all()
                .when()
                .put("booking/{bookingid}")
                .then()
                .log().all()
                .statusCode(403);
    }

    @Test
    public void updateBookingWithoutHeaders() {
        given()
                .pathParam("bookingid", id)
                .body(Utils.loadJsonFile("createbooking/ValidData.json"))
                .log().all()
                .when()
                .put("booking/{bookingid}")
                .then()
                .log().all()
                .statusCode(403);
    }

    @Test
    public void updateBookingInvalidContentType() {
        given()
                .contentType("text/plain")
                .header("Accept", "application/json")
                .header("Cookie", "token=" + token)
                .pathParam("bookingid", id)
                .body(Utils.loadJsonFile("createbooking/ValidData.json"))
                .log().all()
                .when()
                .put("booking/{bookingid}")
                .then()
                .log().all()
                .statusCode(400);
    }

    @Test
    public void updateBookingWithInvalidAcceptHeader() {
        given()
                .contentType("application/json")
                .header("Accept", "application/jsonn")
                .header("Cookie", "token=" + token)
                .pathParam("bookingid", id)
                .body(Utils.loadJsonFile("createbooking/ValidData.json"))
                .log().all()
                .when()
                .put("booking/{bookingid}")
                .then()
                .log().all()
                .statusCode(418);
    }

    @Test
    public void updateBookingWithInvalidCookie() {
        given()
                .contentType("application/json")
                .header("Accept", "application/json")
                .header("Cookie", "token=1" + token)
                .pathParam("bookingid", id)
                .body(Utils.loadJsonFile("createbooking/ValidData.json"))
                .log().all()
                .when()
                .put("booking/{bookingid}")
                .then()
                .log().all()
                .statusCode(403);
    }

    @Test
    public void updateBookingAllHeaderInvalid() {
        given()
                .contentType("application/json")
                .header("Accept", "application/jsonn")
                .header("Cookie", "token=1" + token)
                .pathParam("bookingid", id)
                .body(Utils.loadJsonFile("createbooking/ValidData.json"))
                .log().all()
                .when()
                .put("booking/{bookingid}")
                .then()
                .log().all()
                .statusCode(403);
    }

}
