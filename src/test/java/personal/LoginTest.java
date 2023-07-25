package personal;

import base.MITestBase;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import personal.Login;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

/**
 * @author wufeng
 * @date 2023/6/8 15:50
 */
public class LoginTest extends MITestBase {

    String url = "/memberapi/api/member/doMLogin";

    @Test
    public void testLogin() {

        //传参调登录接口
        Response response = given().
                params(Login.getLoginMap()).
                post(url);

        //校验返回是否成功
        response.then().
                statusCode(200).
                contentType(JSON);
        System.out.println(response.asString());
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