package cn.edu.whu.ashman.dao;

import cn.edu.whu.ashman.entities.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/**
 * @author Liu weifan
 **/

/**
 * 增删改查用户持久层接口
 */
@Repository
@Mapper
public interface IUserDao {
    /**
     * create table users(
     * id int primary key auto_increment,
     * username char(20),
     * openId char(100),
     * tel char(11),
     * imageUrl TEXT
     * );
     */

    /**
     * 根据openId查询User
     * @param openId
     * @return
     */
    @Select("select * from users where openId=#{openId}")
    User selectUserByOpenId(String openId);

    @Select("select * from users where tel=#{tel}")
    User selectUserByTel(String tel);

    /**
     * 插入User
     */
    @Insert("insert into users(userName,openId,tel,imageUrl) values (#{userName},#{openId},#{tel},#{imageUrl})")
    int insertUser(User user);

    /**
     * 更新User
     * @param user
     */
    @Update("update users set userName=#{userName},tel=#{tel},imageUrl=#{imageUrl} where openId=#{openId}")
    int updateUser(User user);

    /**
     * 根据openId删除user
     * @param openId
     */
    @Delete("delete from users where openId = #{openId}")
    int deleteUser(String openId);
}

