package cn.edu.whu.ashman.util;

import cn.edu.whu.ashman.Service.IDescForeignService;
import cn.edu.whu.ashman.Service.IDescGlobalService;
import cn.edu.whu.ashman.Service.IDescNationService;
import cn.edu.whu.ashman.Service.INewsService;
import cn.edu.whu.ashman.entities.DescForeign;
import cn.edu.whu.ashman.entities.DescGlobal;
import cn.edu.whu.ashman.entities.DescNation;
import cn.edu.whu.ashman.entities.News;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 解析json数据
 *
 * @author Zhuyuhan
 * @date 2020-07-10 15:41
 */

/**
 * 单例对象的深层理解
 * https://www.cnblogs.com/dengguangxue/p/11555453.html
 */
//@Service
public class NewsJsonExplainUtil {

    Date dateNow = new Date();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    /*@PostConstruct
    private void init(){
        iNewsService = new NewsService();
    }*/
    @Autowired
    private IDescGlobalService iDescGlobalService;
    @Autowired
    private IDescForeignService iDescForeignService;
    @Autowired
    private IDescNationService iDescNationService;
    @Autowired
    private INewsService iNewsService;
    /**
     * 调用api底层封装类并解析json数据到newsList
     */
    private JSONObject newsJsonExplain(){
        JSONObject news0 = null;
        String news = NewsInterfaceUtil.requestNews();
        JSONObject jsonObject = new JSONObject(news);
        String code = jsonObject.get("code").toString();
        if(code.equals("200")){
            System.out.println("疫情api调用成功");
            JSONArray allArray = jsonObject.getJSONArray("newslist");
            JSONObject jsonObject1 = allArray.getJSONObject(0);
            news0 = jsonObject1;
            return news0;
        }
        else {
            System.out.println("疫情api调用失败");
            return news0;
        }

    }

    /**
     * 解析新闻并插入数据库
     */
    public int jsonToNews() {
        Integer insertNews = 1;
        JSONArray newsList = newsJsonExplain().getJSONArray("news");
        for (int i = 0; i < newsList.length(); i++) {
            JSONObject newObject = newsList.getJSONObject(i);
            String title = newObject.get("title").toString();
            String id = newObject.get("id").toString();
            String sourceUrl = newObject.get("sourceUrl").toString();
            String summary = newObject.get("summary").toString();
            String infoSource = newObject.get("infoSource").toString();
            String date = simpleDateFormat.format(dateNow);
            System.out.println("解析新闻" + i + "成功");
            News news1 = new News(id, title, summary, infoSource, sourceUrl, date, 0);
            System.out.println(news1);
            int insert = iNewsService.insert(news1);
            //newsService.insert(news1);
            if (insert > 0) System.out.println("插入新闻" + i + "成功");
            else {
                System.out.println("插入新闻" + i + "失败");
                insertNews = -1;
            }
            //System.out.println(title);
        }
        return insertNews;
    }

    /**
     * 解析国内疫情数据并存数据库
     */
    public int jsonToDescNation(){
        JSONObject desc = newsJsonExplain().getJSONObject("desc");
        String date = simpleDateFormat.format(dateNow);
        String currentConfirmedCount = desc.get("currentConfirmedCount").toString();
        String confirmedCount = desc.getString("confirmedCount");
        String suspectedCount = desc.getString("suspectedCount");
        String curedCount = desc.getString("curedCount");
        String deadCount = desc.getString("deadCount");
        String seriousCount = desc.getString("seriousCount");
        String suspectedIncr = desc.getString("suspectedIncr");
        String currentConfirmedIncr = desc.getString("currentConfirmedIncr");
        String confirmedIncr = desc.getString("confirmedIncr");
        String curedIncr = desc.getString("curedIncr");
        String deadIncr = desc.getString("deadIncr");
        String seriousIncr = desc.getString("seriousIncr");
        DescNation descNation = new DescNation(date,currentConfirmedCount,confirmedCount,
                suspectedCount,curedCount,deadCount,suspectedIncr,currentConfirmedIncr,
                confirmedIncr,curedIncr,deadIncr,seriousCount,seriousIncr);
        System.out.println(descNation);
        int insert = iDescNationService.insert(descNation);
        if(insert>0) System.out.println("插入国内疫情数据成功");
        else System.out.println("插入国内疫情数据失败");
        return insert;
    }
    /**
     * 解析外国疫情数据并存数据库
     */
    public int jsonToDescForeign(){
        JSONObject desc = newsJsonExplain().getJSONObject("desc");
        JSONObject foreign = desc.getJSONObject("foreignStatistics");
        String date = simpleDateFormat.format(dateNow);
        String currentConfirmedCount = foreign.get("currentConfirmedCount").toString();
        String confirmedCount = foreign.getString("confirmedCount");
        String suspectedCount = foreign.getString("suspectedCount");
        String curedCount = foreign.getString("curedCount");
        String deadCount = foreign.getString("deadCount");
        //String seriousCount = foreign.getString("seriousCount");
        String suspectedIncr = foreign.getString("suspectedIncr");
        String currentConfirmedIncr = foreign.getString("currentConfirmedIncr");
        String confirmedIncr = foreign.getString("confirmedIncr");
        String curedIncr = foreign.getString("curedIncr");
        String deadIncr = foreign.getString("deadIncr");
        //String seriousIncr = foreign.getString("seriousIncr");
        DescForeign descForeign = new DescForeign(date,currentConfirmedCount,confirmedCount,
                suspectedCount,curedCount,deadCount,suspectedIncr,currentConfirmedIncr,
                confirmedIncr,curedIncr,deadIncr);
        System.out.println(descForeign);
        int insert = iDescForeignService.insert(descForeign);
        if(insert>0) System.out.println("插入外国疫情数据成功");
        else System.out.println("插入外国疫情数据失败");
        return insert;
    }
    /**
     * 解析国际疫情数据并存数据库
     */
    public int jsonToDescGlobal(){
        JSONObject desc = newsJsonExplain().getJSONObject("desc");
        JSONObject global = desc.getJSONObject("globalStatistics");
        String date = simpleDateFormat.format(dateNow);
        String currentConfirmedCount = global.get("currentConfirmedCount").toString();
        String confirmedCount = global.getString("confirmedCount");
        //String suspectedCount = global.getString("suspectedCount");
        String curedCount = global.getString("curedCount");
        String deadCount = global.getString("deadCount");
        //String seriousCount = global.getString("seriousCount");
        //String suspectedIncr = global.getString("suspectedIncr");
        String currentConfirmedIncr = global.getString("currentConfirmedIncr");
        String confirmedIncr = global.getString("confirmedIncr");
        String curedIncr = global.getString("curedIncr");
        String deadIncr = global.getString("deadIncr");
        //String seriousIncr = global.getString("seriousIncr");
        DescGlobal descGlobal = new DescGlobal(date,currentConfirmedCount,confirmedCount,
                curedCount,deadCount,currentConfirmedIncr,
                confirmedIncr,curedIncr,deadIncr);
        System.out.println(descGlobal);
        int insert = iDescGlobalService.insert(descGlobal);
        if(insert>0) System.out.println("插入外国疫情数据成功");
        else System.out.println("插入外国疫情数据失败");
        return insert;
    }
}
