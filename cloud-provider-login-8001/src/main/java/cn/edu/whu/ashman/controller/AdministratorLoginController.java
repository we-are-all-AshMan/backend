package cn.edu.whu.ashman.controller;


import cn.edu.whu.ashman.entities.Administrator;
import cn.edu.whu.ashman.entities.CommonResult;
import cn.edu.whu.ashman.service.IAdministratorService;
import cn.edu.whu.ashman.service.impl.AdministratorService;
import cn.edu.whu.ashman.util.SmsUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Liu WeiFan
 * @create 2020年7月11日 20：56
 */
@RestController
@Slf4j
public class AdministratorLoginController {

    @Autowired
    private IAdministratorService administratorService;


    /**
     * 发送验证码
     * @param phoneNumber
     * @return
     */
    @GetMapping("/administrator/login/sendMessageCode/{phoneNumber}")
    public CommonResult getMessageCode(@PathVariable("phoneNumber") String phoneNumber){
        //System.out.println("手机号码为："+phoneNumber);
        CommonResult commonResult = null;
        //发验证码
        SmsUtils.shortMesssageText(phoneNumber);
        commonResult = new CommonResult(299,"成功发送验证码");
        return commonResult;
    }


    /**
     * 验证验证码
     * @param administrator
     * @param code
     * @return
     */
    @PostMapping("/administrator/login/createByPhone/{code}")
    public CommonResult createUserByPhone(Administrator administrator, @PathVariable("code") int code){
        CommonResult commonResult = null;
        if(code==SmsUtils.getCode()) {
            administratorService.insertAdministratorService(administrator);
            commonResult = new CommonResult(200, "新建用户插入数据库成功");
        }
        else {
            commonResult = new CommonResult(401,"验证码错误");
        }
        return commonResult;
    }

    /**
     * 登录
     * @param userName
     * @param password
     * @return
     */
    @PostMapping("/administrator/logIn/signIn")
    public CommonResult signIn(@PathVariable("uerName") String userName,
                               @PathVariable("password") String password){
        CommonResult commonResult =null;
        if(administratorService.selectAdministratorByNameService(userName) == null){
            commonResult = new CommonResult(202,"该用户不存在");
        }
        else if(administratorService.selectAdministratorByNameService(userName).getPassword() == password){
            commonResult = new CommonResult(203,"密码正确");
        }else {
            commonResult =new CommonResult(204,"密码错误");
        }
        return commonResult;
    }

    /**
     * 修改密码
     * @param administrator
     * @return
     */
    @PostMapping("/administrator/login/update")
    public CommonResult updateUser(Administrator administrator){
        administratorService.updateAdministratorService(administrator);
        CommonResult commonResult = new CommonResult(201,"密码修改成功");
        return commonResult;
    }


}
