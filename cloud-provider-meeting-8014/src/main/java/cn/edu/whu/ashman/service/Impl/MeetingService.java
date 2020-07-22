package cn.edu.whu.ashman.service.Impl;

import cn.edu.whu.ashman.dao.IMeetingDao;
import cn.edu.whu.ashman.entites.Meeting;
import cn.edu.whu.ashman.service.IMeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @Author LiuWeiFan
 * @create 2020/7/22 9:37
 */
@Service
public class MeetingService implements IMeetingService {

    @Autowired
    IMeetingDao iMeetingDao = null;

    @Override
    public Collection<Meeting> getMeetingByOpenId(String openId) {
        return iMeetingDao.getMeetingByOpenId(openId);
    }

    @Override
    public Collection<Meeting> getMeetingByOpenIdAndTitle(Meeting meeting) {
        return iMeetingDao.getMeetingByOpenIdAndTitle(meeting);
    }

    @Override
    public int addMeeting(Meeting meeting) {
        return iMeetingDao.addMeeting(meeting);
    }

    @Override
    public int deleteMeeting(Meeting meeting) {
        return iMeetingDao.deleteMeeting(meeting);
    }
}
