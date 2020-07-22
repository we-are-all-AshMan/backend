package cn.edu.whu.ashman.dao;

import cn.edu.whu.ashman.entites.Meeting;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
create table meetings(
 openId char(100) primary key,
 title char(60),
 contexts text,
 times datetime
 );
*/
/**
 * @Author LiuWeiFan
 * @create 2020/7/22 9:26
 */
@Repository
@Mapper
public interface IMeetingDao {

    @Select("select * from meetings where openId=#{openId}")
    Collection<Meeting> getMeetingByOpenId(String openId);

    @Select("select * from meetings where openId=#{openId} and title=#{title}")
    Collection<Meeting> getMeetingByOpenIdAndTitle(Meeting meeting);

    @Insert("insert meetings(openId,title,contexts,times) values(#{openId},#{title},#{contexts},#{times})")
    int addMeeting(Meeting meeting);

    @Delete("delete from meetings where openId=#{openId} and title=#{title}")
    int deleteMeeting(Meeting meeting);

}
