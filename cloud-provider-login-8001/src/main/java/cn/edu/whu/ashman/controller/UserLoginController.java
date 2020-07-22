package cn.edu.whu.ashman.controller;


import cn.edu.whu.ashman.entities.CommonResult;
import cn.edu.whu.ashman.entities.User;
import cn.edu.whu.ashman.service.IUserService;
import cn.edu.whu.ashman.util.SmsUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 登录控制类
 *
 * @author Zhuyuhan
 * @date 2020-07-09 20:09
 */
@RestController
@Slf4j//加日志
public class UserLoginController {
    @Autowired
    private IUserService iUserService;

    /**
     * 请求发送验证码
     * @param phoneNumber
     * @return
     */
    @GetMapping("/login/sendMessageCode/{phoneNumber}")
    public CommonResult getMessageCode(@PathVariable("phoneNumber") String phoneNumber){
        System.out.println("手机号码为："+phoneNumber);
        CommonResult commonResult = null;
        if(phoneNumber.length()!=11){
            return new CommonResult(455,"手机号长度不正确");
        }
        else if(iUserService.selectUserByTel(phoneNumber)!=null){
            return new CommonResult(444,"该手机号已被注册过");
        }
        else {
            //发验证码
            SmsUtils.shortMesssageText(phoneNumber);
            commonResult = new CommonResult(299, "成功发送验证码:", SmsUtils.getCode());
        }
        return commonResult;
    }

    /**
     * 手机号绑定提交
     * @param user
     * @return
     */
    @PostMapping("/login/createUser")
    public CommonResult createUser(@RequestBody User user){
        CommonResult commonResult = null;
        int i = iUserService.insertUserService(user);
        if(i>0) {
            System.out.println("注册用户：" + user);
            commonResult = new CommonResult(200, "新建用户成功", user);
        }
        else {
            commonResult = new CommonResult(400, "新建用户失败", user);
        }
        return commonResult;
    }

    /**
     * 微信授权注册
     * @param userJson
     * @return
     *//*
    @PostMapping("/login/createByWeChat")
    public CommonResult createUserByWeChat(@RequestBody String userJson){
        User user = null;
        Map<String, String> loginData = WeChatLoginJsonUtil.getLoginData(userJson);
        user = new User(null,null,null,loginData.get("openId"),loginData.get("unionId"));
        iUserService.insertUserService(user);
        System.out.println("注册用户："+user);
        CommonResult commonResult = new CommonResult(200,"新建用户插入数据库成功");
        return commonResult;
    }*/

    /**
     * 修改信息可能会用到
     * @param user
     * @return
     */
    @PostMapping("/login/update")
    public CommonResult updateUser(@RequestBody User user){
        iUserService.updateUserService(user);
        System.out.println("修改用户名信息为："+user);
        CommonResult commonResult = new CommonResult(201,"用户修改成功");
        return commonResult;
    }

    /**
     * 查看用户有没有绑定手机号
     * @param openId
     * @return
     */
    @GetMapping("/login/select/{openId}")
    public CommonResult selectUser(@PathVariable("openId") String openId){
        CommonResult commonResult = null;
        User user = iUserService.selectUserOpenIdService(openId);
        if(user==null){
            commonResult = new CommonResult(403,"该用户没有绑定手机号");
        }
        else {
            commonResult = new CommonResult(202, "该用户已完成手机号绑定", user);
        }
        return commonResult;
    }

    /*@PostMapping("/login/signIn")
    public CommonResult signIn(@RequestBody User user){
        CommonResult commonResult = null;
        User userByTel = iUserService.selectUserByTel(user.getTel());
        if(userByTel.getPassword().equals(user.getPassword())){
            commonResult = new CommonResult(203,"登录成功",userByTel);
        }
        else {
            commonResult = new CommonResult(400,"手机号或密码不正确",null);
        }
        return commonResult;
    }*/
}
