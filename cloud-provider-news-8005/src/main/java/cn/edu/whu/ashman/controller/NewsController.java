package cn.edu.whu.ashman.controller;

import cn.edu.whu.ashman.Service.IDescForeignService;
import cn.edu.whu.ashman.Service.IDescGlobalService;
import cn.edu.whu.ashman.Service.IDescNationService;
import cn.edu.whu.ashman.Service.INewsService;
import cn.edu.whu.ashman.component.NewsApply;
import cn.edu.whu.ashman.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author Zhuyuhan
 * @date 2020-07-11 10:26
 */
@RestController
public class NewsController {
    @Autowired
    NewsApply newsApply;

    @Autowired
    INewsService iNewsService;

    @Autowired
    IDescNationService iDescNationService;

    @Autowired
    IDescForeignService iDescForeignService;

    @Autowired
    IDescGlobalService iDescGlobalService;
    /**
     * 管理端拉取最新新闻
     */
    @GetMapping("/news/refreshNews")
    public CommonResult refreshNews(){
        CommonResult commonResult = null;
        int i = newsApply.saveNews();
        if(i==0)
        commonResult = new CommonResult(222,"今日首次拉取新闻成功",i);
        else if(i==20){
            commonResult = new CommonResult(255,"当前新闻已更新到最新",i);
        }
        else if(i==10){
            commonResult = new CommonResult(256,"当前新闻已是最新，不需要更新",i);
        }
        else commonResult = new CommonResult(422,"拉取新闻失败",i);
        return commonResult;
    }
    @GetMapping("/news/refreshDescNation")
    public CommonResult refreshDescNation(){
        CommonResult commonResult = null;
        int i = newsApply.saveDescNation();
        if(i==0)
            commonResult = new CommonResult(223,"今日首次拉取国内疫情成功",i);
        else if(i==20){
            commonResult = new CommonResult(256,"更新今日国内疫情数据成功",i);
        }
        else if(i==10){
            commonResult = new CommonResult(266,"今日国内疫情数据已是最新",i);
        }
        else commonResult = new CommonResult(423,"拉取国内疫情失败",i);
        return commonResult;
    }
    @GetMapping("/news/refreshDescForeign")
    public CommonResult refreshForeign(){
        CommonResult commonResult = null;
        int i = newsApply.saveDescForeign();
        if(i==0)
            commonResult = new CommonResult(224,"今日首次拉取外国疫情成功",i);
        else if(i==20){
            commonResult = new CommonResult(257,"更新今日外国疫情数据成功",i);
        }
        else if(i==10){
            commonResult = new CommonResult(267,"今日外国疫情数据已是最新",i);
        }
        else commonResult = new CommonResult(424,"拉取外国疫情失败",i);
        return commonResult;
    }
    @GetMapping("/news/refreshDescGlobal")
    public CommonResult refreshGlobal(){
        CommonResult commonResult = null;
        int i = newsApply.saveDescGlobal();
        if(i==0) commonResult = new CommonResult(225,"今日首次拉取全球疫情成功",i);
        else if(i==20){
            commonResult = new CommonResult(258,"更新今日全球疫情数据成功",i);
        }
        else if(i==10){
            commonResult = new CommonResult(268,"今日全球疫情数据已是最新",i);
        }
        else commonResult = new CommonResult(425,"拉取全球疫情失败",i);
        return commonResult;
    }
    /**
     * 查询所有新闻给用户
     */
    @GetMapping("/news/getAllNews")
    public CommonResult getAllNews(){
        CommonResult commonResult = null;
        Collection<News> news = iNewsService.getAllNews();
        commonResult = new CommonResult(233,"用户成功获取所有新闻",news);
        return commonResult;
    }

    @GetMapping("/news/getNewsByDate/{date}")
    public CommonResult getNewsByDate(@PathVariable("date") String date){
        CommonResult commonResult = null;
        Collection<News> news = iNewsService.getNewsByDate(date);
        //System.out.println(news.isEmpty());
        if(news.isEmpty()) commonResult = new CommonResult(258,"今日新闻暂未刷新",0);
        else {
            commonResult = new CommonResult(234, "用户成功获取" + date + "新闻", news);
        }
        return commonResult;
    }

    @GetMapping("/news/getAllDescNation/{date}")
    public CommonResult getAllDescNation(@PathVariable("date") String date){
        CommonResult commonResult = null;
        DescNation descNation = iDescNationService.getDescNation(date);
        if(descNation==null) commonResult = new CommonResult(259,"今日国内疫情数据暂未刷新",0);
        else {
            commonResult = new CommonResult(235, "用户成功获取国内疫情数据", descNation);
        }
        return commonResult;
    }

    @GetMapping("/news/getAllDescForeign/{date}")
    public CommonResult getAllDescForeign(@PathVariable("date") String date){
        CommonResult commonResult = null;
        DescForeign descForeign = iDescForeignService.getDescForeign(date);
        if(descForeign==null) commonResult = new CommonResult(260,"今日外国疫情数据暂未刷新",0);
        else {
            commonResult = new CommonResult(236, "用户成功获取外国疫情数据", descForeign);
        }
        return commonResult;
    }

    @GetMapping("/news/getAllDescGlobal/{date}")
    public CommonResult getAllDescGlobal(@PathVariable("date") String date){
        CommonResult commonResult = null;
        DescGlobal descGlobal = iDescGlobalService.getDescGlobal(date);
        if(descGlobal==null) commonResult = new CommonResult(261,"今日全球疫情数据暂未刷新",0);
        else {
            commonResult = new CommonResult(237, "用户成功获取全球疫情数据", descGlobal);
        }
        return commonResult;
    }

    @GetMapping("/news/updateNewsTag/{id}")
    public CommonResult updateNewsTagById(@PathVariable("id") String id){
        CommonResult commonResult = null;
        int update = iNewsService.update(id);
        if(update>0)
        commonResult = new CommonResult(238,"成功增加该新闻比重",update);
        else commonResult = new CommonResult(438,"增加该新闻比重失败",update);
        return commonResult;
    }

    @GetMapping("/news/getNationCurrentConfirmedCounts")
    public CommonResult getNationCurrentConfirmedCounts(){
        CommonResult commonResult = null;
        List<Map<String, String>> currentConfirmedCounts = iDescNationService.getCurrentConfirmedCounts(0, 7);
        if(currentConfirmedCounts.isEmpty()) commonResult = new CommonResult(462,"获取最近七天国内确诊人数失败",0);
        else {
            commonResult = new CommonResult(262,"成功获取最近七天国内确诊人数",currentConfirmedCounts);
        }
        return commonResult;
    }

    @GetMapping("/news/getGlobalCurrentConfirmedCounts")
    public CommonResult getGlobalCurrentConfirmedCounts(){
        CommonResult commonResult = null;
        List<Map<String, String>> currentConfirmedCounts = iDescGlobalService.getCurrentConfirmedCounts(0, 7);
        if(currentConfirmedCounts.isEmpty()) commonResult = new CommonResult(463,"获取最近七天全球确诊人数失败",0);
        else {
            commonResult = new CommonResult(263,"成功获取最近七天全球确诊人数",currentConfirmedCounts);
        }
        return commonResult;
    }
}
