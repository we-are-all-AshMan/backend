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
        String date = simpleDateFormat.format(dateNow);
        //如果刷新过了
        if(iNewsService.refreshOrNot(date)) {
            insertNews = 0;
            return insertNews;
        }
        JSONArray newsList = newsJsonExplain().getJSONArray("news");
        for (int i = 0; i < newsList.length(); i++) {
            JSONObject newObject = newsList.getJSONObject(i);
            String title = newObject.get("title").toString();
            String id = newObject.get("id").toString();
            String sourceUrl = newObject.get("sourceUrl").toString();
            String summary = newObject.get("summary").toString();
            String infoSource = newObject.get("infoSource").toString();
            System.out.println("解析新闻" + i + "成功");
            News news1 = new News(id, title, summary, infoSource, sourceUrl, date, 0);
            System.out.println(news1);
            int insert = 0;
            insert = iNewsService.insert(news1);
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
        String date = simpleDateFormat.format(dateNow);
        if(iDescNationService.getDescNation(date)!=null){
            return 0;
        }
        JSONObject desc = newsJsonExplain().getJSONObject("desc");
        String currentConfirmedCount = desc.get("currentConfirmedCount").toString();
        String confirmedCount = desc.get("confirmedCount").toString();
        String suspectedCount = desc.get("suspectedCount").toString();
        String curedCount = desc.get("curedCount").toString();
        String deadCount = desc.get("deadCount").toString();
        String seriousCount = desc.get("seriousCount").toString();
        String suspectedIncr = desc.get("suspectedIncr").toString();
        String currentConfirmedIncr = desc.get("currentConfirmedIncr").toString();
        String confirmedIncr = desc.get("confirmedIncr").toString();
        String curedIncr = desc.get("curedIncr").toString();
        String deadIncr = desc.get("deadIncr").toString();
        String seriousIncr = desc.get("seriousIncr").toString();
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
        String date = simpleDateFormat.format(dateNow);
        if(iDescForeignService.getDescForeign(date)!=null){
            return 0;
        }
        JSONObject desc = newsJsonExplain().getJSONObject("desc");
        JSONObject foreign = desc.getJSONObject("foreignStatistics");
        String currentConfirmedCount = foreign.get("currentConfirmedCount").toString();
        String confirmedCount = foreign.get("confirmedCount").toString();
        String suspectedCount = foreign.get("suspectedCount").toString();
        String curedCount = foreign.get("curedCount").toString();
        String deadCount = foreign.get("deadCount").toString();
        //String seriousCount = foreign.getString("seriousCount");
        String suspectedIncr = foreign.get("suspectedIncr").toString();
        String currentConfirmedIncr = foreign.get("currentConfirmedIncr").toString();
        String confirmedIncr = foreign.get("confirmedIncr").toString();
        String curedIncr = foreign.get("curedIncr").toString();
        String deadIncr = foreign.get("deadIncr").toString();
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
        String date = simpleDateFormat.format(dateNow);
        if(iDescGlobalService.getDescGlobal(date)!=null){
            return 0;
        }
        JSONObject desc = newsJsonExplain().getJSONObject("desc");
        JSONObject global = desc.getJSONObject("globalStatistics");
        String currentConfirmedCount = global.get("currentConfirmedCount").toString();
        String confirmedCount = global.get("confirmedCount").toString();
        String curedCount = global.get("curedCount").toString();
        String deadCount = global.get("deadCount").toString();
        String currentConfirmedIncr = global.get("currentConfirmedIncr").toString();
        String confirmedIncr = global.get("confirmedIncr").toString();
        String curedIncr = global.get("curedIncr").toString();
        String deadIncr = global.get("deadIncr").toString();
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
