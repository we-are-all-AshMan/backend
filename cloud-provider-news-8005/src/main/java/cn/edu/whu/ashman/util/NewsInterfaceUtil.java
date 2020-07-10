package cn.edu.whu.ashman.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author Zhuyuhan
 * @date 2020-07-10 15:34
 */
public class NewsInterfaceUtil {
    /*String httpUrl = "http://api.tianapi.com/txapi/ncov/index?key=APIKEY";
    String jsonResult = request(httpUrl);
    System.out.println(jsonResult);*/

    static String httpUrl = "http://api.tianapi.com/txapi/ncov/index?key=84fbc904d72e8d47a09fad497e6eabbc";

    /**
     * 返回疫情新闻json数据
     * @return
     */
    public static String requestNews() {
        BufferedReader reader = null;
        String result = null;
        StringBuffer sbf = new StringBuffer();

        try {
            URL url = new URL(httpUrl);
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();
            connection.setRequestMethod("GET");
            InputStream is = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                sbf.append(strRead);
                sbf.append("\r\n");
            }
            reader.close();
            result = sbf.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
