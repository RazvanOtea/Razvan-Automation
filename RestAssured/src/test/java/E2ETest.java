import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class E2ETest extends  BaseTest{
    String token = Utils.authenticateAndGetToken();
    @Test
    public void healthCheck() {
        given()
                .when()
                .get("ping")
                .then()
                .statusCode(201);
    }

    @Test
    public void endToEndTest() {
        int bookingId = given()
                .baseUri(Utils.getBaseURI())
                .contentType("application/json")
                .header("Accept", "application/json")
                .body(Utils.loadJsonFile("createbooking/ValidData.json"))
                .log().all()
                .when()
                .post("booking")
                .then()
                .log().all()
                .statusCode(200)
                .extract().response().jsonPath().getInt("bookingid");

        given()
                .header("Accept", "application/json")
                .pathParam("id", bookingId)
                .log().all()
                .when()
                .get("booking/{id}")
                .then()
                .log().all()
                .statusCode(200);

        given()
                .contentType("application/json")
                .header("Accept", "application/json")
                .header("Cookie", "token=" + token)
                .pathParam("bookingid", bookingId)
                .body(Utils.loadJsonFile("createbooking/ValidData.json"))
                .log().all()
                .when()
                .put("booking/{bookingid}")
                .then()
                .log().all()
                .statusCode(200);

        given()
                .contentType("application/json")
                .header("Accept", "application/json")
                .header("Cookie", "token=" + token)
                .pathParam("bookingid", bookingId)
                .body(Utils.loadJsonFile("createbooking/ValidData.json"))
                .log().all()
                .when()
                .delete("booking/{bookingid}")
                .then()
                .log().all()
                .statusCode(201);

        given()
                .header("Accept", "application/json")
                .pathParam("id", bookingId)
                .log().all()
                .when()
                .get("booking/{id}")
                .then()
                .log().all()
                .statusCode(404);
    }

}
