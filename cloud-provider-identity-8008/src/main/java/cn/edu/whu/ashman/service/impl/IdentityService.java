package cn.edu.whu.ashman.service.impl;

import cn.edu.whu.ashman.dao.IIdentityDao;
import cn.edu.whu.ashman.entities.Identity;
import cn.edu.whu.ashman.service.IIdentityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @author Zhuyuhan
 * @date 2020-07-17 16:00
 */
@Service
public class IdentityService implements IIdentityService {
    @Autowired
    IIdentityDao iIdentityDao;
    @Override
    public Identity selectByOpenId(String openId) {
        return iIdentityDao.selectByOpenId(openId);
    }

    @Override
    public int insert(Identity identity) {
        return iIdentityDao.insert(identity);
    }

    @Override
    public int update(Identity identity) {
        return iIdentityDao.update(identity);
    }

    @Override
    public Collection<Identity> selectByState(Integer state) {
        return iIdentityDao.selectByState(state);
    }

    @Override
    public Collection<Identity> selectAll() {
        return iIdentityDao.selectAll();
    }

    @Override
    public int updateState(Identity identity) {
        return iIdentityDao.updateState(identity);
    }
}
