package cn.edu.whu.ashman.Service.impl;

import cn.edu.whu.ashman.entities.DescNation;
import cn.edu.whu.ashman.Service.IDescNationService;
import cn.edu.whu.ashman.dao.IDescNationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author Zhuyuhan
 * @date 2020-07-10 20:12
 */
@Service
public class DescNationService implements IDescNationService {
    @Autowired
    IDescNationDao descNationDao = null;
    @Override
    public DescNation getDescNation(String date) {
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

    @Override
    public String getNationCurrentConfirmedCountByDate(String date) {
        return descNationDao.getCurrentConfirmedCountByDate(date);
    }

    @Override
    public List<Map<String, String>> getCurrentConfirmedCounts(Integer start, Integer end) {
        List<Map<String,String>> currentConfirmedCountsList = new ArrayList<>();
        Collection<DescNation> currentConfirmedCounts = descNationDao.getCurrentConfirmedCounts(start, end);
        for(DescNation descNation:currentConfirmedCounts){
            Map<String,String> currentConfirmedCount = new HashMap<>();
            currentConfirmedCount.put(descNation.getDate(),descNation.getCurrentConfirmedCount());
            currentConfirmedCountsList.add(currentConfirmedCount);
        }
        return currentConfirmedCountsList;
    }

    @Override
    public int update(DescNation descNation) {
        return descNationDao.update(descNation);
    }
}
