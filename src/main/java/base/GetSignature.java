package base;

import java.util.HashMap;

/**
 * @author wufeng
 * @date 2023/6/9 17:11
 */
public class GetSignature {

    //获取客户端签名
    public static String getSign(HashMap map) {

        String signStr;
        map.put("apiSign", "a8caae40d5d94bda8ac15b1875d09834");//增加apiSign

        signStr = ParamRequestBuilder.param(map);//生成签名
        map.remove("apiSign");//删除掉map中的apiSign

        return signStr;
    }
}
