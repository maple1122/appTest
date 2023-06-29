package politic;

import base.GetSignature;
import base.MIBase;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

/**
 * @author wufeng
 * 获取问政列表
 * @date 2023/6/20 10:32
 */
public class QAList extends MIBase {

    static List<String> enclist = env();

    //获取问政列表
    public static Response getQAList(int type) {

        String url = "/politicapi/api/politictoYQ/getQaListAtYQ";
        Response response = null;
        if (type == 2 || type == 5) {
            HashMap map = getQAListMap(String.valueOf(type));
            if (map != null) {
                response = given().params(map).post(url);
                System.out.println("问政列表：" + response.asString());
            } else System.out.println("map为空");
        } else System.out.println("类型错误:" + type);
        return response;
    }

    //获取一条QAID
    public static String getQAID() {
        String url = "/politicapi/api/politictoYQ/getQaListAtYQ";
        String id = null;
        Response response = null;
        HashMap map = getQAListMap("2");
        if (map != null) {
            response = given().params(map).post(url);
            JSONObject jsonObj = JSON.parseObject(response.asString());//整个json对象
            JSONArray array = jsonObj.getJSONArray("list");//获取返回结果中的稿件list
            if (array != null) {
                JSONObject ob = array.getJSONObject(0);
                id = ob.get("id").toString();
            }else System.out.println("list为空!");
        } else System.out.println("map为空");
        return id;
    }

    //获取问政列表的参数
    public static HashMap getQAListMap(String type) {
        HashMap map = getQAListBaseMap(type);
        map.put("signature", GetSignature.getSign(map));
        return map;
    }

    //获取问政列表的基础参数
    public static HashMap getQAListBaseMap(String type) {
        HashMap map = new HashMap();
        map.put("handleState", type);
        map.put("currentTimeMillis", String.valueOf(System.currentTimeMillis()));
        map.put("appId", enclist.get(3));
        map.put("politicType", "1");
        map.put("siteId", enclist.get(4));
        map.put("modelType", enclist.get(5));
        map.put("versionName", enclist.get(6));
        map.put("userId", enclist.get(9));
        map.put("platform", enclist.get(7));
        map.put("pageSize", "10");
        map.put("pageNum", "1");
        return map;
    }

}
