package cn.edu.whu.ashman.util;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


/**
 * 解析微信登陆Json数据
 *
 * @author Zhuyuhan
 * @date 2020-07-09 17:15
 */
public class WeChatLoginJsonUtil {
    public static Map<String,String> getLoginData(String js){
        Map<String,String> userInfo = new HashMap<>();
        JSONObject userJsonInfo = new JSONObject(js);
        String openId = userJsonInfo.get("openId").toString();
        String unionId = userJsonInfo.get("unionId").toString();
        /*String nickName = userJsonInfo.get("nickName").toString();
        String gender = userJsonInfo.get("gender").toString();
        String city = userJsonInfo.get("city").toString();
        String province = userJsonInfo.get("province").toString();
        String country = userJsonInfo.get("country").toString();*/
        userInfo.put("openId",openId);
        userInfo.put("unionId",unionId);

        return userInfo;
    }
}
