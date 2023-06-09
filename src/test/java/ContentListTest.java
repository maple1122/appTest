import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

/**
 * @author wufeng
 * @date 2023/6/8 11:03
 */
public class ContentListTest extends MITestBase {

    String url = "/json/channel/jj/list.json";

    @Test
    public void testGetContentList() {
        Response response = given().get(url);
        response.
                then().
                statusCode(200).
                contentType(JSON);
        System.out.println(response.asString());
    }

    @Test//分条显示每一条稿件信息
    public void testList(){
        Response response = given().get(url);
        response.
                then().
                statusCode(200).
                contentType(JSON);
        ContentList.getData(response);
    }
}
