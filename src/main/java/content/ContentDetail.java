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

    //获取评论列表


    //获取稿件详情参数map
    public static HashMap getActicleDetailMap() {
        HashMap map = getActicleDetailBaseMap();
        if (map != null)
            map.put("signature", GetSignature.getSign(map));
        return map;
    }

    //稿件详情基础参数map
    public static HashMap getActicleDetailBaseMap() {

        String id, contentType;
        JSONObject acticleDetail = ContentList.getTestData();
        id = acticleDetail.get("id").toString();
        contentType = acticleDetail.get("contentType").toString();
        //基本参数（不含signature、apiSign）
        HashMap map = new HashMap();
        map.put("currentTimeMillis", String.valueOf(System.currentTimeMillis()));
        map.put("appId", enclist.get(3));
        map.put("siteId", enclist.get(4));
        map.put("modelType", enclist.get(5));
        map.put("id", id);
        map.put("versionName", enclist.get(6));
        map.put("userId", enclist.get(9));
        map.put("contentType", contentType);
        map.put("platform", enclist.get(7));
        return map;
    }
}
