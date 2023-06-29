package content;

import base.GetSignature;
import base.MIBase;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

/**
 * @author wufeng
 * @date 2023/6/28 14:32
 */
public class TVChannel extends MIBase {

    static List<String> enclist = env();

    public static void getCommentList() {
        String url = "/rftapi/api/rft/getProgramHistoryCommentList";
        HashMap map = getCommentListMap();
        if (map != null) {
            Response response = given().params(map).post(url);
            System.out.println("返回结果是：" + response.asString());
        } else System.out.println("map为空");
    }

    public static void pushComment() {
        String url = "/rftapi/api/rft/doComment";
        HashMap map = getCommentMap();
        if (map != null) {
            Response response = given().
                    params(map).
                    headers("Accept", "application/json; charset=UTF-8", "Content-Type", "application/x-www-form-urlencoded; charset=UTF-8").
                    post(url);
            System.out.println("返回结果是：" + response.asString());
        } else System.out.println("map为空");
    }

    protected static HashMap getCommentListMap() {
        HashMap map = getCommentListBaseMap();
        map.put("signature", GetSignature.getSign(map));
        return map;
    }

    protected static HashMap getCommentListBaseMap() {
        HashMap map = new HashMap();
        map.put("currentTimeMillis", String.valueOf(System.currentTimeMillis()));
        map.put("appId", enclist.get(3));
        map.put("siteId", enclist.get(4));
        map.put("pageSize","10");
        map.put("modelType", "1");
        map.put("versionName", enclist.get(6));
        map.put("userId", enclist.get(9));
        map.put("pageNum","1");
        map.put("platform", enclist.get(7));
        map.put("programId", enclist.get(12));
        map.put("channelId", enclist.get(11));
        return map;
    }

    protected static HashMap getCommentMap() {
        HashMap map = getCommentBaseMap();
        map.put("signature", GetSignature.getSign(map));
        return map;
    }

    protected static HashMap getCommentBaseMap() {
        String txt = "autoTest-这是自动化测试聊天室发布的内容-"+System.currentTimeMillis();
        HashMap map = new HashMap();
        map.put("modelType", "1");
        map.put("versionName", enclist.get(6));
        map.put("type", "1");
        map.put("userId", enclist.get(9));
        map.put("platform", enclist.get(7));
        map.put("txt", txt);
        map.put("replyUserId", "");
        map.put("phone", "18900000000");
        map.put("currentTimeMillis", String.valueOf(System.currentTimeMillis()));
        map.put("appId", enclist.get(3));
        map.put("commentType", "0");
        map.put("replyId", "");
        map.put("siteId", enclist.get(4));
        map.put("programId", enclist.get(12));
        map.put("channelId", enclist.get(11));
        return map;
    }
}
