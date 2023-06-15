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
//        ContentType[] types = ContentType.values();
//        for (ContentType type : types) {
//            if (type.index == contentType) {
        //content=11，图文；13，拍拍
        if (contentType == 11 || contentType == 13)
            map = getContentMap(String.valueOf(contentType));
//                break;
//            }
//        }
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

    public static HashMap getContentMap(String contentType) {
        HashMap map = getContentBaseMap(contentType);
        map.put("pageSize", "10");
        map.put("pageNum", "1");
        map.put("isOwner", "0");
        map.put("signature", GetSignature.getSign(map));
        return map;
    }

    public static HashMap getContentBaseMap(String contentType) {
        HashMap map = new HashMap();

        map.put("modelType", enclist.get(5));
        map.put("versionName", enclist.get(6));
        map.put("mediaId", enclist.get(10));
        map.put("userId", enclist.get(9));
        map.put("platform", enclist.get(7));
        map.put("currentTimeMillis", String.valueOf(System.currentTimeMillis()));
        map.put("appId", enclist.get(3));
        map.put("siteId", enclist.get(4));
        map.put("contentTypes", contentType);
        return map;
    }
}
