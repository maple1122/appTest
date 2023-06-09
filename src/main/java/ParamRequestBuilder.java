import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParamRequestBuilder  {

    protected static final Map<String, String> mParams = new HashMap<String, String>();

    public Map<String, String> params() {
        return Collections.unmodifiableMap(mParams);
    }

    public <T> ParamRequestBuilder param(String key, T value) {
        if (key != null && !key.isEmpty() && value != null) {
            mParams.put(key, String.valueOf(value));
        }
        return this;
    }
    
//    MD5加密
    public static String getMD5(String instr) {
        String s = null;
//        System.out.println("ssss=="+instr);
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(instr.getBytes());
            byte tmp[] = md.digest();
            char str[] = new char[16 * 2];
            int k = 0;
            for (int i = 0; i < 16; i++) {
                byte byte0 = tmp[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];

                str[k++] = hexDigits[byte0 & 0xf];
            }
            s = new String(str);
            

        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }
//  map传参生成signature
    public static String param(Map<String, String> map) {
        List<String> params = new ArrayList<>();
        String mKey;
        String mValue;
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                mKey = entry.getKey();
                mValue = entry.getValue();
                if (mValue!=null && !mValue.equals("")) {
                    if (!mKey.equals("apiSign")) {
                        //加密参数apiSign不上传
                        mParams.put(mKey, mValue);
                    }
                    params.add(mValue);
                }
            }
        }
        if (!params.isEmpty()) {
            Collections.sort(params);
        }
        StringBuffer sb = new StringBuffer();
        for (String str : params) {
            sb.append(str);
        }
        String originParamStr = sb.toString();
        String encryptParamStr = "";
        encryptParamStr = getMD5(originParamStr);
         if (encryptParamStr!=null && !encryptParamStr.equals("")) {
            mParams.put("signature", encryptParamStr);
        }
        return  encryptParamStr;
        
     }

}
