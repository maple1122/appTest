package politic;

import base.GetSignature;
import base.MIBase;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

/**
 * @author wufeng
 * @date 2023/6/20 13:56
 */
public class QADetail extends MIBase {

    static List<String> enclist = env();
    static String url = "/politicapi/api/politictoYQ/getQaDetailAtYQ";

    //获取问政详情页
    public static void getQADetail() {
        String id = QAList.getQAID();
        if (id != null) {
            HashMap map = getQADetailMap(id);
            if (map != null) {
                Response response = given().params(map).get(url);
                System.out.println("问政详情页：" + response.asString());
            }
        } else System.out.println("问政ID为空，没找到问政数据");
    }

    //问政详情参数map
    public static HashMap getQADetailMap(String id) {
        HashMap map = getQADetailBaseMap(id);
        map.put("signature", GetSignature.getSign(map));
        return map;
    }

    //问政详情参数map
    public static HashMap getQADetailBaseMap(String id) {
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
        map.put("qaId", id);
        return map;
    }
}
