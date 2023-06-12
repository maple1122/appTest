import base.MITestBase;
import business.Login;
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

//    @Test
//    public void testLogin2() {
//        HashMap map=new HashMap();
//        map.put("phone", "18900000000");
//        map.put("password", "96e79218965eb72c92a549dd5a330112");
//        map.put("currentTimeMillis", String.valueOf(System.currentTimeMillis()));
//        map.put("appId", "9987ef454edd39ebbf9e1172b461343d");
//        map.put("siteId", "bc5c6704aca54467b3536cbe89aaa122");
//        map.put("modelType", "1");
//        map.put("versionName", "1.2.2");
//        map.put("platform", enclist.get(7));
//        map.put("deviceToken", enclist.get(8));
//
//        //传参调登录接口
//        Response response = given().
//                params(Login.getLoginMap()).
//                post(url);
//
//        //校验返回是否成功
//        response.then().
//                statusCode(200);
////                contentType(JSON);
//        System.out.println(response.asString());
//    }
}