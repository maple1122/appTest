package content;

import base.GetSignature;
import base.MIBase;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.List;

import static content.ContentList.getTestData;
import static io.restassured.RestAssured.given;

/**
 * @author wufeng
 * @date 2023/6/13 10:16
 */
public class Comment extends MIBase {
    static List<String> enclist = env();

    //获取稿件评论列表
    public static Response getCommentList() {
        String url = "/contentapi/api/content/getFirstCommentList";
        HashMap map = getCommentListMap();
        Response response = null;
        if (map != null) {
            response = given().params(map).get(url);
            System.out.println("评论列表接口返回：" + response.asString());
        } else System.out.println("没有自动化测试稿件可评论");
        return response;
    }

    //发表评论
    public static void publishComment() {
        String url = "/contentapi/api/content/addComment";
        HashMap map = addCommentMap();
        if (map != null) {
            Response response = given().
                    params(map).
                    headers("Accept", "application/json; charset=UTF-8", "Content-Type", "application/x-www-form-urlencoded; charset=UTF-8").
                    post(url);
            System.out.println("发表评论返回：" + response.asString());
        } else System.out.println("没有自动化测试稿件可评论");
    }

    //回复评论
    public static void replyComment() {
        String url = "/contentapi/api/content/addComment";
        HashMap map = addReplyMap();
        if (map != null) {
            Response response = given().
                    params(map).
                    headers("Accept", "application/json; charset=UTF-8", "Content-Type", "application/x-www-form-urlencoded; charset=UTF-8").
                    post(url);
            System.out.println("回复评论返回：" + response.asString());
        } else System.out.println("没有自动化测试稿件评论可回复");
    }

    public static void getMyCommentList() {
        String url = "/contentapi/api/content/getMyCommentList";
        HashMap map = getMyCommentListMap();
        if (map != null) {
            Response response = given().params(map).get(url);
            System.out.println("个人评论列表：" + response.asString());
        } else System.out.println("map为空");
    }

    //评论列表参数map
    public static HashMap getCommentListMap() {
        HashMap map = getCommentListBaseMap();
        if (map != null)
            map.put("signature", GetSignature.getSign(map));
        return map;
    }

    //评论列表参数基础map
    public static HashMap getCommentListBaseMap() {

        JSONObject acticleDetail = getTestData();
        HashMap map = new HashMap();
        if (acticleDetail.get("id") != null) {
            String id = acticleDetail.get("id").toString();
            //基本参数（不含signature、apiSign）
            map.put("currentTimeMillis", String.valueOf(System.currentTimeMillis()));
            map.put("appId", enclist.get(3));
            map.put("siteId", enclist.get(4));
            map.put("pageSize", "10");
            map.put("modelType", enclist.get(5));
            map.put("id", id);
            map.put("versionName", enclist.get(6));
            map.put("pageNum", "1");
            map.put("childSize", "2");
            map.put("platform", enclist.get(7));
        }
        return map;
    }

    //创建评论参数map
    public static HashMap addCommentMap() {
        HashMap map = addCommentBaseMap();
        if (map != null)
            map.put("signature", GetSignature.getSign(map));
        return map;
    }

    //创建评论参数基础map
    public static HashMap addCommentBaseMap() {

        JSONObject acticle = getTestData();
        HashMap map = new HashMap();
        if (acticle != null) {
            String contentId = acticle.get("id").toString();
            String txt = "autotest-comment-自动化测试评论-" + System.currentTimeMillis();
            //基本参数（不含signature、apiSign）
            map.put("txt", txt);
            map.put("currentTimeMillis", String.valueOf(System.currentTimeMillis()));
            map.put("appId", enclist.get(3));
            map.put("contentId", contentId);
            map.put("replyId", "");
            map.put("siteId", enclist.get(4));
            map.put("firstCommentId", "");
            map.put("modelType", enclist.get(5));
            map.put("versionName", enclist.get(6));
            map.put("userId", enclist.get(9));
            map.put("platform", enclist.get(7));
        }
        return map;
    }

    //创建评论参数map
    public static HashMap addReplyMap() {
        HashMap map = addReplyBaseMap();
        if (map != null)
            map.put("signature", GetSignature.getSign(map));
        return map;
    }

    //创建回复参数基础map
    public static HashMap addReplyBaseMap() {

        JSONObject comment = JSON.parseObject(getCommentList().asString());
        JSONArray array = comment.getJSONArray("list");
        HashMap map = new HashMap();
        if (array != null) {
            JSONObject jO = array.getJSONObject(0);
            String contentId = jO.get("contentId").toString();
            String replyId = jO.getString("id");
            String firstCommentId = jO.getString("id");
            String txt = "autotest-reply-自动化测试回复-" + System.currentTimeMillis();
            //基本参数（不含signature、apiSign）
            map.put("txt", txt);
            map.put("currentTimeMillis", String.valueOf(System.currentTimeMillis()));
            map.put("appId", enclist.get(3));
            map.put("contentId", contentId);
            map.put("replyId", replyId);
            map.put("siteId", enclist.get(4));
            map.put("firstCommentId", firstCommentId);
            map.put("modelType", enclist.get(5));
            map.put("versionName", enclist.get(6));
            map.put("userId", enclist.get(9));
            map.put("platform", enclist.get(7));
        }
        return map;
    }

    protected static HashMap getMyCommentListMap() {
        HashMap map = getMyCommentListBaseMap();
        map.put("signature", GetSignature.getSign(map));
        return map;
    }

    protected static HashMap getMyCommentListBaseMap() {
        HashMap map = new HashMap();
        map.put("currentTimeMillis", String.valueOf(System.currentTimeMillis()));
        map.put("appId", enclist.get(3));
        map.put("siteId", enclist.get(4));
        map.put("pageSize", "10");
        map.put("modelType", enclist.get(5));
        map.put("versionName", enclist.get(6));
        map.put("userId", enclist.get(9));
        map.put("pageNum", "1");
        map.put("platform", enclist.get(7));
        return map;
    }
}
