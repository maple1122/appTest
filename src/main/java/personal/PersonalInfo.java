package personal;

import base.GetSignature;
import base.MIBase;
import io.restassured.response.Response;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

/**
 * @author wufeng
 * @date 2023/6/29 10:13
 */
public class PersonalInfo extends MIBase {

    static List<String> enclist = env();
    static String currentTimeMillis = String.valueOf(System.currentTimeMillis());

    //更新用户昵称
    public static void updateInfo() {
        String url = "/memberapi/api/member/updateInfo";
        HashMap map = getUpdateInfoMap();
        Response response = given().params(map).post(url);
        System.out.println("更新用户信息返回："+response.asString());
    }

    //更新用户头像
    public static void updateHeadImg() {
        String url = "/memberapi/api/member/uploadFile";
        String signature = GetSignature.getSign(getUpdateHeadImgBaseMap());
        Response response = given().
                multiPart("violationsHead", "2").
                multiPart("currentTimeMillis", currentTimeMillis).
                multiPart("appId", enclist.get(3)).
                multiPart("siteId", enclist.get(4)).
                multiPart("modelType", enclist.get(5)).
                multiPart("versionName", enclist.get(6)).
                multiPart("userId", enclist.get(9)).
                multiPart("platform", enclist.get(7)).
                multiPart("fileType", "jpg").
                multiPart("signature", signature).
                multiPart("file", new File("headImgTest.jpg")).
                post(url);
        System.out.println("更新用户头像返回：" + response.asString());
    }

    //更改用户信息参数
    private static HashMap getUpdateInfoMap() {
        HashMap map = getUpdateInfoBaseMap();
        map.put("signature", GetSignature.getSign(map));
        return map;
    }

    //更改用户信息基础参数
    private static HashMap getUpdateInfoBaseMap() {
        String username = "autoTest";
        HashMap map = new HashMap();
        map.put("violationsHead", "2");
        map.put("sex", "1");
        map.put("modelType", enclist.get(5));
        map.put("versionName", enclist.get(6));
        map.put("userId", enclist.get(9));
        map.put("platform", enclist.get(7));
        map.put("violationsUserName", "2");
        map.put("currentTimeMillis", String.valueOf(System.currentTimeMillis()));
        map.put("appId", enclist.get(3));
        map.put("siteId", enclist.get(4));
        map.put("pageSize", "10");
        map.put("un", "14a7306d1024e6e9517efe107dc6b6d4");
        map.put("username", username);
        return map;
    }

    //更新头像基础参数
    private static HashMap getUpdateHeadImgBaseMap() {
        HashMap map = new HashMap();
        map.put("violationsHead", "2");
        map.put("currentTimeMillis", currentTimeMillis);
        map.put("appId", enclist.get(3));
        map.put("siteId", enclist.get(4));
        map.put("modelType", enclist.get(5));
        map.put("versionName", enclist.get(6));
        map.put("userId", enclist.get(9));
        map.put("platform", enclist.get(7));
        map.put("fileType", "jpg");
        return map;
    }
}
