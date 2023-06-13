package content;

import base.MITestBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

/**
 * @author wufeng
 * @date 2023/6/8 11:03
 */
public class ContentListTest extends MITestBase {


    @Test//获取稿件列表，测试test频道
    public void testGetContentList() {
        String url = "/json/channel/test2/list.json";
        Response response = given().get(url);
        response.
                then().
                statusCode(200).
                contentType(JSON);
        System.out.println(response.asString());
    }

    @Test//分条显示每一条稿件信息
    public void testList() {
        String url = "/json/channel/test2/list.json";
        Response response = given().get(url);
        response.
                then().
                statusCode(200).
                contentType(JSON);
        ContentList.getDatas(response);
    }

    @Test//获取自动化测试稿件（标题为“auto”开头的）
    public void testGetTestData() {
        String url = "/json/channel/test2/list.json";
        Response response = given().get(url);
        response.then().statusCode(200).contentType(JSON);
        ContentList.getTestData(response);
    }
}
