package cn.edu.whu.ashman.configuration;

import cn.edu.whu.ashman.component.NewsApply;
import cn.edu.whu.ashman.util.NewsJsonExplainUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Zhuyuhan
 * @date 2020-07-11 13:48
 */
@Configuration
public class NewsConfig {

    @Bean
    public NewsJsonExplainUtil getNewsJsonExplainUtil(){
        return new NewsJsonExplainUtil();
    }

    @Bean
    public NewsApply getNewsApply(){
        return new NewsApply();
    }
}
