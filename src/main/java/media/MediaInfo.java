package media;

import base.GetSignature;
import base.MIBase;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

/**
 * @author wufeng
 * 媒体号
 * @date 2023/6/14 11:22
 */
public class MediaInfo extends MIBase {

    static List<String> enclist = env();

    //获取媒体号信息
    public static void getMediaInfo() {
        String url = "/mpapi/api/mp/media/getMediaInfoV3";
        Response response = given().params(getMediaMap()).post(url);
        System.out.println(response.asString());
    }

    //媒体号接口参数
    public static HashMap getMediaMap() {
        HashMap map = getMediaBaseMap();
        if (map != null)
            map.put("signature", GetSignature.getSign(map));
        return map;
    }

    //媒体号接口基本参数
    public static HashMap getMediaBaseMap() {
        HashMap map = new HashMap();
        map.put("currentTimeMillis", String.valueOf(System.currentTimeMillis()));
        map.put("appId", enclist.get(3));
        map.put("siteId", enclist.get(4));
        map.put("modelType", enclist.get(5));
        map.put("versionName", enclist.get(6));
        map.put("mediaId", enclist.get(10));
        map.put("userId", enclist.get(9));
        map.put("platform", enclist.get(7));
        return map;
    }
}
