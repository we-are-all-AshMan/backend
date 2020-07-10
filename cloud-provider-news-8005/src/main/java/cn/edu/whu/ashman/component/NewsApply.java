package cn.edu.whu.ashman.component;

import cn.edu.whu.ashman.util.NewsJsonExplainUtil;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Zhuyuhan
 * @date 2020-07-10 18:28
 * 新闻应用组件类
 */
@Component
public class NewsApply {

    @Autowired
    NewsJsonExplainUtil newsJsonExplainUtil;


    /**
     * 读取api并保存新闻进数据库
     */
    public void saveNews(){
        //NewsJsonExplainUtil newsJsonExplainUtil = new NewsJsonExplainUtil();
        //解析json新闻数据存数据库
        newsJsonExplainUtil.jsonToNews();
    }

    /**
     * 读取api并保存国内疫情数据进数据库
     */
    public void saveDescNation(){
        //解析json国内疫情数据存数据库
        newsJsonExplainUtil.jsonToDescNation();
    }

    /**
     * 读取api并保存外国疫情数据进数据库
     */
    public void saveDescForeign(){
        newsJsonExplainUtil.jsonToDescForeign();
    }

    /**
     * 读取api并保存全球疫情数据进数据库
     */
    public void saveDescGlobal(){
        newsJsonExplainUtil.jsonToDescGlobal();
    }
}
