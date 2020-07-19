package cn.edu.whu.ashman.service.impl;

import cn.edu.whu.ashman.service.IUserService;
import cn.edu.whu.ashman.dao.IUserDao;
import cn.edu.whu.ashman.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Zhuyuhan
 * @date 2020-07-09 15:40
 */
@Service
public class UserService implements IUserService {
    @Autowired
    IUserDao userDao = null;

    @Override
    public User selectUserOpenIdService(String openId) {
        return userDao.selectUserByOpenId(openId);
    }

    @Override
    public int insertUserService(User user) {
        return userDao.insertUser(user);
    }

    @Override
    public int updateUserService(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public int deleteUserService(String openId) {
        return userDao.deleteUser(openId);
    }

    @Override
    public User selectUserByTel(String tel) {
        return userDao.selectUserByTel(tel);
    }
}
