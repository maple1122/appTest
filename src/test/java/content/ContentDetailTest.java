package content;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

/**
 * @author wufeng
 * @date 2023/6/13 9:33
 */
public class ContentDetailTest {

    @Test
    public void testGetActicleDetail() {
        String url = "/contentapi/api/content/getContentDetail";
        Response response = given().get(url);
        response.then().statusCode(200);
        ContentDetail.getActicleDetail();

    }
}