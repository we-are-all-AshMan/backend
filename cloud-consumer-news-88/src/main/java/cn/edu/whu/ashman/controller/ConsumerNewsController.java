package cn.edu.whu.ashman.controller;

import cn.edu.whu.ashman.entities.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Zhuyuhan
 * @date 2020-07-12 0:00
 */
@RestController
@RefreshScope
public class ConsumerNewsController {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${provider.url}")
    private String serverURL;

    @GetMapping("/consumer/news/refreshNews")
    public CommonResult refreshNews(){
        return restTemplate.getForObject(serverURL+"/news/refreshNews",CommonResult.class);
    }
    @GetMapping("/consumer/news/refreshDescNation")
    public CommonResult refreshDescNation(){
        return restTemplate.getForObject(serverURL+"/news/refreshDescNation",CommonResult.class);
    }
    @GetMapping("/consumer/news/refreshDescForeign")
    public CommonResult refreshForeign(){
        return restTemplate.getForObject(serverURL+"/news/refreshDescForeign",CommonResult.class);
    }
    @GetMapping("/consumer/news/refreshDescGlobal")
    public CommonResult refreshGlobal(){
        return restTemplate.getForObject(serverURL+"/news/refreshDescGlobal",CommonResult.class);
    }
    /**
     * 查询所有新闻给用户
     */
    @GetMapping("/consumer/news/getAllNews")
    public CommonResult getAllNews(){
        return restTemplate.getForObject(serverURL+"/news/getAllNews",CommonResult.class);
    }

    @GetMapping("/consumer/news/getNewsByDate/{date}")
    public CommonResult getAllNews(@PathVariable("date") String date){
        return restTemplate.getForObject(serverURL+"/news/getNewsByDate/"+date,CommonResult.class);
    }

    @GetMapping("/consumer/news/delete/{id}")
    public CommonResult deleteNews(@PathVariable("id")String id){
        return restTemplate.getForObject(serverURL+"/news/delete/"+id,CommonResult.class);
    }

    @GetMapping("/consumer/news/getAllDescNation/{date}")
    public CommonResult getAllDescNation(@PathVariable("date") String date){
        return restTemplate.getForObject(serverURL+"/news/getAllDescNation/"+date,CommonResult.class);
    }

    @GetMapping("/consumer/news/getAllDescForeign/{date}")
    public CommonResult getAllDescForeign(@PathVariable("date") String date){
        return restTemplate.getForObject(serverURL+"/news/getAllDescForeign/"+date,CommonResult.class);
    }

    @GetMapping("/consumer/news/getAllDescGlobal/{date}")
    public CommonResult getAllDescGlobal(@PathVariable("date") String date){
        return restTemplate.getForObject(serverURL+"/news/getAllDescGlobal/"+date,CommonResult.class);
    }

    @GetMapping("/consumer/news/updateNewsTag/{id}")
    public CommonResult updateNewsTagById(@PathVariable("id") String id){
        return restTemplate.getForObject(serverURL+"/news/updateNewsTag/"+id,CommonResult.class);
    }

    @GetMapping("/consumer/news/getNationCurrentConfirmedCounts")
    public CommonResult getNationCurrentConfirmedCounts(){
        return restTemplate.getForObject(serverURL+"/news/getNationCurrentConfirmedCounts",CommonResult.class);
    }

    @GetMapping("/consumer/news/getGlobalCurrentConfirmedCounts")
    public CommonResult getGlobalCurrentConfirmedCounts(){
        return restTemplate.getForObject(serverURL+"/news/getGlobalCurrentConfirmedCounts",CommonResult.class);
    }
}
