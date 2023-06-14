package content;

import base.MITestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;

/**
 * @author wufeng
 * @date 2023/6/13 9:33
 */
public class ContentDetailTest extends MITestBase {

    @Test
    public void testGetActicleDetail() {
        ContentDetail.getActicleDetail();
    }
}