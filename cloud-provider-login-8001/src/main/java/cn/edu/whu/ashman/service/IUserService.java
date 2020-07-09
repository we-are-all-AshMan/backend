package cn.edu.whu.ashman.service;

import cn.edu.whu.ashman.entities.User;
import org.springframework.stereotype.Service;

/**
 * Created by Zhu yuhan
 * Date:2020/7/9 15:40
 **/
@Service
public interface IUserService {

    User selectUserByNameService(String userName);

    void insertUserService(User user);

    void updateUserService(User user);

    void deleteUserService(String userName);
}
