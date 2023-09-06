import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetBooking extends BaseTest {
    int id = Utils.createBookingAndGetId();
    @Test
    public void getBookingPositiveScenario() {
        given()
                .header("Accept", "application/json")
                .pathParam("id", id)
                .log().all()
                .when()
                .get("booking/{id}")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void getBookingWithoutAcceptHeader() {
        given()
                .pathParam("id", id)
                .log().all()
                .when()
                .get("booking/{id}")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void getBookingWithInvalidAcceptHeader() {
        given()
                .header("Accept", "application/jsson")
                .pathParam("id", id)
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
