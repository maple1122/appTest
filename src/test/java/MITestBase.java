import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
//import net.sf.json.JSONArray;
//import net.sf.json.JSONObject;

/**
 * @author wufeng
 * @date 2023/6/8 10:58
 */
public class MITestBase {

    @BeforeTest
    public void setUP() {
        RestAssured.baseURI = "http://yanqingrongmei.xytest.pdmiryun.com";
        RestAssured.port = 80;
        RestAssured.basePath = "";
    }


}
