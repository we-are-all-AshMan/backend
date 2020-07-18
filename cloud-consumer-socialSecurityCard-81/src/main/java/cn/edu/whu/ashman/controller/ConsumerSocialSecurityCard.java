package cn.edu.whu.ashman.controller;

import cn.edu.whu.ashman.entities.CommonResult;
import cn.edu.whu.ashman.entities.Identity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import cn.edu.whu.ashman.entities.SocialSecurityCard;
/**
 * @Author LiuWeiFan
 * @create 2020/7/18 11:26
 */
@RestController
@RefreshScope
public class ConsumerSocialSecurityCard {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${provider.url}")
    private String SERVER_URL;

    @GetMapping("/consumer/socialSecurityCard/getSocialSecurityCardByOpenId/{openId}")
    public CommonResult getSocialSecurityCardByOpenId(@PathVariable("openId")String openId){
        return restTemplate.getForObject(SERVER_URL+"/socialSecurityCard/getSocialSecurityCardByOpenId/"+openId,CommonResult.class);
    }


    @GetMapping("/consumer/socialSecurityCard/create")
    public CommonResult createSocialSecurityCard(SocialSecurityCard socialSecurityCard){
        return restTemplate.postForObject(SERVER_URL+"/socialSecurityCard/create",socialSecurityCard,CommonResult.class);
    }

    @GetMapping("/consumer/socialSecurityCard/getAll")
    public CommonResult getAllSocialSecurityCard(){
        return restTemplate.getForObject(SERVER_URL+"/socialSecurityCard/getAll",CommonResult.class);
    }

    @GetMapping("/consumer/socialSecurityCard/getByState/{state}")
    public CommonResult getByDate(@PathVariable Integer state){
        return restTemplate.getForObject(SERVER_URL+"/socialSecurityCard/getByState/"+state,CommonResult.class);
    }

    @GetMapping("/consumer/socialSecurityCard/sendMessage/{tel}")
    public CommonResult sendCode(@PathVariable String tel){
        return restTemplate.getForObject(SERVER_URL+"/socialSecurityCard/sendMessage/"+tel,CommonResult.class);
    }

    @GetMapping("/consumer/socialSecurityCard/update")
    public CommonResult update(SocialSecurityCard socialSecurityCard){
        return restTemplate.postForObject(SERVER_URL+"/socialSecurityCard/update",socialSecurityCard,CommonResult.class);
    }

    @GetMapping("/consumer/socialSecurityCard/delete/{openId}")
    public CommonResult delete(@PathVariable String openId){
        return restTemplate.getForObject(SERVER_URL+"/socialSecurityCard/delete/"+openId,CommonResult.class);

    }
}
