package base;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author wufeng
 * @date 2023/6/8 10:48
 */

public class MIBase {

    //域名初始化
    @BeforeMethod
    public void setUP() {
        RestAssured.baseURI = env().get(0);
        RestAssured.port = 80;
        RestAssured.basePath = "";
    }

    //获取环境配置
    public static List<String> env() {

        //切换环境
//        String envString = "envtest";//测试环境
//        String envString = "envyanshi";//演示环境
        String envString = "envyqtest";//延庆测试环境

        Properties pro = new Properties();
        InputStream prois;

        List<String> envlist = new ArrayList<>();//环境list
        try {
            prois = new FileInputStream("application.properties");//配置文件对象
            pro.load(new InputStreamReader(prois, "UTF-8"));//加载配置文件

            //获取配置文件中的参数
            String domain = (String) pro.getProperty(envString + ".domain");
            String phone = (String) pro.getProperty(envString + ".phone");
            String password = (String) pro.getProperty(envString + ".password");
            String appID = (String) pro.getProperty(envString + ".appID");
            String siteID = (String) pro.getProperty(envString + ".siteID");
            String modelType = (String) pro.getProperty(envString + ".modelType");
            String versionName = (String) pro.getProperty(envString + ".versionName");
            String platfrom = (String) pro.getProperty(envString + ".platfrom");
            String deviceToken = (String) pro.getProperty(envString + ".deviceToken");
            String userId = (String) pro.getProperty(envString + ".userId");
            String mediaId = (String) pro.getProperty(envString + ".mediaId");

            //添加到环境list中
            envlist.add(domain);
            envlist.add(phone);
            envlist.add(password);
            envlist.add(appID);
            envlist.add(siteID);
            envlist.add(modelType);
            envlist.add(versionName);
            envlist.add(platfrom);
            envlist.add(deviceToken);
            envlist.add(userId);
            envlist.add(mediaId);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return envlist;
    }

}
