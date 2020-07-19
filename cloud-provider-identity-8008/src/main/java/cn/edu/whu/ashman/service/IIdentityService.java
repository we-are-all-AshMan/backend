package cn.edu.whu.ashman.service;

import cn.edu.whu.ashman.entities.Identity;

import java.util.Collection;

/**
 * Created by Zhu yuhan
 * Date:2020/7/17 15:59
 **/
public interface IIdentityService {

    Identity selectByOpenId(String openId);

    int insert(Identity identity);

    int update(Identity identity);

    Collection<Identity> selectByState(Integer state);

    Collection<Identity> selectAll();
}
