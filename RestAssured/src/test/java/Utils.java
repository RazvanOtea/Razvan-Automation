import io.restassured.response.Response;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class Utils {
    private static Properties properties;

    static {
        properties = new Properties();
        try (InputStream is = new FileInputStream("src/test/resources/config.properties")) {
            properties.load(is);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public static String getBaseURI() {
        return properties.getProperty("baseURI");
    }

    public static String getBaseToken() {
        return properties.getProperty("basicToken");
    }

    public static String loadJsonFile(String path) {
        try (InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(path)) {
            if (is == null) {
                throw new IllegalArgumentException("File not found: " + path);
            }
            byte[] bytes = new byte[is.available()];
            is.read(bytes);
            return new String(bytes, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load JSON file from path: " + path, e);
        }
    }

    public static String authenticateAndGetToken() {
        return given()
                .baseUri(Utils.getBaseURI())
                .contentType("application/json")
                .body(Utils.loadJsonFile("createtoken/ValidCredential.json"))
                .post("/auth")
                .then()
                .statusCode(200)
                .extract().response().jsonPath().getString("token");
    }

    public static int createBookingAndGetId() {
         return given()
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
    }
}
