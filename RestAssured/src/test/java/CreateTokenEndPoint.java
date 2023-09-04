import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateTokenEndPoint extends TestSetup {
    @Test
    public void testWithValidDetails() {
        given()
                .header("Content-Type", "application/json")
                .body(Utils.loadJsonFile("createtoken/ValidCredential.json"))
                .post("/auth")
                .then()
                .log().all()
                .statusCode(200);
    }
    @Test
    public void testWithoutContentTypeHeader() {
        given()
                .body(Utils.loadJsonFile("createtoken/ValidCredential.json"))
                .when()
                .post("/auth")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void testWithInvalidContentTypeHeader() {
        given()
                .header("Content-Type", "text/plain")
                .body(Utils.loadJsonFile("createtoken/ValidCredential.json"))
                .post("/auth")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void testWithoutUsername() {
        given()
                .header("Content-Type", "application/json")
                .body(Utils.loadJsonFile("createtoken/WithoutUsername.json"))
                .post("/auth")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void testWithoutPassword() {
        given()
                .header("Content-Type", "application/json")
                .body(Utils.loadJsonFile("createtoken/WithoutPassword.json"))
                .post("/auth")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void testWithoutUsernameAndPassword() {
        given()
                .header("Content-Type", "application/json")
                .body(Utils.loadJsonFile("createtoken/WithoutUsernameAndPassword.json"))
                .post("/auth")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void TestWithInvalidUsername() {
        given()
                .header("Content-Type", "application/json")
                .body(Utils.loadJsonFile("createtoken/WithInvalidUsername.json"))
                .post("/auth")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void TestWithInvalidPassword() {
        given()
                .header("Content-Type", "application/json")
                .body(Utils.loadJsonFile("createtoken/WithInvalidPassword.json"))
                .post("/auth")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void TestWithInvalidUsernameAndPassword() {
        given()
                .header("Content-Type", "application/json")
                .body(Utils.loadJsonFile("createtoken/WithInvalidUsernameAndPassword.json"))
                .post("/auth")
                .then()
                .log().all()
                .statusCode(200);
    }

}
