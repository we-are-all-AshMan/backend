package cn.edu.whu.ashman.controller;

import cn.edu.whu.ashman.entities.CommonResult;
import cn.edu.whu.ashman.entities.Meeting;
import cn.edu.whu.ashman.entities.Policy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author LiuWeiFan
 * @create 2020/7/22 9:51
 */
@RestController
@RefreshScope
public class ConsumerMeetingController {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${provider.url}")
    private String serverURL;

    @GetMapping("/consumer/meeting/getMeetingByOpenId/{openId}")
    public CommonResult getMeetingByOpenId(@PathVariable("openId") String openId){
        return restTemplate.getForObject(serverURL+"/meeting/getMeetingByOpenId/"+openId,CommonResult.class);
    }

    @GetMapping("/consumer/meeting/getMeetingByOpenIdAndTitle")
    public CommonResult getMeetingByOpenIdAndTitle(Meeting meeting){
        return restTemplate.postForObject(serverURL+"/meeting/getMeetingByOpenIdAndTitle",meeting,CommonResult.class);
    }

    @GetMapping("/consumer/meeting/addMeeting")
    public CommonResult addMeeting(Meeting meeting){
        return restTemplate.postForObject(serverURL+"/meeting/addMeeting",meeting,CommonResult.class);
    }

    @GetMapping("/consumer/meeting/deleteMeeting")
    public CommonResult deleteMeeting(Meeting meeting){
        return restTemplate.postForObject(serverURL+"/meeting/deleteMeeting",meeting,CommonResult.class);
    }
}
