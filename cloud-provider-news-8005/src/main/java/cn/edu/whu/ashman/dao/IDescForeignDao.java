package cn.edu.whu.ashman.dao;

import cn.edu.whu.ashman.entities.DescForeign;
import cn.edu.whu.ashman.entities.DescNation;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Created by Zhu yuhan
 * Date:2020/7/10 20:13
 **/
@Repository
@Mapper
public interface IDescForeignDao {
    @Select("select * from descForeign where date = #{date}")
    DescForeign getDescForeign(String date);

    @Insert("insert into descForeign values (#{date},#{currentConfirmedCount},#{confirmedCount},#{suspectedCount}," +
            "#{curedCount},#{deadCount},#{suspectedIncr},#{currentConfirmedIncr},#{confirmedIncr}," +
            "#{curedIncr},#{deadIncr})")
    int insert(DescForeign descForeign);

    @Delete("delete from descForeign where date = #{date}")
    int delete(String date);

    @Select("select currentConfirmedCount from descForeign where date = #{date}")
    String getCurrentConfirmedCountByDate(String date);

    @Update("update descForeign set currentConfirmedCount=#{currentConfirmedCount},confirmedCount=#{confirmedCount}," +
            "suspectedCount=#{suspectedCount},curedCount=#{curedCount},deadCount=#{deadCount}," +
            "suspectedIncr=#{suspectedIncr},currentConfirmedIncr=#{currentConfirmedIncr},confirmedIncr=#{confirmedIncr}," +
            "curedIncr=#{curedIncr},deadIncr=#{deadIncr} where date=#{date}")
    int update(DescForeign descForeign);
}
