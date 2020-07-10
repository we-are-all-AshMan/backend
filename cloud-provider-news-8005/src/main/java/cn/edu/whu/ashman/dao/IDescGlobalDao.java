package cn.edu.whu.ashman.dao;

import cn.edu.whu.ashman.entities.DescForeign;
import cn.edu.whu.ashman.entities.DescGlobal;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
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
    Collection<DescGlobal> getDescGlobal(String date);

    @Insert("insert into descGlobal values (#{date},#{currentConfirmedCount},#{confirmedCount}," +
            "#{curedCount},#{deadCount},#{currentConfirmedIncr},#{confirmedIncr}," +
            "#{curedIncr},#{deadIncr})")
    int insert(DescGlobal descGlobal);

    @Delete("delete from descGlobal where date = #{date}")
    int delete(String date);
}
