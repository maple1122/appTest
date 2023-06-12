package base;

import business.Login;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

/**
 * @author wufeng
 * @date 2023/6/9 16:13
 */
public class GetUserInfo extends Login {


    //获取用户id
    public String getUserID() {
        String userID = null;
        Response response = getLoginValue();//登录返回值
        JsonPath jsonPath = response.jsonPath();//返回值类型转换
        userID=jsonPath.get("id").toString();//获取json中的用户id

        return userID;
    }

}
