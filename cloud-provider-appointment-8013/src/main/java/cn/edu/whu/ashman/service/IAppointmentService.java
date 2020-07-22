package cn.edu.whu.ashman.service;

import cn.edu.whu.ashman.entites.Appointment;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @Author LiuWeiFan
 * @create 2020/7/21 18:50
 */
public interface IAppointmentService {

    Collection<Appointment> getAllAppointmentByOpenId(String openId);

    Collection<Appointment> getAllAppointmentByAffair(String affair);

    int addAppointment(Appointment appointment);

    int updateAppointmentTime(Appointment appointment);

    int deleteAppointment(Appointment appointment);
}
