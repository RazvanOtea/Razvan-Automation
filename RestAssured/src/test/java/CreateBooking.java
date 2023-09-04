import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateBooking extends TestSetup {
    @Test
    public void createBookingPositiveTest() {
        given()
                .contentType("application/json")
                .header("Accept", "application/json")
                .body(Utils.loadJsonFile("createbooking/ValidData.json"))
                .log().all()
                .when()
                .post("booking")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void createBookingWithoutContentType() {
        given()
                .header("Accept", "application/json")
                .body(Utils.loadJsonFile("createbooking/ValidData.json"))
                .log().all()
                .when()
                .post("booking")
                .then()
                .log().all()
                .statusCode(500);
    }

    @Test
    public void createBookingWithoutAcceptHeader() {
        given()
                .contentType("application/json")
                .body(Utils.loadJsonFile("createbooking/ValidData.json"))
                .log().all()
                .when()
                .post("booking")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void createBookingWithoutContentTypeAndAcceptHeader() {
        given()
                .body(Utils.loadJsonFile("createbooking/ValidData.json"))
                .log().all()
                .when()
                .post("booking")
                .then()
                .log().all()
                .statusCode(500);
    }

    @Test
    public void createBookingWithInvalidContentType() {
        given()
                .contentType("text/plain")
                .header("Accept", "application/json")
                .body(Utils.loadJsonFile("createbooking/ValidData.json"))
                .log().all()
                .when()
                .post("booking")
                .then()
                .log().all()
                .statusCode(500);
    }

    @Test
    public void createBookingWithInvalidAcceptHeader() {
        given()
                .contentType("application/json")
                .header("Accept", "text/plain")
                .body(Utils.loadJsonFile("createbooking/ValidData.json"))
                .log().all()
                .when()
                .post("booking")
                .then()
                .log().all()
                .statusCode(418);
    }

    @Test
    public void createBookingWithInvalidContentTypeAndAcceptHeader() {
        given()
                .contentType("text/plain")
                .header("Accept", "text/plain")
                .body(Utils.loadJsonFile("createbooking/ValidData.json"))
                .log().all()
                .when()
                .post("booking")
                .then()
                .log().all()
                .statusCode(500);
    }

    @Test
    public void createBookingWithoutFirstName() {
        given()
                .contentType("application/json")
                .header("Accept", "application/json")
                .body(Utils.loadJsonFile("createbooking/WithoutFirstName.json"))
                .log().all()
                .when()
                .post("booking")
                .then()
                .log().all()
                .statusCode(500);
    }

    @Test
    public void createBookingWithoutLastName() {
        given()
                .contentType("application/json")
                .header("Accept", "application/json")
                .body(Utils.loadJsonFile("createbooking/WithoutLastName.json"))
                .log().all()
                .when()
                .post("booking")
                .then()
                .log().all()
                .statusCode(500);
    }

    @Test
    public void createBookingWithoutTotalPrice() {
        given()
                .contentType("application/json")
                .header("Accept", "application/json")
                .body(Utils.loadJsonFile("createbooking/WithoutTotalPrice.json"))
                .log().all()
                .when()
                .post("booking")
                .then()
                .log().all()
                .statusCode(500);
    }

    @Test
    public void createBookingWithoutDepositPaid() {
        given()
                .contentType("application/json")
                .header("Accept", "application/json")
                .body(Utils.loadJsonFile("createbooking/WithoutDepositPaid.json"))
                .log().all()
                .when()
                .post("booking")
                .then()
                .log().all()
                .statusCode(500);
    }

    @Test
    public void createBookingWithoutCheckin() {
        given()
                .contentType("application/json")
                .header("Accept", "application/json")
                .body(Utils.loadJsonFile("createbooking/WithoutCheckin.json"))
                .log().all()
                .when()
                .post("booking")
                .then()
                .log().all()
                .statusCode(500);
    }

    @Test
    public void createBookingWithoutCheckout() {
        given()
                .contentType("application/json")
                .header("Accept", "application/json")
                .body(Utils.loadJsonFile("createbooking/WithoutCheckout.json"))
                .log().all()
                .when()
                .post("booking")
                .then()
                .log().all()
                .statusCode(500);
    }

    @Test
    public void createBookingWithoutAdditionalNeeds() {
        given()
                .contentType("application/json")
                .header("Accept", "application/json")
                .body(Utils.loadJsonFile("createbooking/WithoutAdditionalNeeds.json"))
                .log().all()
                .when()
                .post("booking")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void createBookingWithoutAllKeys() {
        given()
                .contentType("application/json")
                .header("Accept", "application/json")
                .body(Utils.loadJsonFile("createbooking/WithoutAllKeys.json"))
                .log().all()
                .when()
                .post("booking")
                .then()
                .log().all()
                .statusCode(500);
    }

    @Test
    public void createBookingWithInvalidFirstName() {
        given()
                .contentType("application/json")
                .header("Accept", "application/json")
                .body(Utils.loadJsonFile("createbooking/WithInvalidFirstName.json"))
                .log().all()
                .when()
                .post("booking")
                .then()
                .log().all()
                .statusCode(500);
    }

    @Test
    public void createBookingWithInvalidLastName() {
        given()
                .contentType("application/json")
                .header("Accept", "application/json")
                .body(Utils.loadJsonFile("createbooking/WithInvalidLastName.json"))
                .log().all()
                .when()
                .post("booking")
                .then()
                .log().all()
                .statusCode(500);
    }

    @Test
    public void createBookingWithInvalidTotalPrice() {
        given()
                .contentType("application/json")
                .header("Accept", "application/json")
                .body(Utils.loadJsonFile("createbooking/WithInvalidTotalPrice.json"))
                .log().all()
                .when()
                .post("booking")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void createBookingWithInvalidDepositPaid() {
        given()
                .contentType("application/json")
                .header("Accept", "application/json")
                .body(Utils.loadJsonFile("createbooking/WithInvalidDepositPaid.json"))
                .log().all()
                .when()
                .post("booking")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void createBookingWithInvalidCheckin() {
        given()
                .contentType("application/json")
                .header("Accept", "application/json")
                .body(Utils.loadJsonFile("createbooking/WithInvalidCheckin.json"))
                .log().all()
                .when()
                .post("booking")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void createBookingWithInvalidCheckout() {
        given()
                .contentType("application/json")
                .header("Accept", "application/json")
                .body(Utils.loadJsonFile("createbooking/WithInvalidCheckout.json"))
                .log().all()
                .when()
                .post("booking")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void createBookingWithInvalidAdditionalNeeds() {
        given()
                .contentType("application/json")
                .header("Accept", "application/json")
                .body(Utils.loadJsonFile("createbooking/WithInvalidAdditionalNeeds.json"))
                .log().all()
                .when()
                .post("booking")
                .then()
                .log().all()
                .statusCode(200);
    }
}
