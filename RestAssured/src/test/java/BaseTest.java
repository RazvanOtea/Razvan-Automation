import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public abstract class BaseTest {
    @BeforeClass
    public void globalSetup() {
        RestAssured.baseURI = Utils.getBaseURI();
    }

}
