package cn.edu.whu.ashman.controller;

import cn.edu.whu.ashman.entities.Administrator;
import cn.edu.whu.ashman.entities.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Zhuyuhan
 * @date 2020-07-11 22:51
 */
@RestController
public class ConsumerAdminLoginController {
    @Value("${service-url.nacos-user-service}")
    private String serverURL;
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/administrator/login/sendMessageCode/{phoneNumber}")
    public CommonResult getMessageCode(@PathVariable("phoneNumber") String phoneNumber){
        return restTemplate.getForObject(serverURL+"/administrator/login/sendMessageCode/"+phoneNumber,CommonResult.class);
    }


    /**
     * 验证验证码
     * @param administrator
     * @param code
     * @return
     */
    @GetMapping("/consumer/administrator/login/createByPhone/{code}")
    public CommonResult createUserByPhone(@RequestBody Administrator administrator, @PathVariable("code") int code){
        return restTemplate.postForObject(serverURL+"/administrator/login/createByPhone/"+code,administrator,CommonResult.class);
    }

    /**
     * 登录
     * @return
     */
    @GetMapping("/consumer/administrator/logIn/signIn")
    public CommonResult signIn(Administrator administrator){
        //Map<String,String> request = new HashMap<>();
        return restTemplate.postForObject(serverURL+"/administrator/logIn/signIn",administrator,CommonResult.class);
    }

    /**
     * 修改密码
     * @param administrator
     * @return
     */
    @GetMapping("/consumer/administrator/login/update")
    public CommonResult updateUser(Administrator administrator){
       return restTemplate.postForObject(serverURL+"/administrator/login/update",administrator,CommonResult.class);
    }
}
