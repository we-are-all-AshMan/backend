package cn.edu.whu.ashman.service;

import cn.edu.whu.ashman.entites.Meeting;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.Collection;

/**
 * @Author LiuWeiFan
 * @create 2020/7/22 9:37
 */
public interface IMeetingService {

    Collection<Meeting> getMeetingByOpenId(String openId);

    Collection<Meeting> getMeetingByOpenIdAndTitle(Meeting meeting);

    int addMeeting(Meeting meeting);

    int deleteMeeting(Meeting meeting);
}
