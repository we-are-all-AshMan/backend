package cn.edu.whu.ashman.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 分别获取最近七天日期的工具类
 *
 * @author Zhuyuhan
 * @date 2020-07-14 17:56
 */
public class NewsDateUtil {
    private static Date getDateAdd(int day){
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH, -day);
        return c.getTime();
    }
    private static List<String> getDaysBetween(int day){
        List<String> days = new ArrayList<>();
        Calendar start = Calendar.getInstance();
        start.setTime(getDateAdd(day));
        Long startTIme = start.getTimeInMillis();
        Calendar end = Calendar.getInstance();
        end.setTime(new Date());
        Long endTime = end.getTimeInMillis();
        Long oneDay = 1000 * 60 * 60 * 24l;
        Long time = startTIme;
        while (time <= endTime) {
            Date d = new Date(time);
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            System.out.println(df.format(d));
            days.add(df.format(d));
            time += oneDay;
        }
        return days;
    }
}
