package cn.edu.whu.ashman.controller;

import cn.edu.whu.ashman.entites.Appointment;
import cn.edu.whu.ashman.entities.CommonResult;
import cn.edu.whu.ashman.service.IAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @Author LiuWeiFan
 * @create 2020/7/21 18:55
 */
@RestController
public class AppointmentController {

    @Autowired
    IAppointmentService iAppointmentService = null;

    /**
     *
     * 返回该用户全部预约信息，时间格式为2020-01-01T08:30:00.000+0000，时间戳
     * @param openId
     * @return
     */
    @GetMapping("/appointment/getAllAppointmentByOpenId/{openId}")
    public CommonResult getAllAppointmentByOpenId(@PathVariable String openId){
        CommonResult commonResult = null;
        try{
            Collection<Appointment> appointments = iAppointmentService.getAllAppointmentByOpenId(openId);
            if(appointments == null){
                commonResult = new CommonResult(304,"该用户无预约");
            }
            else {
                commonResult = new CommonResult(305,"成功返回该用户预约信息",appointments);
            }
        }catch (Exception e){
            e.printStackTrace();
            commonResult = new CommonResult(303,"服务器异常");
        }
        return commonResult;
    }

    /**
     * 返沪该事务所有预约，时间格式为2020-01-01T08:30:00.000+0000，时间戳
     * @param affair
     * @return
     */
    @GetMapping("/appointment/getAllAppointmentByAffair/{affair}")
    public CommonResult getAllAppointmentByAffair(@PathVariable String affair){
        CommonResult commonResult = null;
        try{
            Collection<Appointment> appointments = iAppointmentService.getAllAppointmentByAffair(affair);
            if(appointments == null){
                commonResult = new CommonResult(304,"该事务无预约");
            }
            else {
                commonResult = new CommonResult(305,"成功返回该事务预约信息",appointments);
            }
        }catch (Exception e){
            e.printStackTrace();
            commonResult = new CommonResult(303,"服务器异常");
        }
        return commonResult;
    }

    /**
     * 添加事务，时间格式为yy-mm-dd hh:mm:ss
     * @param appointment
     * @return
     */
    @PostMapping("/appointment/addAppointment")
    public CommonResult addAppointment(@RequestBody Appointment appointment){
        CommonResult commonResult = null;
        try{
            int i = iAppointmentService.addAppointment(appointment);
            if(i < 1){
                commonResult = new CommonResult(304,"添加失败");
            }
            else {
                commonResult = new CommonResult(305,"添加成功");
            }
        }catch (Exception e){
            e.printStackTrace();
            commonResult = new CommonResult(303,"服务器异常");
        }
        return commonResult;
    }

    /**
     * 修改预约时间，时间格式为yy-mm-dd hh:mm:ss
     * @param appointment
     * @return
     */
    @PostMapping("/appointment/updateAppointmentTime")
    public CommonResult updateAppointmentTime(@RequestBody Appointment appointment){
        CommonResult commonResult = null;
        try{
            int i = iAppointmentService.updateAppointmentTime(appointment);
            if(i < 1){
                commonResult = new CommonResult(304,"修改失败");
            }
            else {
                commonResult = new CommonResult(305,"修改成功");
            }
        }catch (Exception e){
            e.printStackTrace();
            commonResult = new CommonResult(303,"服务器异常");
        }
        return commonResult;
    }

    /**
     * 删除预约
     * @param appointment
     * @return
     */
    @PostMapping("/appointment/deleteAppointment")
    public CommonResult deleteAppointment(@RequestBody Appointment appointment){
        CommonResult commonResult = null;
        try{
            int i = iAppointmentService.deleteAppointment(appointment);
            if(i < 1){
                commonResult = new CommonResult(304,"删除失败");
            }
            else {
                commonResult = new CommonResult(305,"删除成功");
            }
        }catch (Exception e){
            e.printStackTrace();
            commonResult = new CommonResult(303,"服务器异常");
        }
        return commonResult;
    }
}
