package cn.edu.whu.ashman.dao;

import cn.edu.whu.ashman.entites.Appointment;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 create table appointments(
 openId char(100) primary key,
 affair char(20),
 times datetime
 )




 */

/**
 * @Author LiuWeiFan
 * @create 2020/7/21 18:41
 */
@Repository
@Mapper
public interface IAppointmentDao {

    @Select("select * from appointments where openId=#{openId} order by times")
    Collection<Appointment> getAllAppointmentByOpenId(String openId);

    @Select("select * from appointments where affair=#{affair} order by times")
    Collection<Appointment> getAllAppointmentByAffair(String affair);

    @Insert("insert appointments(openId,affair,times) values(#{openId},#{affair},#{times})")
    int addAppointment(Appointment appointment);

    @Update("update appointments set times=#{times} where openId=#{openId} and affair=#{affair}")
    int updateAppointmentTime(Appointment appointment);

    @Delete("delete from appointments where openId=#{openId} and affair=#{affair}")
    int deleteAppointment(Appointment appointment);
}
