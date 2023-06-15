package media;

import base.GetSignature;
import base.MIBase;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

/**
 * @author wufeng
 * 关注、私信、提问
 * @date 2023/6/15 14:00
 */
public class MediaFollow extends MIBase {

    static List<String> enclist = env();

    //关注
    public static void follow() {
        String url = "/mpapi/api/mp/media/addSubscribe";
        Response response = given().
                params(getFollowMap()).
                post(url);
        System.out.println("关注的返回" + response.asString());
    }

    //取消关注
    public static void cancellFollow() {
        String url = "/mpapi/api/mp/media/delSubscribe";
        Response response = given().
                params(getFollowMap()).
                post(url);
        System.out.println("取消关注的返回" + response.asString());
    }

    //发私信
    public static void createMessage() {
        String url = "/mpapi/api/mp/question/createMessage";
        HashMap map = getCreateMessageMap();
        Response response = given().
                params(map).
                headers("Accept", "application/json; charset=UTF-8", "Content-Type", "application/x-www-form-urlencoded; charset=UTF-8").
                post(url);

        System.out.println("提交私信的返回" + response.asString());
    }

    //提问
    public static void createQuestion() {
        String url = "/mpapi/api/mp/media/addSubscribe";
        Response response = given().
                params(getCreateQuestionMap()).
                headers("Accept", "application/json; charset=UTF-8", "Content-Type", "application/x-www-form-urlencoded; charset=UTF-8").
                post(url);
        System.out.println("提交问题的返回" + response.asString());
    }

    //关注、取消关注的参数map
    public static HashMap getFollowMap() {
        HashMap map = getBaseMap();
        map.put("isSubscribe", "0");
        map.put("signature", GetSignature.getSign(map));
        return map;
    }

    //发私信的参数map
    public static HashMap getCreateMessageMap() {
        String content = "autoTest-发布私信" + System.currentTimeMillis();

        HashMap map = getBaseMap();
        map.put("content", content);
        map.put("signature", GetSignature.getSign(map));
        return map;
    }

    //提问的参数map
    public static HashMap getCreateQuestionMap() {
        String content = "autoTest-提问" + System.currentTimeMillis();

        HashMap map = getBaseMap();
        map.put("content", content);
        map.put("openIntention", "1");
        map.put("type", "1");
        map.put("category", "1");
        map.put("signature", GetSignature.getSign(map));
        return map;
    }

    //基础参数
    public static HashMap getBaseMap() {

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
