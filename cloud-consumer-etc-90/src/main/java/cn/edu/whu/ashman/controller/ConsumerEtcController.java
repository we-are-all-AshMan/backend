package cn.edu.whu.ashman.controller;

import cn.edu.whu.ashman.entities.CommonResult;
import cn.edu.whu.ashman.entities.ETC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @author Zhuyuhan
 * @date 2020-07-18 11:06
 */
@RestController
public class ConsumerEtcController {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${provider.url}")
    private String SERVER_URL;

    @GetMapping("/consumer/etc/select/{openId}")
    public CommonResult getEtcByOpenId(@PathVariable("openId")String openId){
        return restTemplate.getForObject(SERVER_URL+"/etc/select/"+openId,CommonResult.class);
    }

    /**
     * 提交信息
     * @param etc
     * @return
     */
    @GetMapping("/consumer/etc/create")
    public CommonResult createEtc(ETC etc){
        return restTemplate.postForObject(SERVER_URL+"/etc/create",etc,CommonResult.class);
    }

    @GetMapping("/consumer/etc/getAll")
    public CommonResult getAllEtc(){
        return restTemplate.getForObject(SERVER_URL+"/etc/getAll",CommonResult.class);
    }

    @GetMapping("/consumer/etc/getByState/{state}")
    public CommonResult getByDate(@PathVariable Integer state){
        return restTemplate.getForObject(SERVER_URL+"/etc/getByState/"+state,CommonResult.class);
    }

    @GetMapping("/consumer/etc/sendMessage/{tel}")
    public CommonResult sendCode(@PathVariable String tel){
        return restTemplate.getForObject(SERVER_URL+"/etc/sendMessage/"+tel,CommonResult.class);
    }

    @GetMapping("/consumer/etc/update")
    public CommonResult update(ETC etc){
        return restTemplate.postForObject(SERVER_URL+"/etc/update",etc,CommonResult.class);
    }

    @GetMapping("/consumer/etc/updateState")
    public CommonResult updateState(ETC etc){
        return restTemplate.postForObject(SERVER_URL+"/etc/updateState",etc,CommonResult.class);
    }
}
