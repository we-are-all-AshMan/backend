package cn.edu.whu.ashman.Service.impl;

import cn.edu.whu.ashman.Service.IDescForeignService;
import cn.edu.whu.ashman.dao.IDescForeignDao;
import cn.edu.whu.ashman.entities.DescForeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @author Zhuyuhan
 * @date 2020-07-10 20:15
 */
@Service
public class DescForeignService implements IDescForeignService {

    @Autowired
    IDescForeignDao iDescForeignDao = null;
    @Override
    public Collection<DescForeign> getDescForeign(String date) {
        return iDescForeignDao.getDescForeign(date);
    }

    @Override
    public int insert(DescForeign descForeign) {
        return iDescForeignDao.insert(descForeign);
    }

    @Override
    public int delete(String date) {
        return iDescForeignDao.delete(date);
    }
}