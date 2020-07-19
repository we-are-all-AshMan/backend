package cn.edu.whu.ashman.component;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

/**
 * 获取短信验证码详情
 *
 * @author Zhuyuhan
 * @date 2020-07-09 17:17
 */

/**
 * 可查询用户的最近验证请求，返回json数据
 */
public class GetQuerySendDetails {
    static String currentPage = "1";
    static String pageSize = "10";
    String phoneNumber = null;
    String sendDate = null;
    public void query(QueryUserPara queryUser){
        this.sendDate = queryUser.getYear()+queryUser.getMonth()+queryUser.getDay();
        System.out.println(sendDate);
        this.phoneNumber = queryUser.getTel();
        /*String queryUrl = "http(s)://[Endpoint]/?CurrentPage="+currentPage+"\n" +
                "&PageSize="+pageSize+"\n" +
                "&PhoneNumber="+this.phoneNumber+"\n" +
                "&SendDate="+this.sendDate+"&Format=JSON";*/
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "<accessKeyId>", "<accessSecret>");
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("QuerySendDetails");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumber", phoneNumber);
        request.putQueryParameter("SendDate", sendDate);
        request.putQueryParameter("PageSize", pageSize);
        request.putQueryParameter("CurrentPage",currentPage);
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }
}
