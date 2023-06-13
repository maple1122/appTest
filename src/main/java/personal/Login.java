package personal;

import base.GetSignature;
import base.MIBase;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

/**
 * @author wufeng
 * @date 2023/6/8 15:29
 */
public class Login extends MIBase {

    static List<String> enclist = MIBase.env();
    static String url = MIBase.env().get(0) + "/memberapi/api/member/doMLogin";

    //获取登录参数
    public static HashMap getLoginMap() {

        //登录参数
        HashMap map = getLoginBaseMap();//基本参数
        map.put("signature", GetSignature.getSign(map));//增加签名参数
        return map;
    }

    //获取登录基本参数
    public static HashMap getLoginBaseMap() {

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

    //客户端用户登录
    public static void login() {
        given().params(getLoginMap()).post(url);//调用登录接口
    }

    //客户端用户登录，有返回值
    public static Response getLoginValue() {

        Response response = given().params(getLoginMap()).post(url);//调用登录接口

        return response;//返回登录结果
    }

//    //退出
//    public static Response signOut(){
//
//    }

    //获取登录参数
    public static HashMap getSignOutMap() {

        //登录参数
        HashMap map = getLoginBaseMap();//基本参数
        map.put("signature", GetSignature.getSign(map));//增加签名参数
        return map;
    }

    //获取登录基本参数
//    public static HashMap getSignOutBaseMap() {
//
//        //基本参数（不含signature、apiSign）
//        HashMap map = new HashMap();
//        map.put("currentTimeMillis", String.valueOf(System.currentTimeMillis()));
////        map.put("phone", enclist.get(1));
////        map.put("password", enclist.get(2));
//        map.put("appId", enclist.get(3));
//        map.put("siteId", enclist.get(4));
//        map.put("un",un);
//        map.put("modelType", enclist.get(5));
//        map.put("versionName", enclist.get(6));
//        map.put("userId",enclist.get(9));
//        map.put("platform", enclist.get(7));
//        return map;
//    }

}
