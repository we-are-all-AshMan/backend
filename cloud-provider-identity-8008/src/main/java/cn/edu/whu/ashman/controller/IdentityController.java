package cn.edu.whu.ashman.controller;

import cn.edu.whu.ashman.entities.CommonResult;
import cn.edu.whu.ashman.entities.Identity;
import cn.edu.whu.ashman.service.IIdentityService;
import cn.edu.whu.ashman.util.SmsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Zhuyuhan
 * @date 2020-07-17 16:20
 */
@RestController
public class IdentityController {
    @Autowired
    private IIdentityService iIdentityService;

    @GetMapping("/identity/getIdentityByOpenId/{openId}")
    public CommonResult getIdentityByOpenId(@PathVariable("openId")String openId){
        CommonResult commonResult = null;
        Identity identity = iIdentityService.selectByOpenId(openId);
        if(identity==null){
            Identity identity1 = new Identity(openId);
            identity1.setState(0);
            iIdentityService.insert(identity1);
            commonResult = new CommonResult(266,"该用户未办理电子身份证",identity1);
        }
        else if(identity.getState()==0){
            commonResult = new CommonResult(269,"该用户未办理电子身份证",identity);
        }
        else if(identity.getState()==3){
            commonResult = new CommonResult(267,"该用户办理电子身份证正在审核",identity);
        }
        else if(identity.getState()==4){
            commonResult = new CommonResult(268,"该用户办理电子身份证已审核通过",identity);
        }
        else {
            commonResult = new CommonResult(468,"发生错误",identity);
        }
        return commonResult;
    }

    /**
     * 提交信息
     * @param identity
     * @return
     */
    @PostMapping("/identity/create")
    public CommonResult createIdentity(@RequestBody Identity identity){
        CommonResult commonResult = null;
        identity.setState(3);
        int update = iIdentityService.update(identity);
        if(update>0){
            commonResult = new CommonResult(200,"成功提交电子身份证申请",identity);
        }
        else {
            commonResult = new CommonResult(400,"提交失败");
        }
        return commonResult;
    }

    @GetMapping("/identity/getAll")
    public CommonResult getAllIdentity(){
        CommonResult commonResult = null;
        try {
            Collection<Identity> identities = iIdentityService.selectAll();
            commonResult = new CommonResult(201,"成功加载所有电子身份证信息",identities);
        }
        catch (Exception e){
            commonResult = new CommonResult(401,"加载所有电子身份证信息失败");
        }
        return commonResult;
    }

    @GetMapping("/identity/getByState/{state}")
    public CommonResult getByDate(@PathVariable Integer state){
        CommonResult commonResult = null;
        Collection<Identity> identities = new ArrayList<>();
        try {
            identities = iIdentityService.selectByState(state);
        }
        catch (Exception e){
            return new CommonResult(402,"加载电子身份证信息失败");
        }
        if(state==3)
            commonResult = new CommonResult(202,"成功加载待审核电子身份证信息",identities);
        else if(state==4)
            commonResult = new CommonResult(203,"成功加载审核通过电子身份证信息",identities);
        return commonResult;
    }

    @GetMapping("/identity/sendMessage/{tel}")
    public CommonResult sendCode(@PathVariable String tel){
        CommonResult commonResult = null;
        if(tel.length()!=11){
            return new CommonResult(455,"手机号长度不正确");
        }
        else {
            //发验证码
            SmsUtils.shortMesssageText(tel);
            commonResult = new CommonResult(299, "成功发送验证码:", SmsUtils.getCode());
        }
        return commonResult;
    }
}
