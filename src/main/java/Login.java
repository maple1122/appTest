import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

/**
 * @author wufeng
 * @date 2023/6/8 15:29
 */
public class Login extends MIBase{

    static List<String> enclist = MIBase.env();

    //获取登录参数
    public static HashMap loginMap() {

        //登录参数
        HashMap map = loginParams();//基本参数
        map.put("signature", MIBase.getSign());//增加签名参数

        return map;
    }

    //获取登录基本参数
    public static HashMap loginParams() {

        //基本参数（不含signature、apiSign）
        HashMap map = new HashMap();
        map.put("phone", enclist.get(1));
        map.put("password", enclist.get(2));
        map.put("currentTimeMillis", String.valueOf(System.currentTimeMillis()));
        map.put("appId", enclist.get(3));
        map.put("siteId", enclist.get(4));
        map.put("modelType", enclist.get(5));
        map.put("versionName", enclist.get(6));
        map.put("platform", enclist.get(7));
        map.put("deviceToken", enclist.get(8));
        return map;
    }

    //登录
    public static void login() {
        String url = env().get(0)+"/memberapi/api/member/doMLogin";
        given().params(Login.loginMap()).post(url);
    }
}
