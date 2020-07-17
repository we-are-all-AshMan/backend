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
     * 根据用户名查询User
     * @param userName
     * @return
     */
    @Select("select * from users where userName=#{userName}")
    User selectUserByName(String userName);

    @Select("select * from users where tel=#{tel}")
    User selectUserByTel(String tel);

    /**
     * 插入User
     */
    @Insert("insert into users values (#{userName},#{identity},#{tel},#{birth},#{place},#{url})")
    void insertUser(User user);

    /**
     * 更新User
     * @param user
     */
    @Update("update users set userName=#{userName},identity=#{identity},birth=#{birth},place=#{place},url=#{url} where tel=#{tel}")
    void updateUser(User user);

    /**
     * 根据userName来删除User
     * @param userName
     */
    @Delete("delete from users where username = #{userName}")
    void deleteUser(String userName);
}

