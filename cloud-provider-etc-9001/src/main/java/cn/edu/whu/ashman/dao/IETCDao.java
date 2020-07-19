package cn.edu.whu.ashman.dao;

import cn.edu.whu.ashman.entities.ETC;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Created by Zhu yuhan
 * Date:2020/7/18 9:07
 **/

/**
 * create table ETC(
 * car char(10) primary key,
 * host char(10),
 * consignee char(20),
 * tel char(11),
 * province char(20),
 * city char(20),
 * address TEXT,
 * openId char(10),
 * state int
 * );
 */
@Mapper
@Repository
public interface IETCDao {

    @Select("select * from ETC where openId=#{openId}")
    Collection<ETC> selectByOpenId(String openId);

    @Update("update ETC set host=#{host},consignee=#{consignee},tel=#{tel}," +
            "province=#{province},city=#{city},address=#{address},state=#{state} where car=#{car}")
    int update(ETC etc);

    @Insert("insert into ETC(openId,car,host,consignee,tel,province,city,address,state) " +
            "values(#{openId},#{car},#{host},#{consignee},#{tel},#{province},#{city},#{address},#{state})")
    int insert(ETC etc);

    @Select("select * from ETC")
    Collection<ETC> selectAll();

    @Select("select * from ETC where state=#{state}")
    Collection<ETC> selectByState(Integer state);

    @Update("update ETC set state=#{state} where car=#{car}")
    int updateState(ETC etc);
}
