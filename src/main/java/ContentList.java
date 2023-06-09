import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.restassured.response.Response;

/**
 * @author wufeng
 * @date 2023/6/8 15:44
 */
public class ContentList {

    //获取数据列表，分条显示
    public static void getData(Response response) {
        String result = response.asString();
        JSONObject jsonObj = JSON.parseObject(result);
        JSONArray array = jsonObj.getJSONArray("list");
        int num;
        for (int i = 0; i < array.size(); i++) {
            num = i + 1;
            JSONObject jO = array.getJSONObject(i);
            System.out.println("第" + num + "条稿件信息：" + jO.toString());
        }
    }
}
