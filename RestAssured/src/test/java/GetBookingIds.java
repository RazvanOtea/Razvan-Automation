import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetBookingIds extends BaseTest {

    @Test
    public void getBookingIdsPositiveScenario() {
        given()
                .log().all()
                .when()
                .get("booking")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void getBookingIdsPositiveScenarioWithFirstNameAndLastName() {
        given()
                .queryParam("firstname", "sally")
                .queryParam("lastname", "brown")
                .log().all()
                .when()
                .get("booking")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void getBookingIdsPositiveScenarioWithCheckinAndCheckout() {
        given()
                .queryParam("checkin", "2014-03-13")
                .queryParam("checkout", "2014-05-21")
                .log().all()
                .when()
                .get("booking")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void getBookingIdsWithoutFirstName() {
        given()
                .queryParam("lastname", "brown")
                .log().all()
                .when()
                .get("booking")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void getBookingIdsWithoutLastName() {
        given()
                .queryParam("firstname", "sally")
                .log().all()
                .when()
                .get("booking")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void getBookingIdsWithoutCheckin() {
        given()
                .queryParam("checkout", "2014-05-21")
                .log().all()
                .when()
                .get("booking")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void getBookingIdsWithoutCheckout() {
        given()
                .queryParam("checkin", "2014-03-13")
                .log().all()
                .when()
                .get("booking")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void getBookingIdsWithInvalidFirstName() {
        given()
                .queryParam("firstname", 1)
                .queryParam("lastname", "brown")
                .log().all()
                .when()
                .get("booking")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void getBookingIdsWithInvalidLastName() {
        given()
                .queryParam("firstname", "sally")
                .queryParam("lastname", 2)
                .log().all()
                .when()
                .get("booking")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void getBookingIdsWithInvalidCheckin() {
        given()
                .queryParam("checkin", "dsds")
                .queryParam("checkout", "2014-05-21")
                .log().all()
                .when()
                .get("booking")
                .then()
                .log().all()
                .statusCode(500);
    }

    @Test
    public void getBookingIdsWithInvalidCheckout() {
        given()
                .queryParam("checkin", "2014-03-13")
                .queryParam("checkout", "sdad")
                .log().all()
                .when()
                .get("booking")
                .then()
                .log().all()
                .statusCode(500);
    }
}
