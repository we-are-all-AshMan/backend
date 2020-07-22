package cn.edu.whu.ashman.service;


import cn.edu.whu.ashman.entities.User;

/**
 * Created by Zhu yuhan
 * Date:2020/7/9 15:40
 **/
public interface IUserService {

    User selectUserOpenIdService(String openId);

    int insertUserService(User user);

    int updateUserService(User user);

    int deleteUserService(String openId);

    User selectUserByTel(String tel);
}
