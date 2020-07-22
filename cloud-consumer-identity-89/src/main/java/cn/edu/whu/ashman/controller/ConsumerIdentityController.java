package cn.edu.whu.ashman.controller;

import cn.edu.whu.ashman.entities.CommonResult;
import cn.edu.whu.ashman.entities.Identity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @author Zhuyuhan
 * @date 2020-07-17 17:35
 */
@RestController
@RefreshScope
public class ConsumerIdentityController {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${provider.url}")
    private String SERVER_URL;

    @GetMapping("/consumer/identity/getIdentityByOpenId/{openId}")
    public CommonResult getIdentityByOpenId(@PathVariable("openId")String openId){
        return restTemplate.getForObject(SERVER_URL+"/identity/getIdentityByOpenId/"+openId,CommonResult.class);
    }

    /**
     * 提交信息
     * @param identity
     * @return
     */
    @GetMapping("/consumer/identity/create")
    public CommonResult createIdentity(Identity identity){
        return restTemplate.postForObject(SERVER_URL+"/identity/create",identity,CommonResult.class);
    }

    @GetMapping("/consumer/identity/updateState")
    public CommonResult updateState(Identity identity){
        return restTemplate.postForObject(SERVER_URL+"/identity/updateState",identity,CommonResult.class);
    }

    @GetMapping("/consumer/identity/getAll")
    public CommonResult getAllIdentity(){
        return restTemplate.getForObject(SERVER_URL+"/identity/getAll",CommonResult.class);
    }

    @GetMapping("/consumer/identity/getByState/{state}")
    public CommonResult getByDate(@PathVariable Integer state){
        return restTemplate.getForObject(SERVER_URL+"/identity/getByState/"+state,CommonResult.class);
    }

    @GetMapping("/consumer/identity/sendMessage/{tel}")
    public CommonResult sendCode(@PathVariable String tel){
        return restTemplate.getForObject(SERVER_URL+"/identity/sendMessage/"+tel,CommonResult.class);
    }
}
