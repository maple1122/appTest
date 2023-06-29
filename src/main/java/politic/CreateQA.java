package politic;

import base.GetSignature;
import base.MIBase;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.config.MultiPartConfig.multiPartConfig;
import static org.apache.http.entity.mime.HttpMultipartMode.BROWSER_COMPATIBLE;

/**
 * @author wufeng
 * @date 2023/6/20 14:36
 */
public class CreateQA extends MIBase {

    static List<String> enclist = env();
    static String url = "/politicapi/api/politictoYQ/addQaAtYQ";
    static String title = "autoTest-title" + System.currentTimeMillis();
    static String content = "autoTest-contentcontentcontentcontentcontentcontentcontent" + System.currentTimeMillis();
    static String currentTime = String.valueOf(System.currentTimeMillis());
    static String tel = "18900000000";
    static String speakUserName = "autoTest";
    static String location = "Beijing-AutoTest";

    //创建问政
    public static void createQA() {
        HashMap map = createQAMap();
        if (map != null) {

            String signature = GetSignature.getSign(createQABaseMap());
            Response response = given().config(RestAssuredConfig.config().
                    httpClient(HttpClientConfig.httpClientConfig().httpMultipartMode(BROWSER_COMPATIBLE)).
                    multiPartConfig(multiPartConfig().defaultCharset("UTF-8"))).
                    multiPart("speakUserId", enclist.get(9)).
                    multiPart("modelType", enclist.get(5)).
                    multiPart("versionName", enclist.get(6)).
                    multiPart("title", title).
                    multiPart("userId", enclist.get(9)).
                    multiPart("platform", enclist.get(7)).
                    multiPart("content", content).
                    multiPart("currentTimeMillis", currentTime).
                    multiPart("appId", enclist.get(3)).
                    multiPart("politicType", "1").
                    multiPart("siteId", enclist.get(4)).
                    multiPart("isPublic", "1").
                    multiPart("speakUserName", speakUserName).
                    multiPart("tel", tel).
                    multiPart("location", location).
                    multiPart("signature", signature).
                    header("Content-Type", "multipart/form-data; boundary=23b16429-7e88-4a92-88d2-d2876019e49f").
                    post(url);
            System.out.println("提交问政返回结果：" + response.asString());
        } else System.out.println("map为空！");
    }

    //创建问政参数
    public static HashMap createQAMap() {
        HashMap map = createQABaseMap();
        map.put("signature", GetSignature.getSign(map));
        return map;
    }

    //创建问政基本参数
    public static HashMap createQABaseMap() {

        HashMap map = new HashMap();
        map.put("speakUserId", enclist.get(9));
        map.put("modelType", enclist.get(5));
        map.put("versionName", enclist.get(6));
        map.put("title", title);
        map.put("userId", enclist.get(9));
        map.put("platform", enclist.get(7));
        map.put("content", content);
        map.put("currentTimeMillis", currentTime);
        map.put("appId", enclist.get(3));
        map.put("politicType", "1");
        map.put("siteId", enclist.get(4));
        map.put("isPublic", "1");
        map.put("speakUserName", speakUserName);
        map.put("tel", tel);
        map.put("location", location);
        return map;
    }
}
