package cn.edu.whu.ashman.dao;

import cn.edu.whu.ashman.entities.Policy;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
/*
create table policies(
        title char(50),
        tag char(50),
        indexNumber char(30) primary key,
        issuingNumber char(20),
        issuingAgency char(20),
        createdDate date,
        publishDate date,
        contexts text
        );*/
/**
 * @Author LiuWeiFan
 * @create 2020/7/19 10:59
 */
@Repository
@Mapper
public interface IPolicyDao {

    /**
     * 查询所有
     * @return
     */
    @Select("select * from policies order by publishDate desc")
    Collection<Policy> selectAllPolicies();

    /**
     * 分页查询
     * @param curPage
     * @return
     */
    @Select("select * from policies order by publishDate desc limit #{curPage},10")
    Collection<Policy> selectPoliciesByPage(int curPage);

    /**
     * 插入新闻
     * @param policy
     * @return
     */
    @Insert("insert policies(title,tag,indexNumber,issuingNumber,issuingAgency,createdDate,publishDate,contexts) " +
            "values(#{title},#{tag},#{indexNumber},#{issuingNumber},#{issuingAgency},#{createdDate},#{publishDate},#{contexts})")
    int insertPolicy(Policy policy);

    /**
     * 获取所有政策标题
     * @return
     */
    @Select("select title from policies order by publishDate desc")
    List<String> getAllTitleOfPolicy();

    /**
     * 获取指定标题政策
     * @param title
     * @return
     */
    @Select("select * from policies where title=#{title} order by publishDate desc")
    Policy getPolicyByTitle(String title);

    @Select("select title from policies where locate(#{title},title)>0 order by publishDate desc")
    Collection<String> getSimilarTitle(String title);

    /**
     * 获取包含指定标签的政策
     * @return
     */
    @Select("select title from policies where locate(#{tag},tag)>0 order by publishDate desc")
    List<String> getPolicyByTag(String tag);
}
