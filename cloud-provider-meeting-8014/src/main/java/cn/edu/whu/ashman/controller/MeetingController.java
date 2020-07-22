package cn.edu.whu.ashman.controller;

import cn.edu.whu.ashman.entites.Meeting;
import cn.edu.whu.ashman.entities.CommonResult;
import cn.edu.whu.ashman.entities.Policy;
import cn.edu.whu.ashman.service.IMeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @Author LiuWeiFan
 * @create 2020/7/22 9:39
 */
@RestController
public class MeetingController {

    @Autowired
    IMeetingService iMeetingService = null;

    /**
     * 获取该用户所有会议记录
     * @param openId
     * @return
     */
    @GetMapping("/meeting/getMeetingByOpenId/{openId}")
    public CommonResult getMeetingByOpenId(@PathVariable("openId") String openId) {
        CommonResult commonResult = null;
        try {
            Collection<Meeting> meetings = iMeetingService.getMeetingByOpenId(openId);
            commonResult = new CommonResult(305, "成功返回该用户会议记录", meetings);
        } catch (Exception e) {
            e.printStackTrace();
            commonResult = new CommonResult(303, "服务器异常，获取信息失败");
        }
        return commonResult;
    }

    /**
     * 获取该用户，该标题会议记录，openId与titel均为路径参数
     * @param
     * @param
     * @return
     */
    @PostMapping("/meeting/getMeetingByOpenIdAndTitle")
    public CommonResult getMeetingByOpenIdAndTitle(@RequestBody Meeting meeting) {
        CommonResult commonResult = null;
        try {
            Collection<Meeting> meetings = iMeetingService.getMeetingByOpenIdAndTitle(meeting);
            commonResult = new CommonResult(305, "成功返回会议记录", meetings);
        } catch (Exception e) {
            e.printStackTrace();
            commonResult = new CommonResult(303, "服务器异常，获取信息失败");
        }
        return commonResult;
    }

    /**
     * 添加会议
     * @param meeting
     * @return
     */
    @PostMapping("/meeting/addMeeting")
    public CommonResult addMeeting(@RequestBody Meeting meeting) {
        CommonResult commonResult = null;
        try {
            int i = iMeetingService.addMeeting(meeting);
            if (i < 1) {
                commonResult = new CommonResult(304, "添加失败");
            } else {
                commonResult = new CommonResult(305, "添加成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
            commonResult = new CommonResult(303, "服务器异常");
        }
        return commonResult;
    }

    /**
     * 删除会议
     * @param meeting
     * @return
     */
    @PostMapping("/meeting/deleteMeeting")
    public CommonResult deleteMeeting(@RequestBody Meeting meeting){
        CommonResult commonResult = null;
        try {
            int i = iMeetingService.deleteMeeting(meeting);
            if (i < 1) {
                commonResult = new CommonResult(304, "删除失败");
            } else {
                commonResult = new CommonResult(305, "删除成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
            commonResult = new CommonResult(303, "服务器异常");
        }
        return commonResult;
    }
}
