package cn.edu.whu.ashman.dao;

import cn.edu.whu.ashman.entities.Identity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Created by Zhu yuhan
 * Date:2020/7/17 15:59
 **/

/**
 * create table identities(
 * openId char(100) primary key,
 * name char(10),
 * gender char(2),
 * place char(100),
 * idNum char(18),
 * imageUrl TEXT
 * state int
 * );
 */
@Mapper
@Repository
public interface IIdentityDao {

      @Select("select * from identities where openId=#{openId}")
      Identity selectByOpenId(String openId);

      @Insert("insert into identities(openId,name,gender,place,idNum,imageUrl,state) values(#{openId},#{name},#{gender},#{place},#{idNum},#{imageUrl},#{state})")
      int insert(Identity identity);

      @Update("update identities set state=#{state},name=#{name},gender=#{gender},place=#{place},idNum=#{idNum},imageUrl=#{imageUrl} where openId=#{openId}")
      int update(Identity identity);

      @Select("select * from identities where state=#{state}")
      Collection<Identity> selectByState(Integer state);

      @Select("select * from identities")
      Collection<Identity> selectAll();

      @Update("update identities set state=#{state} where openId=#{openId}")
      int updateState(Identity identity);
}
