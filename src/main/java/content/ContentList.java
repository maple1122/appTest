package content;

import base.MIBase;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;

/**
 * @author wufeng
 * @date 2023/6/8 15:44
 */
public class ContentList extends MIBase {

    static List<String> enclist = env();

    //获取数据列表，分条显示
    public static void getDatas(Response response) {
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

    //获取自动化测试稿件
    public static JSONObject getTestData() {
        String url = "/json/channel/test2/list.json";
        Response response = given().get(url);
        return getTestData(response);
    }

    //获取自动化测试稿件
    public static JSONObject getTestData(Response response) {
        String result = response.asString();
        JSONObject jsonObj = JSON.parseObject(result);//整个json对象
        JSONArray array = jsonObj.getJSONArray("list");//获取返回结果中的稿件list
        JSONObject ob2 = null;
        boolean hasTestData = false;
        for (int i = 0; i < array.size(); i++) {//循环遍历list下的每个稿件
            JSONObject ob1 = array.getJSONObject(i);//每个稿件数据作为json对象
            ob2 = ob1.getJSONObject("data");//获取每个稿件中的data数据
            if (ob2.containsKey("title")) {//校验稿件的data中是否有title
                if (ob2.get("title").toString().contains("auto")) {//有title的稿件，校验标题是否包括auto
                    hasTestData = true;//找到了打标
                    break;//退出循环
                }
            }
        }
        if (hasTestData) System.out.println("找到了自动化测试稿件" + ob2.get("title"));//找到了打印信息
        else System.out.println("没找到自动化测试稿件");//没找到打印信息
        return ob2;
    }

}
