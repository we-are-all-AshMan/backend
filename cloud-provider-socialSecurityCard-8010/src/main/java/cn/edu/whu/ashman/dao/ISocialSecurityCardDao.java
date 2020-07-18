package cn.edu.whu.ashman.dao;

/**
 * @Author LiuWeiFan
 * @create 2020/7/18 10:35
 */

import cn.edu.whu.ashman.entities.SocialSecurityCard;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
create table socialSecurityCards(
 openId char(100) primary key,
 name char(10),
 socialSecurityNumber char(18),
 socialSecurityCardNumber char(18),
 state int
 );*/
@Mapper
@Repository
public interface ISocialSecurityCardDao {
    /**
     * 根据openId查询单个
     * @param openId
     * @return
     */
    @Select("select * from socialSecurityCards where openId=#{openId}")
    SocialSecurityCard getSocialSecurityCardByOpenId(String openId);

    /**
     * 插入
     * @param socialSecurityCard
     * @return
     */
    @Insert("insert socialSecurityCards(openId,name,socialSecurityNumber,socialSecurityCardNumber,state) values(#{openId},#{name},#{socialSecurityNumber},#{socialSecurityCardNumber},#{state})")
    int insertSocialSecurityCard(SocialSecurityCard socialSecurityCard);

    /**
     * 更新
     * @param socialSecurityCard
     * @return
     */
    @Update("update socialSecurityCards set state=#{state},name=#{name},socialSecurityNumber=#{socialSecurityNumber},socialSecurityCardNumber=#{socialSecurityCardNumber} where openId=#{openId}")
    int updateSocialSecurityCard(SocialSecurityCard socialSecurityCard);

    /**
     * 根据state查询
     * @param integer
     * @return
     */
    @Select("select * from socialSecurityCards where state=#{state}")
    Collection<SocialSecurityCard> getSocialSecurityCardsByState(Integer integer);

    /**
     * 查询所有
     * @return
     */
    @Select("select * from socialSecurityCards")
    Collection<SocialSecurityCard> getAllSocialSecurityCards();

    @Delete("delete from socialSecurityCards where openId=#{openId}")
    int delete(String openId);
}
