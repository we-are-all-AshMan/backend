package cn.edu.whu.ashman;

import cn.edu.whu.ashman.Service.INewsService;
import cn.edu.whu.ashman.component.NewsApply;
import cn.edu.whu.ashman.entities.News;
import cn.edu.whu.ashman.util.NewsJsonExplainUtil;
import cn.edu.whu.ashman.util.NewsInterfaceUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collection;

/**
 * @author Zhuyuhan
 * @date 2020-07-10 15:43
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class NewsTest {

    @Autowired
    INewsService iNewsService;

    @Autowired
    NewsApply newsApply;

    /**
     * 底层新闻api请求工具单元测试
     */
    @Test
    public void jsonResultTest(){
        String news = NewsInterfaceUtil.requestNews();
        System.out.println(news);
    }

    @Test
    public void saveNewsTest(){
        //NewsApply newsApply = new NewsApply();
        newsApply.saveNews();
    }

    @Test
    public void saveNationTest(){
        newsApply.saveDescNation();
    }

    @Test
    public void saveForeignTest(){
        newsApply.saveDescForeign();
    }

    @Test
    public void saveGlobalTest(){
        newsApply.saveDescGlobal();
    }

    @Test
    public void getAllNews(){
        Collection<News> allNews = iNewsService.getAllNews();
        for(Object news:allNews.toArray()){
            News news1 = (News)news;
            System.out.println(news1);
        }
    }
}
