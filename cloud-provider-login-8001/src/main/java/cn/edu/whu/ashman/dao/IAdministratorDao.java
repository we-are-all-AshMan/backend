package cn.edu.whu.ashman.dao;


import cn.edu.whu.ashman.entities.Administrator;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/**
 * @Author Liu WeiFan
 * @create 2020年7月11日 20：56
 */
/**
 * 增删改查管理者持久层接口
 */
@Repository
@Mapper
public interface IAdministratorDao {

    /**
     * 根据userName查询
     * @param userName
     * @return
     */
    @Select("select * from administrators where username=#{userName}")
    Administrator selectAdministratorByUserName(String userName);

    /**
     * 添加administrator
     * @param administrator
     */
    @Insert("insert into administrators(userName,password,tel) values(#{userName},#{password},#{tel})")
    void insertAdministrator(Administrator administrator);

    /**
     * 更新administrator
     * @param administrator
     */
    @Update("update admonistrators set password=#{password},tel=#{tel} where userName=#{userName}")
    void updateAdministrator(Administrator administrator);

    /**
     * 删除administrator
     * @param administrator
     */
    @Delete("delete from administrator where userName=#{userName}")
    void deleteAdministrator(String userName);
}
