package cn.edu.whu.ashman.service;

import cn.edu.whu.ashman.entities.ETC;

import java.util.Collection;

/**
 * Created by Zhu yuhan
 * Date:2020/7/18 9:07
 **/
public interface IETCService {

    Collection<ETC> selectByOpenId(String openId);

    int update(ETC etc);

    int insert(ETC etc);

    Collection<ETC> selectAll();

    Collection<ETC> selectByState(Integer state);

    int updateState(ETC etc);
}
