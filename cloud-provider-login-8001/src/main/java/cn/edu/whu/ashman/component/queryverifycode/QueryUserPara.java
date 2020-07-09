package cn.edu.whu.ashman.component.queryverifycode;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Zhuyuhan
 * @date 2020-07-09 17:28
 */

/**
 * 查询用户的最近验证请求的请求参数封装类
 */
public class QueryUserPara {
    private String tel;
    private String year;
    private String month;
    private String day;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    public QueryUserPara(String tel){
        this.tel = tel;
        Date date = new Date();
        String dateAfterFormat = simpleDateFormat.format(date);
        System.out.println(dateAfterFormat);
        this.year = dateAfterFormat.substring(0,3);
        this.month = dateAfterFormat.substring(5,6);
        this.day = dateAfterFormat.substring(8,9);
    }

    public String getYear() {
        return year;
    }

    public String getMonth() {
        return month;
    }

    public String getDay() {
        return day;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
