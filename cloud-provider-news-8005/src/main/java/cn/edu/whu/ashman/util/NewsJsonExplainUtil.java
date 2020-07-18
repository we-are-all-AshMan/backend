package cn.edu.whu.ashman.util;

import cn.edu.whu.ashman.Service.IDescForeignService;
import cn.edu.whu.ashman.Service.IDescGlobalService;
import cn.edu.whu.ashman.Service.IDescNationService;
import cn.edu.whu.ashman.Service.INewsService;
import cn.edu.whu.ashman.entities.DescForeign;
import cn.edu.whu.ashman.entities.DescGlobal;
import cn.edu.whu.ashman.entities.DescNation;
import cn.edu.whu.ashman.entities.News;
import com.google.gson.JsonObject;
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
        }
        else {
            System.out.println("疫情api调用失败");
        }
        return news0;

    }

    /**
     * 返回 0 是 今日首次拉取新闻并成功
     * 返回 -1 是今日首次拉去新闻并出错
     * 返回 10 是 当前新闻已是最新，不需要更新
     * 返回 20 是 当前新闻已更新到最新
     * @return
     */
    public int jsonToNews() {
        Integer insertNews = 0;
        String date = getDate();
        //如果今日已拉取，可能会查找有没有更新
        if(iNewsService.refreshOrNot(date)) {
            //不需要更新返回10，有需要更新返回20
            System.out.println("今日已拉取，查找有无更新");
            return updateNews();
        }
        //今日首次拉取
        System.out.println("今日新闻首次刷新");
        JSONArray newsList = newsJsonExplain().getJSONArray("news");
        for (int i = 0; i < newsList.length(); i++) {
            JSONObject newObject = newsList.getJSONObject(i);
            News news1 = explainNewsI(newObject);
            int insert = 0;
            //插入新闻
            insert = iNewsService.insert(news1);
            //如果插入新闻成功
            if (insert > 0) {
                System.out.println("插入新闻"+ news1.getId() +"成功");
            }
            else {
                System.out.println("插入新闻" + news1.getId() + "失败");
                insertNews = -1;
            }
            //System.out.println(title);
        }
        return insertNews;
    }

    /**
     * 解析具体的某条新闻json数据，返回News对象
     * @param newObject
     * @return
     */
    private News explainNewsI(JSONObject newObject){
        String date = getDate();
        String title = newObject.get("title").toString();
        String id = newObject.get("id").toString();
        String sourceUrl = newObject.get("sourceUrl").toString();
        String summary = newObject.get("summary").toString();
        String infoSource = newObject.get("infoSource").toString();
        System.out.println("解析新闻" + id + "成功");
        News news1 = new News(id, title, summary, infoSource, sourceUrl, date, 0);
        System.out.println(news1);
        return news1;
    }

    /**
     * 获取今日时间yyyy-MM-dd
     * @return
     */
    private String getDate(){
        Date dateNow = new Date();
        String date = simpleDateFormat.format(dateNow);
        return date;
    }

    /**
     * 检查更新新闻
     * 返回 10 不需要更新
     * 返回 20 需要更新
     * @return
     */
    private int updateNews() {
        //默认不需要更新
        int tag = 10;
        JSONArray newsList = newsJsonExplain().getJSONArray("news");
        for (int i = 0; i < newsList.length(); i++) {
            JSONObject newObject = newsList.getJSONObject(i);
            News news1 = explainNewsI(newObject);
            System.out.println(news1);
            int insert = 0;
            try {
                insert = iNewsService.insert(news1);
            }
            catch (Exception e){
                System.out.println("新闻" + news1.getId() + "已经存在");
            }
            if(insert>0){
                //有更新的
                tag = 20;
            }
        }
        return tag;
    }

    /**
     * 返回 0 是 今日首次拉取国内疫情并成功
     * 返回 -1 是今日首次拉去国内疫情并出错
     * 返回 10 是 当前国内疫情已是最新，不需要更新
     * 返回 20 是 当前国内疫情已更新到最新
     * @return
     */
    public int jsonToDescNation(){
        String date = getDate();
        JSONObject desc = newsJsonExplain().getJSONObject("desc");
        if(iDescNationService.getDescNation(date)!=null){
            //更新数据
            if(updateDescNation(desc)>0) {
                System.out.println("更新今日国内疫情数据成功");
                return 20;
            }
            else {
                System.out.println("今日国内疫情数据已是最新");
                return 10;
            }
        }
        DescNation descNation = createDescNation(desc);
        int insert = iDescNationService.insert(descNation);
        if(insert>0) {
            System.out.println("今日首次插入国内疫情数据成功");
            insert = 0;
        }
        else System.out.println("首次插入国内疫情数据失败");
        return insert;
    }

    private DescNation createDescNation(JSONObject desc){
        String date = getDate();
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
        return descNation;
    }

    private int updateDescNation(JSONObject desc){
        DescNation descNation = createDescNation(desc);
        int insert = iDescNationService.update(descNation);
        return insert;
    }
    /**
     * 解析插入或更新外国疫情数据
     */
    public int jsonToDescForeign(){
        Date dateNow = new Date();
        String date = simpleDateFormat.format(dateNow);
        JSONObject desc = newsJsonExplain().getJSONObject("desc");
        JSONObject foreign = desc.getJSONObject("foreignStatistics");
        if(iDescForeignService.getDescForeign(date)!=null){
            //更新数据
            if(updateDescForeign(foreign)>0) {
                System.out.println("更新今日外国疫情数据成功");
                return 20;
            }
            else {
                System.out.println("今日外国疫情数据已是最新");
                return 10;
            }
        }
        DescForeign descForeign = createDescForeign(foreign);
        int insert = iDescForeignService.insert(descForeign);
        if(insert>0) {
            System.out.println("插入外国疫情数据成功");
            insert = 0;
        }
        else System.out.println("插入外国疫情数据失败");
        return insert;
    }

    private DescForeign createDescForeign(JSONObject foreign){
        String date = getDate();
        String currentConfirmedCount = null;
        String confirmedCount = null;
        String suspectedCount = null;
        String curedCount = null;
        String deadCount = null;
        //String seriousCount = null;
        String suspectedIncr = null;
        String currentConfirmedIncr = null;
        String confirmedIncr = null;
        String curedIncr = null;
        String deadIncr = null;
        if (foreign.has("currentConfirmedCount")) {
            currentConfirmedCount = foreign.get("currentConfirmedCount").toString();
        }
        if (foreign.has("confirmedCount")) {
            confirmedCount = foreign.get("confirmedCount").toString();
        }
        if (foreign.has("suspectedCount")) {
            suspectedCount = foreign.get("suspectedCount").toString();
        }
        if (foreign.has("curedCount")) {
            curedCount = foreign.get("curedCount").toString();
        }
        if (foreign.has("deadCount")) {
            deadCount = foreign.get("deadCount").toString();
        }
        //String seriousCount = foreign.getString("seriousCount");
        if (foreign.has("suspectedIncr")) {
            suspectedIncr = foreign.get("suspectedIncr").toString();
        }
        if (foreign.has("currentConfirmedIncr")) {
            currentConfirmedIncr = foreign.get("currentConfirmedIncr").toString();
        }
        if (foreign.has("confirmedIncr")) {
            confirmedIncr = foreign.get("confirmedIncr").toString();
        }
        if(foreign.has("curedIncr")) {
            curedIncr = foreign.get("curedIncr").toString();
        }
        if(foreign.has("deadIncr")) {
            deadIncr = foreign.get("deadIncr").toString();
        }
        //String seriousIncr = foreign.getString("seriousIncr");
        DescForeign descForeign = new DescForeign(date,currentConfirmedCount,confirmedCount,
                suspectedCount,curedCount,deadCount,suspectedIncr,currentConfirmedIncr,
                confirmedIncr,curedIncr,deadIncr);
        System.out.println(descForeign);
        return descForeign;
    }

    private int updateDescForeign(JSONObject foreign){
        DescForeign descForeign = createDescForeign(foreign);
        return iDescForeignService.update(descForeign);
    }
    /**
     * 解析插入或更新国际疫情数据
     */
    public int jsonToDescGlobal(){
        String date = getDate();
        JSONObject desc = newsJsonExplain().getJSONObject("desc");
        JSONObject global = desc.getJSONObject("globalStatistics");
        if(iDescGlobalService.getDescGlobal(date)!=null){
            //更新数据
            if(updateDescGlobal(global)>0) {
                System.out.println("更新今日全球疫情数据成功");
                return 20;
            }
            else {
                System.out.println("今日全球疫情数据已是最新");
                return 10;
            }
        }
        DescGlobal descGlobal = createDescGlobal(global);
        int insert = iDescGlobalService.insert(descGlobal);
        if(insert>0) {
            System.out.println("插入全球疫情数据成功");
            insert = 0;
        }
        else System.out.println("插入全球疫情数据失败");
        return insert;
    }

    private int updateDescGlobal(JSONObject global){
        DescGlobal descGlobal = createDescGlobal(global);
        return iDescGlobalService.update(descGlobal);
    }

    private DescGlobal createDescGlobal(JSONObject global){
        String currentConfirmedCount = null;
        String confirmedCount = null;
        String curedCount = null;
        String deadCount = null;
        String currentConfirmedIncr = null;
        String confirmedIncr = null;
        String curedIncr = null;
        String deadIncr = null;
        if (global.has("currentConfirmedCount")) {
            currentConfirmedCount = global.get("currentConfirmedCount").toString();
        }
        if (global.has("confirmedCount")) {
            confirmedCount = global.get("confirmedCount").toString();
        }
        if (global.has("curedCount")) {
            curedCount = global.get("curedCount").toString();
        }
        if (global.has("deadCount")) {
            deadCount = global.get("deadCount").toString();
        }
        //String seriousCount = foreign.getString("seriousCount");
        if (global.has("currentConfirmedIncr")) {
            currentConfirmedIncr = global.get("currentConfirmedIncr").toString();
        }
        if (global.has("confirmedIncr")) {
            confirmedIncr = global.get("confirmedIncr").toString();
        }
        if(global.has("curedIncr")) {
            curedIncr = global.get("curedIncr").toString();
        }
        if(global.has("deadIncr")) {
            deadIncr = global.get("deadIncr").toString();
        }
        DescGlobal descGlobal = new DescGlobal(getDate(),currentConfirmedCount,confirmedCount,
                curedCount,deadCount,currentConfirmedIncr,
                confirmedIncr,curedIncr,deadIncr);
        System.out.println(descGlobal);
        return descGlobal;
    }
}
