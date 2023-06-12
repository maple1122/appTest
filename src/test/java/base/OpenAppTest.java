package base;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

/**
 * @author wufeng
 * @date 2023/6/12 9:29
 */
public class OpenAppTest extends MITestBase {

    String url="/memberapi/api/member/getInfo";

    @Test
    public void testGetUserInfoByOpen() {
        //传参调登录接口
        Response response = given().
                params(OpenApp.getUserMapByOpen()).
                post(url);

        //校验返回是否成功
        response.then().
                statusCode(200).
                contentType(JSON);
        System.out.println(response.asString());
    }
}