package cn.edu.whu.ashman.controller;

import cn.edu.whu.ashman.entities.Appointment;
import cn.edu.whu.ashman.entities.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author LiuWeiFan
 * @create 2020/7/22 10:41
 */
@RestController
@RefreshScope
public class ConsumerAppointmentController {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${provider.url}")
    private String SERVER_URL;

    @GetMapping("/consumer/appointment/getAllAppointmentByOpenId/{openId}")
    public CommonResult getAllAppointmentByOpenId(@PathVariable("openId") String openId) {
        return restTemplate.getForObject(SERVER_URL + "/appointment/getAllAppointmentByOpenId/" + openId, CommonResult.class);
    }

    @GetMapping("/consumer/appointment/getAllAppointmentByAffair/{affair}")
    public CommonResult getAllAppointmentByAffair(@PathVariable("affair") String affair) {
        return restTemplate.getForObject(SERVER_URL + "/appointment/getAllAppointmentByAffair/" + affair, CommonResult.class);
    }

    @GetMapping("/consumer/appointment/addAppointment")
    public CommonResult addAppointment(Appointment appointment) {
        return restTemplate.postForObject(SERVER_URL + "/appointment/addAppointment", appointment, CommonResult.class);
    }

    @GetMapping("/consumer/appointment/updateAppointmentTime")
    public CommonResult updateAppointmentTime(Appointment appointment) {
        return restTemplate.postForObject(SERVER_URL + "/appointment/updateAppointmentTime", appointment, CommonResult.class);
    }

    @GetMapping("/consumer/appointment/deleteAppointment")
    public CommonResult deleteAppointment(Appointment appointment) {
        return restTemplate.postForObject(SERVER_URL + "/appointment/deleteAppointmentTime", appointment, CommonResult.class);
    }
}
