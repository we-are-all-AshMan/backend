package cn.edu.whu.ashman.controller;

import cn.edu.whu.ashman.entities.CommonResult;
import cn.edu.whu.ashman.entities.Policy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author LiuWeiFan
 * @create 2020/7/19 21:33
 */
@RestController
@RefreshScope
public class ConsumerPolicyController {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${provider.url}")
    private String SERVER_URL;

    /**
     * 返回所有政策信息，consumer端
     * @return
     */
    @GetMapping("/consumer/policy/getAll")
    public CommonResult getAllPolicies(){
        return restTemplate.getForObject(SERVER_URL+"/policy/getAll",CommonResult.class);
    }

    /**
     * 返回分页政策信息
     * @param curPage
     * @return
     */
    @GetMapping("/consumer/policy/getPoliciesByPage/{curPage}")
    public CommonResult getPoliciesByPage(@PathVariable("curPage") int curPage){
        return restTemplate.getForObject(SERVER_URL+"/policy/getPolicyByPage/"+curPage,CommonResult.class);
    }

    /**
     * 添加政策
     * @param policy
     * @return
     */
    @GetMapping("/consumer/policy/addPolicy")
    public CommonResult addPolicy(Policy policy){
        return restTemplate.postForObject(SERVER_URL+"/policy/getPolicyByPage/",policy,CommonResult.class);
    }

    /**
     * 根据标签获取政策标题
     * @param tag
     * @return
     */
    @GetMapping("/consumer/policy/getPolicyByTag/{tag}")
    public CommonResult getPolicyByTag(@PathVariable("tag") String tag){
        return restTemplate.getForObject(SERVER_URL+"/policy/getPolicyByTag/"+tag,CommonResult.class);
    }

    /**
     * 根据标题获取政策信息
     * @param title
     * @return
     */
    @GetMapping("/consumer/policy/getPolicyByTitle/{title}")
    public CommonResult getPolicyByTitle(@PathVariable("title") String title){
        return restTemplate.getForObject(SERVER_URL+"/policy/getPolicyByTitle/"+title,CommonResult.class);
    }

    /**
     * 获取相似政策标题，使用字符串匹配
     * @param message
     * @return
     */
    @GetMapping("/consumer/policy/getSimilarTitle/{message}")
    public CommonResult getSimilarByTitle(@PathVariable("message") String message){
        return restTemplate.getForObject(SERVER_URL+"/policy/getSimilarTitle/"+message,CommonResult.class);
    }
}
