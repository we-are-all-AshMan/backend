package cn.edu.whu.ashman.controller;

import cn.edu.whu.ashman.entities.CommonResult;
import cn.edu.whu.ashman.entities.ETC;
import cn.edu.whu.ashman.service.IETCService;
import cn.edu.whu.ashman.util.SmsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author Zhuyuhan
 * @date 2020-07-18 10:26
 */
@RestController
public class ETCController {
    @Autowired
    private IETCService ietcService;

    @GetMapping("/etc/select/{openId}")
    public CommonResult selectByOpenId(@PathVariable("openId") String openId){
        CommonResult commonResult = null;
        Collection<ETC> etcs = ietcService.selectByOpenId(openId);
        if(etcs.isEmpty()){
            commonResult = new CommonResult(200,"该用户没有办理过etc业务",null);
        }
        else {
            commonResult = new CommonResult(201,"该用户办理的etc业务如下：",etcs);
        }
        return commonResult;
    }

    @PostMapping("/etc/create")
    public CommonResult create(@RequestBody ETC etc){
        CommonResult commonResult = null;
        etc.setState(1);
        int insert = -1;
        try {
            insert = ietcService.insert(etc);
        }
        catch (Exception e){
            return new CommonResult(402,"该车辆已办理过相关业务",etc);
        }
        if(insert>0){
            commonResult = new CommonResult(202,"成功提交etc审核",etc);
        }
        else {
            commonResult = new CommonResult(404,"提交审核失败",null);
        }
        return commonResult;
    }

    @GetMapping("/etc/getAll")
    public CommonResult getAll(){
        CommonResult commonResult = null;
        try {
            Collection<ETC> etcs = ietcService.selectAll();
            commonResult = new CommonResult(203,"查询所有etc办理",etcs);
        }
        catch (Exception e){
            return new CommonResult(403,"查询所有etc异常",null);
        }
        return commonResult;
    }

    @GetMapping("/etc/sendMessage/{tel}")
    public CommonResult sendMsg(@PathVariable String tel){
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

    @GetMapping("/etc/getByState/{state}")
    public CommonResult getByDate(@PathVariable Integer state){
        CommonResult commonResult = null;
        Collection<ETC> etcs = new ArrayList<>();
        try {
            etcs = ietcService.selectByState(state);
        }
        catch (Exception e){
            return new CommonResult(402,"加载电子身份证信息失败");
        }
        if(state==1)
            commonResult = new CommonResult(202,"成功加载待审核etc信息",etcs);
        else if(state==2)
            commonResult = new CommonResult(203,"成功加载审核通过etc信息",etcs);
        return commonResult;
    }

    @PostMapping("/etc/update")
    public CommonResult update(@RequestBody ETC etc){
        CommonResult commonResult = null;
        //etc.setState(2);
        int update = ietcService.update(etc);
        if(update>0){
            commonResult = new CommonResult(204,"etc申请信息修改成功",etc);
        }
        else {
            commonResult = new CommonResult(405,"etc申请信息修改失败",null);
        }
        return commonResult;
    }

    @PostMapping("/etc/updateState")
    public CommonResult updateState(@RequestBody ETC etc){
        CommonResult commonResult = null;
        etc.setState(2);
        int update = ietcService.updateState(etc);
        if(update>0){
            commonResult = new CommonResult(204,"审核状态修改成功",etc);
        }
        else {
            commonResult = new CommonResult(405,"审核状态修改失败",null);
        }
        return commonResult;
    }
}
