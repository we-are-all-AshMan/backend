package cn.edu.whu.ashman.controller;

import cn.edu.whu.ashman.entities.CommonResult;
import cn.edu.whu.ashman.entities.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户电子身份证绑定controller
 *
 * @author Zhuyuhan
 * @date 2020-07-17 9:58
 */
@RestController
public class UserIdentityController {

    @PostMapping("/identity/bindUser")
    public CommonResult updateUser(@RequestBody User user){
        CommonResult commonResult = null;
        if(user.)
        return commonResult;
    }
}
