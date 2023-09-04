import io.restassured.RestAssured;
import org.testng.annotations.BeforeSuite;

public class TestSetup implements Config {
    @BeforeSuite
    public void globalSetup() {
        RestAssured.baseURI = BASE_URL;
    }
}
