package base;

import io.restassured.RestAssured;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.lang.reflect.Method;


/**
 * @author wufeng
 * @date 2023/6/8 10:58
 */
public class MITestBase extends MIBase {

    //域名初始化
    @BeforeTest
    public void setUP() {
        RestAssured.baseURI = env().get(0);
        RestAssured.port = 80;
        RestAssured.basePath = "";
    }

    @BeforeMethod
    public void testStart(Method method) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>> Test case: "
                + method.getName());
    }

    @AfterMethod
    public void testEnd(Method method) {
        System.out.println("<<<<<<<<<<<<<<<<<<<<<<< Test End!\n");
    }
}
