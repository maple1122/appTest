package content;

import base.GetSignature;
import base.MIBase;
import com.alibaba.fastjson.JSONObject;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

/**
 * @author wufeng
 * @date 2023/6/13 9:31
 */
public class ContentDetail extends MIBase {

    static List<String> enclist = env();

    //获取稿件详情
    public static Response getActicleDetail() {
        String url = "/contentapi/api/content/getContentDetail";
        HashMap map = getActicleDetailMap();
        Response response = null;
        if (map != null) {
            response = given().params(map).get(url);
            System.out.println("自动化测试稿件信息：" + response.asString());
        } else System.out.println("没有找到自动化测试稿件！");
        return response;
    }

    //点赞
    public static void praise() {
        String url = "/contentapi/api/content/addPraise";
        HashMap map = getPraiseMap();
        if (map != null) {
            Response response = given().params(map).post(url);
            System.out.println("点赞返回：" + response.asString());
        } else System.out.println("没有找到自动化测试稿件！");
    }

    //取消点赞
    public static void canCellPraise() {
        String url = "/contentapi/api/content/delPraise";
        HashMap map = getPraiseMap();
        if (map != null) {
            Response response = given().params(map).post(url);
            System.out.println("取消点赞返回：" + response.asString());
        } else System.out.println("没有找到自动化测试稿件！");
    }

    //收藏
    public static void collect() {
        String url = "/contentapi/api/content/collect";
        HashMap map = getCollectMap();
        if (map != null) {
            Response response = given().params(map).post(url);
            System.out.println("收藏返回：" + response.asString());
        } else System.out.println("没有找到自动化测试稿件！");
    }

    //取消收藏
    public static void canCellCollect() {
        String url = "/contentapi/api/content/deleteCollect";
        HashMap map = getCancellCollectMap();
        if (map != null) {
            Response response = given().params(map).post(url);
            System.out.println("取消收藏返回：" + response.asString());
        } else System.out.println("没有找到自动化测试稿件！");
    }

    //获取稿件详情参数map
    public static HashMap getActicleDetailMap() {
        HashMap map = getActicleDetailBaseMap();
        if (map != null) {
            JSONObject acticleDetail = ContentList.getTestData();
            String id = acticleDetail.get("id").toString();
            String contentType = acticleDetail.get("contentType").toString();
            map.put("id", id);
            map.put("contentType", contentType);
            map.put("signature", GetSignature.getSign(map));
        }
        return map;
    }

    //点赞的参数
    public static HashMap getPraiseMap(){
        HashMap map=getActicleDetailBaseMap();
        if (map!=null){
            JSONObject acticleDetail = ContentList.getActicleByType("1");//获取类型是文稿的
            String id = acticleDetail.get("id").toString();
            String contentType = acticleDetail.get("contentType").toString();
            map.put("id", id);
            map.put("contentType", contentType);
            map.put("signature", GetSignature.getSign(map));
            System.out.println("map>>>"+map.toString());
        }
        return map;
    }

    //收藏的参数
    public static HashMap getCollectMap(){
        HashMap map=getActicleDetailBaseMap();
        if (map!=null){
            JSONObject acticleDetail = ContentList.getActicleByType("1");
            String id = acticleDetail.get("id").toString();
            String contentType = acticleDetail.get("contentType").toString();
            map.put("contentId", id);
            map.put("contentType", contentType);
            map.put("signature", GetSignature.getSign(map));
        }
        return map;
    }

    //取消收藏的参数
    public static HashMap getCancellCollectMap(){
        HashMap map=getActicleDetailBaseMap();
        if (map!=null){
            JSONObject acticleDetail = ContentList.getActicleByType("1");
            String id = acticleDetail.get("id").toString();
            String contentType = acticleDetail.get("contentType").toString();
            map.put("contentIds", id);
            map.put("contentType", contentType);
            map.put("signature", GetSignature.getSign(map));
        }
        return map;
    }

    //稿件详情基础参数map
    public static HashMap getActicleDetailBaseMap() {

        //基本参数（不含signature、apiSign）
        HashMap map = new HashMap();
        map.put("currentTimeMillis", String.valueOf(System.currentTimeMillis()));
        map.put("appId", enclist.get(3));
        map.put("siteId", enclist.get(4));
        map.put("modelType", enclist.get(5));
        map.put("versionName", enclist.get(6));
        map.put("userId", enclist.get(9));
        map.put("platform", enclist.get(7));
        return map;
    }
}
