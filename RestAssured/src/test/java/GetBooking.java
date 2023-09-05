import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetBooking extends BaseTest {
    private int createBooking() {
        Response createBookingResponse = given()
                .contentType("application/json")
                .header("Accept", "application/json")
                .body(Utils.loadJsonFile("createbooking/ValidData.json"))
                .log().all()
                .when()
                .post("booking")
                .then()
                .log().all()
                .statusCode(200)
                .extract().response();
        return createBookingResponse.jsonPath().getInt("bookingid");
    }
    @Test
    public void getBookingPositiveScenario() {
        int bookingId = createBooking();
        given()
                .header("Accept", "application/json")
                .pathParam("id", bookingId)
                .log().all()
                .when()
                .get("booking/{id}")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void getBookingWithoutAcceptHeader() {
        int bookingId = createBooking();
        given()
                .pathParam("id", bookingId)
                .log().all()
                .when()
                .get("booking/{id}")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void getBookingWithInvalidAcceptHeader() {
        int bookingId = createBooking();
        given()
                .header("Accept", "application/jsson")
                .pathParam("id", bookingId)
                .log().all()
                .when()
                .get("booking/{id}")
                .then()
                .log().all()
                .statusCode(418);
    }
    @Test
    public void getBookingWithoutId() {
        given()
                .header("Accept", "application/json")
                .log().all()
                .when()
                .get("booking")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void getBookingWithInvalidIdParameter() {
        int bookingId = createBooking();
        given()
                .header("Accept", "application/json")
                .log().all()
                .when()
                .get("booking/adsad")
                .then()
                .log().all()
                .statusCode(404);
    }

}
