package cn.edu.whu.ashman.Service.impl;

import cn.edu.whu.ashman.Service.IDescGlobalService;
import cn.edu.whu.ashman.dao.IDescGlobalDao;
import cn.edu.whu.ashman.entities.DescGlobal;
import cn.edu.whu.ashman.entities.DescNation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author Zhuyuhan
 * @date 2020-07-10 20:22
 */
@Service
public class DescGlobalService implements IDescGlobalService {

    @Autowired
    IDescGlobalDao iDescGlobalDao = null;
    @Override
    public DescGlobal getDescGlobal(String date) {
        return iDescGlobalDao.getDescGlobal(date);
    }

    @Override
    public int insert(DescGlobal descGlobal) {
        return iDescGlobalDao.insert(descGlobal);
    }

    @Override
    public int delete(String date) {
        return iDescGlobalDao.delete(date);
    }

    @Override
    public String getGlobalCurrentConfirmedCountByDate(String date) {
        return iDescGlobalDao.getCurrentConfirmedCountByDate(date);
    }
    @Override
    public List<Map<String, String>> getCurrentConfirmedCounts(Integer start, Integer end) {
        List<Map<String,String>> currentConfirmedCountsList = new ArrayList<>();
        Collection<DescGlobal> currentConfirmedCounts = iDescGlobalDao.getCurrentConfirmedCounts(start, end);
        for(DescGlobal descGlobal:currentConfirmedCounts){
            Map<String,String> currentConfirmedCount = new HashMap<>();
            currentConfirmedCount.put(descGlobal.getDate(),descGlobal.getCurrentConfirmedCount());
            currentConfirmedCountsList.add(currentConfirmedCount);
        }
        return currentConfirmedCountsList;
    }
}
