import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @author wufeng
 * @date 2023/6/8 10:48
 */

public class MIBase {


    //获取环境配置
    public static List<String> env() {

//        String envString = "envtest";//测试环境
//        String envString = "envyanshi";//演示环境
        String envString = "envyqtest";//延庆测试环境

        Properties pro = new Properties();
        InputStream prois;

        List<String> envlist = new ArrayList<>();
        try {
            prois = new FileInputStream("application.properties");
            pro.load(new InputStreamReader(prois, "UTF-8"));

            String domain = (String) pro.getProperty(envString + ".domain");
            String phone = (String) pro.getProperty(envString + ".phone");
            String password = (String) pro.getProperty(envString + ".password");
            String appID = (String) pro.getProperty(envString + ".appID");
            String siteID = (String) pro.getProperty(envString + ".siteID");
            String modelType = (String) pro.getProperty(envString + ".modelType");
            String versionName = (String) pro.getProperty(envString + ".versionName");
            String platfrom = (String) pro.getProperty(envString + ".platfrom");
            String deviceToken = (String) pro.getProperty(envString + ".deviceToken");

            envlist.add(domain);
            envlist.add(phone);
            envlist.add(password);
            envlist.add(appID);
            envlist.add(siteID);
            envlist.add(modelType);
            envlist.add(versionName);
            envlist.add(platfrom);
            envlist.add(deviceToken);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return envlist;
    }

    //获取客户端签名
    public static String getSign() {

        String signStr;
        Map hashMap = Login.getLoginBaseMap();//获取基本参数
        hashMap.put("apiSign", "a8caae40d5d94bda8ac15b1875d09834");//增加apiSign

        signStr = ParamRequestBuilder.param(hashMap);//生成签名
        return signStr;
    }

}
