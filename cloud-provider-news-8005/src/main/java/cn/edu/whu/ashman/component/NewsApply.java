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
//@Component
public class NewsApply {

    @Autowired
    NewsJsonExplainUtil newsJsonExplainUtil;


    /**
     * 读取api并保存新闻进数据库
     */
    public int saveNews(){
        //NewsJsonExplainUtil newsJsonExplainUtil = new NewsJsonExplainUtil();
        //解析json新闻数据存数据库
        return newsJsonExplainUtil.jsonToNews();
    }

    /**
     * 读取api并保存国内疫情数据进数据库
     */
    public int saveDescNation(){
        //解析json国内疫情数据存数据库
        return newsJsonExplainUtil.jsonToDescNation();
    }

    /**
     * 读取api并保存外国疫情数据进数据库
     */
    public int saveDescForeign(){
        return newsJsonExplainUtil.jsonToDescForeign();
    }

    /**
     * 读取api并保存全球疫情数据进数据库
     */
    public int saveDescGlobal(){
        return newsJsonExplainUtil.jsonToDescGlobal();
    }
}
