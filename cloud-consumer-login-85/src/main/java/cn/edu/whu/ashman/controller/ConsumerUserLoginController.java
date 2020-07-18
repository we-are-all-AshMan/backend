package cn.edu.whu.ashman.controller;

import cn.edu.whu.ashman.entities.CommonResult;
import cn.edu.whu.ashman.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Zhuyuhan
 * @date 2020-07-11 19:52
 */
@RestController
@RefreshScope
public class ConsumerUserLoginController {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${provider.url}")
    private String serverURL;

    @GetMapping("/consumer/login/sendMessageCode/{phoneNumber}")
    public CommonResult getMessageCode(@PathVariable("phoneNumber") String phoneNumber){
        System.out.println("客户端"+"手机号码为："+phoneNumber);
        return restTemplate.getForObject(serverURL+"/login/sendMessageCode/"+phoneNumber,CommonResult.class);
    }

    /**
     * 用户注册按钮提交
     * @param user
     * @return
     */
    @GetMapping("/consumer/login/createUser")
    public CommonResult createUser(User user){
        //路径参数这样配置
        return restTemplate.postForObject(serverURL+"/login/createUser",user,CommonResult.class);
    }

    /**
     * 微信授权注册
     * @param userJson
     * @return
     *//*
    @GetMapping("/consumer/login/createByWeChat")
    public CommonResult createUserByWeChat(String userJson){
        //http请求体这样传
        return restTemplate.postForObject(serverURL+"/login/createByWeChat",userJson,CommonResult.class);
    }*/

    /**
     * 修改信息可能会用到
     * @param user
     * @return
     */
    @GetMapping("/consumer/login/update")
    public CommonResult updateUser(User user){
        return restTemplate.postForObject(serverURL+"/login/update",user,CommonResult.class);
    }

    /**
     * 按openId查询用户有没有绑定手机号
     * @param openId
     * @return
     */
    @GetMapping("/consumer/login/select/{openId}")
    public CommonResult selectUser(@PathVariable("openId") String openId){
        return restTemplate.getForObject(serverURL+"/login/select/"+openId,CommonResult.class);
    }

    /**
     * 登录
     * @return
     *//*
    @GetMapping("/consumer/login/signIn")
    public CommonResult signIn(User user){
       *//* Map<String,String> request = new HashMap<>();
        request.put("tel",tel);
        request.put("password",password);*//*
        return restTemplate.postForObject(serverURL+"/login/signIn",user,CommonResult.class);
    }*/
}
