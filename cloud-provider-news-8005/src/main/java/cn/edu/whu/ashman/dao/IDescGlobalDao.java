package cn.edu.whu.ashman.dao;

import cn.edu.whu.ashman.entities.DescForeign;
import cn.edu.whu.ashman.entities.DescGlobal;
import cn.edu.whu.ashman.entities.DescNation;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Created by Zhu yuhan
 * Date:2020/7/10 20:17
 **/
@Repository
@Mapper
public interface IDescGlobalDao {
    @Select("select * from descGlobal where date = #{date}")
    DescGlobal getDescGlobal(String date);

    @Insert("insert into descGlobal values (#{date},#{currentConfirmedCount},#{confirmedCount}," +
            "#{curedCount},#{deadCount},#{currentConfirmedIncr},#{confirmedIncr}," +
            "#{curedIncr},#{deadIncr})")
    int insert(DescGlobal descGlobal);

    @Delete("delete from descGlobal where date = #{date}")
    int delete(String date);

    @Select("select currentConfirmedCount from descGlobal where date = #{date}")
    String getCurrentConfirmedCountByDate(String date);

    @Select("select date,currentConfirmedCount from descGlobal limit #{start},#{end}")
    Collection<DescGlobal> getCurrentConfirmedCounts(@Param("start") Integer start, @Param("end") Integer end);

    @Update("update descGlobal set currentConfirmedCount=#{currentConfirmedCount},confirmedCount=#{confirmedCount}," +
            "curedCount=#{curedCount},deadCount=#{deadCount}," +
            "currentConfirmedIncr=#{currentConfirmedIncr},confirmedIncr=#{confirmedIncr}," +
            "curedIncr=#{curedIncr},deadIncr=#{deadIncr} where date=#{date}")
    int update(DescGlobal descGlobal);
}
