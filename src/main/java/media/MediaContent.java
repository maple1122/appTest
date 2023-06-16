package media;

import base.GetSignature;
import base.MIBase;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

/**
 * @author wufeng
 * @date 2023/6/14 14:40
 */
public class MediaContent extends MIBase {

    static List<String> enclist = env();

    public static void getMediaContent(int contentType) {
        String url = "/mpapi/api/mp/content/getContentListByType";
        HashMap map = null;
        if (contentType == 11 || contentType == 13)
            map = getContentMap(String.valueOf(contentType));
        if (map != null) {
            Response response = given().params(map).get(url);
            System.out.println(response.asString());
        } else System.out.println("contentType=" + contentType + "，不是有效的媒体号稿件类型");
    }

    //音视频列表
    public static void getMediaContent(int contentType1, int contentType2) {
        String url = "/mpapi/api/mp/content/getContentListByType";
        HashMap map = null;
        String contentType = String.valueOf(contentType1) + "," + String.valueOf(contentType2);
        if (contentType1 == 14 && contentType2 == 15) {
            map = getContentMap(contentType);
        }
        if (map != null) {
            Response response = given().params(map).get(url);
            System.out.println(response.asString());
        } else System.out.println("contentType=" + contentType + "，不是有效的媒体号稿件类型");
    }

    //问答列表
    public static void getQuestions() {
        String url = "/mpapi/api/mp/question/queryQuestionByMedia";
        HashMap map = getQuestionsMap();
        if (map != null) {
            Response response = given().params(map).get(url);
            System.out.println(response.asString());
        }
    }

    //获取列表参数
    public static HashMap getContentMap(String contentType) {
        HashMap map = getContentBaseMap();
        map.put("pageSize", "10");
        map.put("pageNum", "1");
        map.put("isOwner", "0");
        map.put("contentTypes", contentType);
        map.put("signature", GetSignature.getSign(map));
        return map;
    }

    //获取列表参数
    public static HashMap getQuestionsMap() {
        HashMap map = getContentBaseMap();
        map.put("hasChild", "1");
        map.put("pageSize", "10");
        map.put("pageNum", "1");
        map.put("signature", GetSignature.getSign(map));
        return map;
    }

    //获取列表基本参数
    public static HashMap getContentBaseMap() {
        HashMap map = new HashMap();

        map.put("modelType", enclist.get(5));
        map.put("versionName", enclist.get(6));
        map.put("mediaId", enclist.get(10));
        map.put("userId", enclist.get(9));
        map.put("platform", enclist.get(7));
        map.put("currentTimeMillis", String.valueOf(System.currentTimeMillis()));
        map.put("appId", enclist.get(3));
        map.put("siteId", enclist.get(4));
        return map;
    }
}
