package cn.edu.whu.ashman.Service;

import cn.edu.whu.ashman.dao.IDescNationDao;
import cn.edu.whu.ashman.entities.DescNation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by Zhu yuhan
 * Date:2020/7/10 20:09
 **/
public interface IDescNationService {

    DescNation getDescNation(String date);

    int insert(DescNation descNation);

    int delete(String date);

    String getNationCurrentConfirmedCountByDate(String date);

    List<Map<String,String>> getCurrentConfirmedCounts(Integer start, Integer end);
}
