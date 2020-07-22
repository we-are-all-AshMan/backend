package cn.edu.whu.ashman.controller;

import cn.edu.whu.ashman.entities.Policy;
import cn.edu.whu.ashman.service.IPolicyService;
import cn.edu.whu.ashman.entities.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

/**
 * @Author LiuWeiFan
 * @create 2020/7/19 11:28
 */
@RestController
public class PolicyController {
    @Autowired
    IPolicyService iPolicyService = null;

    /**
     * 获取所有的政策信息
     *
     * @return
     */
    @GetMapping("/policy/getAll")
    public CommonResult getAllPolicies() {
        CommonResult commonResult = null;
        try {
            Collection<Policy> policies = iPolicyService.selectAllPolicies();
            commonResult = new CommonResult(305, "成功返回所有政策信息", policies);
        } catch (Exception e) {
            e.printStackTrace();
            commonResult = new CommonResult(303, "服务器异常，获取信息失败");
        }
        return commonResult;
    }

    /**
     * 分页获取所有的政策信息
     *
     * @param curPage
     * @return
     */
    @GetMapping("/policy/getPolicyByPage/{curPage}")
    public CommonResult getPolicyByPage(@PathVariable("curPage") int curPage) {
        CommonResult commonResult = null;
        try {
            Collection<Policy> policies = iPolicyService.selectPoliciesByPage(curPage);
            commonResult = new CommonResult(306, "成功返回政策信息", policies);
        } catch (Exception e) {
            e.printStackTrace();
            commonResult = new CommonResult(303, "服务器异常，获取信息失败");
        }
        return commonResult;
    }

    /**
     * 添加政策信息
     *
     * @param policy
     * @return
     */
    @PostMapping("/policy/addPolicy")
    public CommonResult addPolicy(@RequestBody Policy policy) {
        CommonResult commonResult = null;
        try {
            iPolicyService.insertPolicy(policy);
            commonResult = new CommonResult(307, "成功添加政策信息");
            System.out.println("成功收到信息");
        } catch (Exception e) {
            e.printStackTrace();
            commonResult = new CommonResult(303, "服务器异常，添加信息失败");
        }
        return commonResult;
    }

    /**
     * 根据标签获取政策标题
     *
     * @param tag
     * @return
     */
    @GetMapping("/policy/getPolicyByTag/{tag}")
    public CommonResult getPolicyByTag(@PathVariable("tag") String tag) {
        CommonResult commonResult = null;
        Collection<String> policies = null;
        try {
            policies = iPolicyService.getPolicyByTag(tag);
            commonResult = new CommonResult(308, "成功返回政策标题", policies);
        } catch (Exception e) {
            e.printStackTrace();
            commonResult = new CommonResult(303, "服务器异常，获取信息失败");
        }
        return commonResult;
    }

    /**
     * 根据标题获取政策信息
     * @param title
     * @return
     */
    @GetMapping("/policy/getPolicyByTitle/{title}")
    public CommonResult getPolicyByTitle(@PathVariable String title) {
        CommonResult commonResult = null;
        try {
            Policy policy = iPolicyService.getPolicyByTitle(title);
            if (policy == null) {
                commonResult = new CommonResult(304,"查无此政策");
            } else {
                commonResult = new CommonResult(309, "成功返回指定标题政策信息",policy);
            }
        } catch (Exception e) {
            e.printStackTrace();
            commonResult = new CommonResult(303, "服务器异常，获取信息失败");
        }
        return commonResult;
    }

    /**
     * 获取相似政策标题，使用字符串匹配
     * @param message
     * @return
     */
    @GetMapping("/policy/getSimilarTitle/{message}")
    public CommonResult getSimilarTitle(@PathVariable String message){
        CommonResult commonResult = null;
        try {
            Collection<String> titles = iPolicyService.getSimilarTitle(message);
            commonResult = new CommonResult(310, "成功返回相似的政策标题", titles);
        } catch (Exception e) {
            e.printStackTrace();
            commonResult = new CommonResult(303, "服务器异常，获取信息失败");
        }
        return commonResult;
    }
}
