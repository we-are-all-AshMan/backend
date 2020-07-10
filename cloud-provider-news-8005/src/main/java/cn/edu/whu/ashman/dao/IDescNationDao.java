package cn.edu.whu.ashman.dao;

import cn.edu.whu.ashman.entities.DescNation;
import cn.edu.whu.ashman.entities.News;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Created by Zhu yuhan
 * Date:2020/7/10 20:03
 **/
/**
 *  "desc": {
 *         "id": 1,
 *         "createTime": 1579537899000,
 *         "modifyTime": 1594368642000,
 *         "summary": "",
 *         "deleted": false,
 *         "countRemark": "",
 *         "currentConfirmedCount": 531, //现存确诊人数
 *         "confirmedCount": 85447,  //累计确诊人数
 *         "suspectedCount": 1962, //现存疑似人数
 *         "curedCount": 80268, //累计治愈人数
 *         "deadCount": 4648,//累计死亡人数
 *         "seriousCount": 113,//现存重症人数
 *         "suspectedIncr": 4,//新增疑似人数
 *         "currentConfirmedIncr": 20,//相比昨天现存确诊人数变化
 *         "confirmedIncr": 48,//相比昨天累计确诊人数
 *         "curedIncr": 28,//相比昨天新增治愈人数
 *         "deadIncr": 0,//相比昨天新增死亡人数
 *         "seriousIncr": 1,//相比昨天现存重症人数
 */
@Repository
@Mapper
public interface IDescNationDao {
    @Select("select * from descNation where date = #{date}")
    Collection<DescNation> getDescNation(String date);

    @Insert("insert into descNation values (#{date},#{currentConfirmedCount},#{confirmedCount},#{suspectedCount}," +
            "#{curedCount},#{deadCount},#{seriousCount},#{suspectedIncr},#{currentConfirmedIncr},#{confirmedIncr}," +
            "#{curedIncr},#{deadIncr},#{seriousIncr})")
    int insert(DescNation descNation);

    @Delete("delete from descNation where date = #{date}")
    int delete(String date);
}
