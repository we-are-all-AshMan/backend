package cn.edu.whu.ashman.controller;

import cn.edu.whu.ashman.entities.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * @author Zhuyuhan
 * @date 2020-07-11 19:52
 */
@RestController
public class ConsumerLoginController {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String serverURL;

    @GetMapping("/consumer/login/sendMessageCode/{phoneNumber}")
    public CommonResult getMessageCode(@PathVariable("phoneNumber") String phoneNumber){
        System.out.println("客户端"+"手机号码为："+phoneNumber);
        return restTemplate.getForObject(serverURL+"/login/sendMessageCode/"+phoneNumber,CommonResult.class);
    }

    /**
     * 手机号注册按钮提交
     * @param user
     * @param code
     * @return
     */
    @GetMapping("/login/createByPhone/{code}")
    public CommonResult createUserByPhone(User user,@PathVariable("code") int code){
        CommonResult commonResult = null;
        if(code==SmsUtils.getCode()) {
            iUserService.insertUserService(user);
            System.out.println("注册用户：" + user);
            commonResult = new CommonResult(200, "新建用户插入数据库成功");
        }
        /*if(code==3578) {
            iUserService.insertUserService(user);
            System.out.println("注册用户：" + user);
            commonResult = new CommonResult(200, "新建用户插入数据库成功");
        }*/
        else {
            commonResult = new CommonResult(401,"验证码错误");
        }
        return commonResult;
    }

    /**
     * 微信授权注册
     * @param userJson
     * @return
     */
    @PostMapping("/login/createByWeChat")
    public CommonResult createUserByWeChat(String userJson){
        User user = null;
        Map<String, String> loginData = WeChatLoginJsonUtil.getLoginData(userJson);
        user = new User(null,null,null,loginData.get("openId"),loginData.get("unionId"));
        iUserService.insertUserService(user);
        System.out.println("注册用户："+user);
        CommonResult commonResult = new CommonResult(200,"新建用户插入数据库成功");
        return commonResult;
    }

    /**
     * 修改密码可能会用到
     * @param user
     * @return
     */
    @PostMapping("/login/update")
    public CommonResult updateUser(User user){
        iUserService.updateUserService(user);
        System.out.println("修改用户名或密码为："+user);
        CommonResult commonResult = new CommonResult(201,"用户修改成功");
        return commonResult;
    }

    /**
     * 按用户名查询，可用于测试
     * @param username
     * @return
     */
    @GetMapping("/login/select/{username}")
    public CommonResult selectUser(@PathVariable("username") String username){
        CommonResult commonResult = null;
        User user = iUserService.selectUserByNameService(username);
        commonResult = new CommonResult(202,"查询用户成功",user);
        return commonResult;
    }

    @PostMapping("/login/signIn")
    public CommonResult signIn(@RequestParam("tel") String tel, @RequestParam("password") String password){
        CommonResult commonResult = null;
        User userByTel = iUserService.selectUserByTel(tel);
        if(userByTel.getPassword().equals(password)){
            commonResult = new CommonResult(203,"登录成功",userByTel);
        }
        else {
            commonResult = new CommonResult(400,"手机号或密码不正确",null);
        }
        return commonResult;
    }
}
