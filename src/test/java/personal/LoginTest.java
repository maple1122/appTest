package personal;

import base.MITestBase;
import personal.Login;
import io.restassured.response.Response;
import org.testng.annotations.Test;

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
}