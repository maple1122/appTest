package base;

import io.restassured.response.Response;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

/**
 * @author wufeng
 * @date 2023/6/9 17:22
 */
public class OpenApp extends MIBase {

    static List<String> enclist = MIBase.env();
    static String url = env().get(0) + "/memberapi/api/member/getInfo";
    static HashMap map = new HashMap();

    //打开app，获取用户信息
    public static HashMap getUserMapByOpen() {
        map = mapBase();
        map.put("signature", GetSignature.getSign(map));
        return map;
    }

    //获取登录基本参数__________改！！！！
    public static HashMap mapBase() {

        //基本参数（不含signature、apiSign）
        map.put("currentTimeMillis", String.valueOf(System.currentTimeMillis()));
        map.put("appId", enclist.get(3));
        map.put("siteId", enclist.get(4));
        map.put("modelType", enclist.get(5));
        map.put("versionName", enclist.get(6));
        map.put("userId",enclist.get(9));
        map.put("platform", enclist.get(7));
        return map;
    }

    //打开app获取用户信息
    public Response openApp() {
        Response response = given().params(getUserMapByOpen()).post(url);//打开app调用户信息接口
        return response;
    }
}
