package cn.edu.whu.ashman.service.impl;

import cn.edu.whu.ashman.dao.IETCDao;
import cn.edu.whu.ashman.entities.ETC;
import cn.edu.whu.ashman.service.IETCService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @author Zhuyuhan
 * @date 2020-07-18 9:08
 */
@Service
public class ETCService implements IETCService {
    @Autowired
    IETCDao ietcDao;

    @Override
    public Collection<ETC> selectByOpenId(String openId) {
        return ietcDao.selectByOpenId(openId);
    }

    @Override
    public int update(ETC etc) {
        return ietcDao.update(etc);
    }

    @Override
    public int insert(ETC etc) {
        return ietcDao.insert(etc);
    }

    @Override
    public Collection<ETC> selectAll() {
        return ietcDao.selectAll();
    }

    @Override
    public Collection<ETC> selectByState(Integer state) {
        return ietcDao.selectByState(state);
    }

    @Override
    public int updateState(ETC etc) {
        return ietcDao.updateState(etc);
    }
}
