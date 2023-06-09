
import io.restassured.RestAssured;
import org.testng.annotations.BeforeTest;


/**
 * @author wufeng
 * @date 2023/6/8 10:58
 */
public class MITestBase extends MIBase{

    @BeforeTest
    public void setUP() {
        RestAssured.baseURI = env().get(0);
        RestAssured.port = 80;
        RestAssured.basePath = "";
    }


}
