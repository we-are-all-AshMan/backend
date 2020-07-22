package cn.edu.whu.ashman.entites;

import cn.hutool.core.date.DateTime;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @Author LiuWeiFan
 * @create 2020/7/21 18:37
 */
public class Appointment {
    private String openId;
    private String affair;
    private Timestamp times;

    public Appointment(){}
    public Appointment(String openId, String affair, Timestamp time) {
        this.openId = openId;
        this.affair = affair;
        this.times = time;
    }

    public Appointment(String openId, String affair) {
        this.openId = openId;
        this.affair = affair;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getAffair() {
        return affair;
    }

    public void setAffair(String affair) {
        this.affair = affair;
    }

    public Timestamp getTimes() {
        return times;
    }

    public void setTimes(Timestamp times) {
        this.times = times;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "openId='" + openId + '\'' +
                ", affair='" + affair + '\'' +
                ", time=" + times +
                '}';
    }
}
