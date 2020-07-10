package cn.edu.whu.ashman.Service.impl;

import cn.edu.whu.ashman.Service.IDescNationService;
import cn.edu.whu.ashman.dao.IDescNationDao;
import cn.edu.whu.ashman.entities.DescNation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @author Zhuyuhan
 * @date 2020-07-10 20:12
 */
@Service
public class DescNationService implements IDescNationService {
    @Autowired
    IDescNationDao descNationDao = null;
    @Override
    public Collection<DescNation> getDescNation(String date) {
        return descNationDao.getDescNation(date);
    }

    @Override
    public int insert(DescNation descNation) {
        return descNationDao.insert(descNation);
    }

    @Override
    public int delete(String date) {
        return descNationDao.delete(date);
    }
}
