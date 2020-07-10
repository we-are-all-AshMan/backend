package cn.edu.whu.ashman.dao;

import cn.edu.whu.ashman.entities.News;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Created by Zhu yuhan
 * Date:2020/7/10 16:26
 **/
@Repository
@Mapper
public interface INewsDao {
    @Select("select * from news")
    Collection<News> getAllNews();

    @Insert("insert into news values (#{id},#{title},#{summary},#{infoSource},#{sUrl})")
    int insert(News news);

    @Delete("delete from news where id = #{id}")
    int delete(String id);
}
