package cn.edu.whu.ashman.controller;

import cn.edu.whu.ashman.entities.CommonResult;
import cn.edu.whu.ashman.entities.User;
import cn.edu.whu.ashman.service.IUserService;
import cn.edu.whu.ashman.util.SmsUtils;
import cn.edu.whu.ashman.util.WeChatLoginJsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 登录控制类
 *
 * @author Zhuyuhan
 * @date 2020-07-09 20:09
 */
@RestController
//@Slf4j//加日志
public class LoginController {
    @Autowired
    private IUserService iUserService;

    @GetMapping("/login/sendMessageCode")
    public CommonResult getMessageCode(String phoneNumber){
        CommonResult commonResult = null;
        //发验证码
        SmsUtils.shortMesssageText(phoneNumber);
        commonResult = new CommonResult(299,"成功发送验证码");
        return commonResult;
    }

    @PostMapping("/login/createByPhone/{code}")
    public CommonResult createUserByPhone(User user,@PathVariable("code") int code){
        CommonResult commonResult = null;
        /*if(code==SmsUtils.getCode()) {
            iUserService.insertUserService(user);
            System.out.println("注册用户：" + user);
            commonResult = new CommonResult(200, "新建用户插入数据库成功");
        }*/
        if(code==1234) {
            iUserService.insertUserService(user);
            System.out.println("注册用户：" + user);
            commonResult = new CommonResult(200, "新建用户插入数据库成功");
        }
        else {
            commonResult = new CommonResult(401,"验证码错误");
        }
        return commonResult;
    }

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

    @PostMapping("/login/update")
    public CommonResult updateUser(User user){
        iUserService.updateUserService(user);
        System.out.println("修改用户名或密码为："+user);
        CommonResult commonResult = new CommonResult(201,"用户修改成功");
        return commonResult;
    }

    @GetMapping("/login/select/{username}")
    public CommonResult selectUser(@PathVariable("username") String username){
        CommonResult commonResult = null;
        User user = iUserService.selectUserByNameService(username);
        commonResult = new CommonResult(202,"查询用户成功",user);
        return commonResult;
    }

}
