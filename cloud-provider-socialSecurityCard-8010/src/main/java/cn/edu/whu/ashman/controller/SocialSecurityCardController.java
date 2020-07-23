package cn.edu.whu.ashman.controller;

import cn.edu.whu.ashman.entities.CommonResult;
import cn.edu.whu.ashman.entities.SocialSecurityCard;
import cn.edu.whu.ashman.service.ISocialSecurityCardService;
import cn.edu.whu.ashman.util.SmsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @Author LiuWeiFan
 * @create 2020/7/18 10:55
 */
@RestController
public class SocialSecurityCardController {

    @Autowired
    ISocialSecurityCardService iSocialSecurityCardService = null;

    /**
     * 查询状态
     * @param openId
     * @return
     */
    @GetMapping("/socialSecurityCard/getSocialSecurityCardByOpenId/{openId}")
    public CommonResult getSocialSecurityCardByOpenId(@PathVariable("openId") String openId) {
        CommonResult commonResult = null;
        SocialSecurityCard socialSecurityCard = iSocialSecurityCardService.getSocialSecurityCardByOpenId(openId);
        try {
            if (socialSecurityCard == null) {
                SocialSecurityCard socialSecurityCard1 = new SocialSecurityCard(openId);
                socialSecurityCard1.setState(0);
                iSocialSecurityCardService.insertSocialSecurityCard(socialSecurityCard1);
                commonResult = new CommonResult(308, "该用户未激活社保卡", socialSecurityCard1);
            } else if (socialSecurityCard.getState() == 0) {
                commonResult = new CommonResult(307, "该用户未激活社保卡", socialSecurityCard);
            } else if (socialSecurityCard.getState() == 3) {
                commonResult = new CommonResult(306, "该用户激活社保卡正在审核", socialSecurityCard);
            } else if (socialSecurityCard.getState() == 4) {
                commonResult = new CommonResult(305, "该用户激活社保卡已审核通过", socialSecurityCard);
            } else {
                commonResult = new CommonResult(304, "发生错误", socialSecurityCard);
            }
        } catch (Exception e) {
            e.printStackTrace();
            commonResult = new CommonResult(303, "服务器异常");
        }
        return commonResult;
    }

    /**
     * 提交
     * @param socialSecurityCard
     * @return
     */
    @PostMapping("/socialSecurityCard/create")
    public CommonResult createSocialSecurityCard(@RequestBody SocialSecurityCard socialSecurityCard) {
        CommonResult commonResult = null;
        socialSecurityCard.setState(3);
        System.out.println(socialSecurityCard);
        try {
            int update = iSocialSecurityCardService.updateSocialSecurityCard(socialSecurityCard);
            if (update > 0) {
                commonResult = new CommonResult(309, "成功提交激活社保卡申请", socialSecurityCard);
            } else {
                commonResult = new CommonResult(304, "提交失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            commonResult = new CommonResult(303, "服务器异常");
        }
        return commonResult;
    }

    /**
     * 获取所有
     * @return
     */
    @GetMapping("/socialSecurityCard/getAll")
    public CommonResult getAllSocialSecurityCard() {
        CommonResult commonResult = null;
        try {
            Collection<SocialSecurityCard> socialSecurityCards = iSocialSecurityCardService.getAllSocialSecurityCards();
            commonResult = new CommonResult(310, "成功加载所有社保卡信息", socialSecurityCards);
        } catch (Exception e) {
            e.printStackTrace();
            commonResult = new CommonResult(303, "服务器异常，加载失败");
        }
        return commonResult;
    }

    /**
     * 根据状态获取
     * @param state
     * @return
     */
    @GetMapping("/socialSecurityCard/getByState/{state}")
    public CommonResult getByDate(@PathVariable Integer state) {
        CommonResult commonResult = null;
        Collection<SocialSecurityCard> socialSecurityCards = new ArrayList<>();
        try {
            socialSecurityCards = iSocialSecurityCardService.getSocialSecurityCardsByState(state);
        } catch (Exception e) {
            e.printStackTrace();
            return new CommonResult(303, "服务器异常，加载社保卡信息失败");
        }
        if (state == 3)
            commonResult = new CommonResult(202, "成功加载待审核社保卡信息", socialSecurityCards);
        else if (state == 4)
            commonResult = new CommonResult(203, "成功加载审核通过社保卡信息", socialSecurityCards);
        return commonResult;
    }

    /**
     * 发短信验证
     * @param tel
     * @return
     */
    @GetMapping("/socialSecurityCard/sendMessage/{tel}")
    public CommonResult sendCode(@PathVariable String tel) {
        CommonResult commonResult = null;
        try {
            if (tel.length() != 11) {
                return new CommonResult(304, "手机号长度不正确");
            } else {
                //发验证码
                SmsUtils.shortMesssageText(tel);
                commonResult = new CommonResult(311, "成功发送验证码:", SmsUtils.getCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
            commonResult = new CommonResult(303, "服务器异常，未能成功发送验证码");
        }
        return commonResult;
    }

    /**
     * 审核通过
     * @param socialSecurityCard
     * @return
     */
    @PostMapping("/socialSecurityCard/update")
    public CommonResult update(@RequestBody SocialSecurityCard socialSecurityCard) {
        CommonResult commonResult = null;
        socialSecurityCard.setState(4);
        try {
            int update = iSocialSecurityCardService.updateState(socialSecurityCard);
            if (update > 0) {
                commonResult = new CommonResult(309, "社保卡激活申请通过", socialSecurityCard);
            } else {
                commonResult = new CommonResult(304, "提交失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            commonResult = new CommonResult(303, "服务器异常");
        }
        return commonResult;
    }

    /**
     * 注销社保卡激活信息
     * @param openId
     * @return
     */
    @GetMapping("/socialSecurityCard/delete/{openId}")
    public CommonResult delete(@PathVariable String openId) {
        CommonResult commonResult = null;
        try {
            iSocialSecurityCardService.delete(openId);
            commonResult = new CommonResult(310, "成功注销该用户社保卡激活信息");
        } catch (Exception e) {
            e.printStackTrace();
            commonResult = new CommonResult(303, "服务器异常，加载失败");
        }
        return commonResult;
    }
}
