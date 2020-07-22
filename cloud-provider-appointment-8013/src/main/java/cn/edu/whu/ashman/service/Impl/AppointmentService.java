package cn.edu.whu.ashman.service.Impl;

import cn.edu.whu.ashman.dao.IAppointmentDao;
import cn.edu.whu.ashman.entites.Appointment;
import cn.edu.whu.ashman.service.IAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @Author LiuWeiFan
 * @create 2020/7/21 18:51
 */
@Service
public class AppointmentService implements IAppointmentService {

    @Autowired
    IAppointmentDao iAppointmentDao = null;

    @Override
    public Collection<Appointment> getAllAppointmentByOpenId(String openId) {
        return iAppointmentDao.getAllAppointmentByOpenId(openId);
    }

    @Override
    public Collection<Appointment> getAllAppointmentByAffair(String affair) {
        return iAppointmentDao.getAllAppointmentByAffair(affair);
    }

    @Override
    public int addAppointment(Appointment appointment) {
        return iAppointmentDao.addAppointment(appointment);
    }

    @Override
    public int updateAppointmentTime(Appointment appointment) {
        return iAppointmentDao.updateAppointmentTime(appointment);
    }

    @Override
    public int deleteAppointment(Appointment appointment) {
        return iAppointmentDao.deleteAppointment(appointment);
    }
}
