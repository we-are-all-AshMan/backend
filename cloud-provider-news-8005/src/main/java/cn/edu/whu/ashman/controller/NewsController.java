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
        if(i>0)
        commonResult = new CommonResult(222,"拉取新闻成功",i);
        else commonResult = new CommonResult(422,"拉取新闻失败",i);
        return commonResult;
    }
    @GetMapping("/news/refreshDescNation")
    public CommonResult refreshDescNation(){
        CommonResult commonResult = null;
        int i = newsApply.saveDescNation();
        if(i>0)
            commonResult = new CommonResult(223,"拉取国内疫情成功",i);
        else commonResult = new CommonResult(423,"拉取国内疫情失败",i);
        return commonResult;
    }
    @GetMapping("/news/refreshDescForeign")
    public CommonResult refreshForeign(){
        CommonResult commonResult = null;
        int i = newsApply.saveDescForeign();
        if(i>0)
            commonResult = new CommonResult(224,"拉取外国疫情成功",i);
        else commonResult = new CommonResult(424,"拉取外国疫情失败",i);
        return commonResult;
    }
    @GetMapping("/news/refreshDescGlobal")
    public CommonResult refreshGlobal(){
        CommonResult commonResult = null;
        int i = newsApply.saveDescGlobal();
        if(i>0)
            commonResult = new CommonResult(225,"拉取全球疫情成功",i);
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
    public CommonResult getAllNews(@PathVariable("date") String date){
        CommonResult commonResult = null;
        Collection<News> news = iNewsService.getNewsByDate(date);
        commonResult = new CommonResult(234,"用户成功获取"+date+"新闻",news);
        return commonResult;
    }

    @GetMapping("/news/getAllDescNation/{date}")
    public CommonResult getAllDescNation(@PathVariable("date") String date){
        CommonResult commonResult = null;
        Collection<DescNation> descNation = iDescNationService.getDescNation(date);
        commonResult = new CommonResult(235,"用户成功获取国内疫情数据",descNation);
        return commonResult;
    }

    @GetMapping("/news/getAllDescForeign/{date}")
    public CommonResult getAllDescForeign(@PathVariable("date") String date){
        CommonResult commonResult = null;
        Collection<DescForeign> descForeign = iDescForeignService.getDescForeign(date);
        commonResult = new CommonResult(236,"用户成功获取外国疫情数据",descForeign);
        return commonResult;
    }

    @GetMapping("/news/getAllDescGlobal/{date}")
    public CommonResult getAllDescGlobal(@PathVariable("date") String date){
        CommonResult commonResult = null;
        Collection<DescGlobal> descGlobal = iDescGlobalService.getDescGlobal(date);
        commonResult = new CommonResult(237,"用户成功获取全球疫情数据",descGlobal);
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
}
