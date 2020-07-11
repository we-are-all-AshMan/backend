package cn.edu.whu.ashman.service.impl;

import cn.edu.whu.ashman.dao.IUserDao;
import cn.edu.whu.ashman.entities.User;
import cn.edu.whu.ashman.service.IUserService;
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
    public User selectUserByNameService(String userName) {
        return userDao.selectUserByName(userName);
    }

    @Override
    public void insertUserService(User user) {
        userDao.insertUser(user);
    }

    @Override
    public void updateUserService(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void deleteUserService(String userName) {
        userDao.deleteUser(userName);
    }

    @Override
    public User selectUserByTel(String tel) {
        return userDao.selectUserByTel(tel);
    }
}
