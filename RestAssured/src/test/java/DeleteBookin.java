import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteBookin extends  BaseTest{
    String token = Utils.authenticateAndGetToken();
    String basicToken = Utils.getBaseToken();
    int id = Utils.createBookingAndGetId();

    @Test
    public void deleteBookingPositiveScenarioWithCookie() {
        given()
                .contentType("application/json")
                .header("Accept", "application/json")
                .header("Cookie", "token=" + token)
                .pathParam("bookingid", id)
                .body(Utils.loadJsonFile("createbooking/ValidData.json"))
                .log().all()
                .when()
                .delete("booking/{bookingid}")
                .then()
                .log().all()
                .statusCode(201);
    }

    @Test
    public void deleteBookingPositiveScenarioWithBasicToken() {
        given()
                .contentType("application/json")
                .header("Accept", "application/json")
                .header("Authorization", "Basic " + basicToken)
                .pathParam("bookingid", id)
                .body(Utils.loadJsonFile("createbooking/ValidData.json"))
                .log().all()
                .when()
                .delete("booking/{bookingid}")
                .then()
                .log().all()
                .statusCode(201);
    }

    @Test
    public void deleteBookingWithoutCookieAndAuthorization() {
        given()
                .contentType("application/json")
                .header("Accept", "application/json")
                .pathParam("bookingid", id)
                .body(Utils.loadJsonFile("createbooking/ValidData.json"))
                .log().all()
                .when()
                .delete("booking/{bookingid}")
                .then()
                .log().all()
                .statusCode(403);
    }

    @Test
    public void deleteBookingWithoutAllHeaders() {
        given()
                .pathParam("bookingid", id)
                .body(Utils.loadJsonFile("createbooking/ValidData.json"))
                .log().all()
                .when()
                .delete("booking/{bookingid}")
                .then()
                .log().all()
                .statusCode(403);
    }

    @Test
    public void deleteBookingWithInvalidCookie() {
        given()
                .contentType("application/json")
                .header("Accept", "application/json")
                .header("Cookie", "token=" + token + "asd")
                .pathParam("bookingid", id)
                .body(Utils.loadJsonFile("createbooking/ValidData.json"))
                .log().all()
                .when()
                .delete("booking/{bookingid}")
                .then()
                .log().all()
                .statusCode(403);
    }

    @Test
    public void deleteBookingWithInvalidAuthorization() {
        given()
                .contentType("application/json")
                .header("Accept", "application/json")
                .header("Authorization", "Basic " + basicToken + "asd")
                .pathParam("bookingid", id)
                .body(Utils.loadJsonFile("createbooking/ValidData.json"))
                .log().all()
                .when()
                .delete("booking/{bookingid}")
                .then()
                .log().all()
                .statusCode(403);
    }

    @Test
    public void deleteBookingWithoutId() {
        given()
                .contentType("application/json")
                .header("Accept", "application/json")
                .header("Cookie", "token=" + token)
                .body(Utils.loadJsonFile("createbooking/ValidData.json"))
                .log().all()
                .when()
                .delete("booking")
                .then()
                .log().all()
                .statusCode(404);
    }

    @Test
    public void deleteBookingWithInvalidId() {
        given()
                .contentType("application/json")
                .header("Accept", "application/json")
                .header("Cookie", "token=" + token)
                .pathParam("bookingid", id + "c")
                .body(Utils.loadJsonFile("createbooking/ValidData.json"))
                .log().all()
                .when()
                .delete("booking/{bookingid}")
                .then()
                .log().all()
                .statusCode(201);
    }
}
