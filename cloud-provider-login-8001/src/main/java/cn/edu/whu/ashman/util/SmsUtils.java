package cn.edu.whu.ashman.util;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

/**
 * @author Liu weifan
 **/

/**
 * 阿里云发送短信验证码类
 */
public class SmsUtils {
    private static String phoneNumber = "123";
    private static int code;

    private static void setPhoneNumber(String phoneNumber) {
        SmsUtils.phoneNumber = phoneNumber;
    }

    public static int getCode() {
        return code;
    }

    private static void setCode() {
        //随机生成一个四位的验证码
        code = (int)(Math.random()*9999)+100;
    }

    /**
     * 发送验证码，并返回验证码
     * @param phoneNumber
     * @return
     */
    public static int shortMesssageText(String phoneNumber) {
        setCode();
        setPhoneNumber(phoneNumber);

        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4G9Y7wpjrh3oYqR1D1Yw", "k2RZaOZr9hYiU4m3ckVtzykLYNrUBZ");
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
       /* request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");*/
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phoneNumber);
        request.putQueryParameter("SignName", "AIGOV");
        request.putQueryParameter("TemplateCode", "SMS_195860280");
        request.putQueryParameter("TemplateParam", "{\"code\":\""+code+"\"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            return code;
            //System.out.println(response.getData());
        } catch (ServerException e) {
            //e.printStackTrace();
        } catch (ClientException e) {
            //e.printStackTrace();
        }
        //返回0表示错误
        return 0;

    }

}
