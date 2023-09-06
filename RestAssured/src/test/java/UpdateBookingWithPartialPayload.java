import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UpdateBookingWithPartialPayload extends BaseTest {
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
                .patch("booking/{bookingid}")
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
                .patch("booking/{bookingid}")
                .then()
                .log().all()
                .statusCode(200);
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
                .patch("booking/{bookingid}")
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
                .patch("booking/{bookingid}")
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
                .patch("booking/{bookingid}")
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
                .patch("booking/{bookingid}")
                .then()
                .log().all()
                .statusCode(200);
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
                .patch("booking/{bookingid}")
                .then()
                .log().all()
                .statusCode(500);
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
                .patch("booking/{bookingid}")
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
                .patch("booking/{bookingid}")
                .then()
                .log().all()
                .statusCode(403);
    }

    @Test
    public void updateBookingWithoutId() {
        given()
                .contentType("application/json")
                .header("Accept", "application/json")
                .header("Cookie", "token=" + token)
                .body(Utils.loadJsonFile("createbooking/ValidData.json"))
                .log().all()
                .when()
                .patch("booking")
                .then()
                .log().all()
                .statusCode(404);
    }

    @Test
    public void updateBookingWithInvalidId() {
        given()
                .contentType("application/json")
                .header("Accept", "application/json")
                .header("Cookie", "token=" + token)
                .pathParam("bookingid", id + "c")
                .body(Utils.loadJsonFile("createbooking/ValidData.json"))
                .log().all()
                .when()
                .patch("booking/{bookingid}")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void updateBookingWithoutFirstName() {
        given()
                .contentType("application/json")
                .header("Accept", "application/json")
                .header("Cookie", "token=" + token)
                .pathParam("bookingid", id)
                .body(Utils.loadJsonFile("createbooking/WithoutFirstName.json"))
                .log().all()
                .when()
                .patch("booking/{bookingid}")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void updateBookingWithoutLastName() {
        given()
                .contentType("application/json")
                .header("Accept", "application/json")
                .header("Cookie", "token=" + token)
                .pathParam("bookingid", id)
                .body(Utils.loadJsonFile("createbooking/WithoutLastName.json"))
                .log().all()
                .when()
                .patch("booking/{bookingid}")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void updateBookingWithoutTotalPrice() {
        given()
                .contentType("application/json")
                .header("Accept", "application/json")
                .header("Cookie", "token=" + token)
                .pathParam("bookingid", id)
                .body(Utils.loadJsonFile("createbooking/WithoutTotalPrice.json"))
                .log().all()
                .when()
                .patch("booking/{bookingid}")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void updateBookingWithoutDepositPaid() {
        given()
                .contentType("application/json")
                .header("Accept", "application/json")
                .header("Cookie", "token=" + token)
                .pathParam("bookingid", id)
                .body(Utils.loadJsonFile("createbooking/WithoutDepositPaid.json"))
                .log().all()
                .when()
                .patch("booking/{bookingid}")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void updateBookingWithoutCheckin() {
        given()
                .contentType("application/json")
                .header("Accept", "application/json")
                .header("Cookie", "token=" + token)
                .pathParam("bookingid", id)
                .body(Utils.loadJsonFile("createbooking/WithoutCheckin.json"))
                .log().all()
                .when()
                .patch("booking/{bookingid}")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void updateBookingWithoutCheckout() {
        given()
                .contentType("application/json")
                .header("Accept", "application/json")
                .header("Cookie", "token=" + token)
                .pathParam("bookingid", id)
                .body(Utils.loadJsonFile("createbooking/WithoutCheckout.json"))
                .log().all()
                .when()
                .patch("booking/{bookingid}")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void updateBookingWithoutAdditionalNeeds() {
        given()
                .contentType("application/json")
                .header("Accept", "application/json")
                .header("Cookie", "token=" + token)
                .pathParam("bookingid", id)
                .body(Utils.loadJsonFile("createbooking/WithoutAdditionalNeeds.json"))
                .log().all()
                .when()
                .patch("booking/{bookingid}")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void updateBookingWithoutAllKeys() {
        given()
                .contentType("application/json")
                .header("Accept", "application/json")
                .header("Cookie", "token=" + token)
                .pathParam("bookingid", id)
                .body(Utils.loadJsonFile("createbooking/WithoutAllKeys.json"))
                .log().all()
                .when()
                .patch("booking/{bookingid}")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void updateBookingWithInvalidFirstName() {
        given()
                .contentType("application/json")
                .header("Accept", "application/json")
                .header("Cookie", "token=" + token)
                .pathParam("bookingid", id)
                .body(Utils.loadJsonFile("createbooking/WithInvalidFirstName.json"))
                .log().all()
                .when()
                .patch("booking/{bookingid}")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void updateBookingWithInvalidLastName() {
        given()
                .contentType("application/json")
                .header("Accept", "application/json")
                .header("Cookie", "token=" + token)
                .pathParam("bookingid", id)
                .body(Utils.loadJsonFile("createbooking/WithInvalidLastName.json"))
                .log().all()
                .when()
                .patch("booking/{bookingid}")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void updateBookingWithInvalidTotalPrice() {
        given()
                .contentType("application/json")
                .header("Accept", "application/json")
                .header("Cookie", "token=" + token)
                .pathParam("bookingid", id)
                .body(Utils.loadJsonFile("createbooking/WithInvalidTotalPrice.json"))
                .log().all()
                .when()
                .patch("booking/{bookingid}")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void updateBookingWithInvalidDepositPaid() {
        given()
                .contentType("application/json")
                .header("Accept", "application/json")
                .header("Cookie", "token=" + token)
                .pathParam("bookingid", id)
                .body(Utils.loadJsonFile("createbooking/WithInvalidDepositPaid.json"))
                .log().all()
                .when()
                .patch("booking/{bookingid}")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void updateBookingWithInvalidCheckin() {
        given()
                .contentType("application/json")
                .header("Accept", "application/json")
                .header("Cookie", "token=" + token)
                .pathParam("bookingid", id)
                .body(Utils.loadJsonFile("createbooking/WithInvalidCheckin.json"))
                .log().all()
                .when()
                .patch("booking/{bookingid}")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void updateBookingWithInvalidCheckout() {
        given()
                .contentType("application/json")
                .header("Accept", "application/json")
                .header("Cookie", "token=" + token)
                .pathParam("bookingid", id)
                .body(Utils.loadJsonFile("createbooking/WithInvalidCheckout.json"))
                .log().all()
                .when()
                .patch("booking/{bookingid}")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void updateBookingWithInvalidAdditionalNeeds() {
        given()
                .contentType("application/json")
                .header("Accept", "application/json")
                .header("Cookie", "token=" + token)
                .pathParam("bookingid", id)
                .body(Utils.loadJsonFile("createbooking/WithInvalidAdditionalNeeds.json"))
                .log().all()
                .when()
                .patch("booking/{bookingid}")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void updateBookingWithAllKeysInvalid() {
        given()
                .contentType("application/json")
                .header("Accept", "application/json")
                .header("Cookie", "token=" + token)
                .pathParam("bookingid", id)
                .body(Utils.loadJsonFile("updatebooking/WithAllKeysInvalid.json"))
                .log().all()
                .when()
                .patch("booking/{bookingid}")
                .then()
                .log().all()
                .statusCode(200);
    }
}
