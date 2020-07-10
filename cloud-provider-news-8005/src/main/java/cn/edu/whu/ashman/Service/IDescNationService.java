package cn.edu.whu.ashman.Service;

import cn.edu.whu.ashman.dao.IDescNationDao;
import cn.edu.whu.ashman.entities.DescNation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by Zhu yuhan
 * Date:2020/7/10 20:09
 **/
public interface IDescNationService {

    Collection<DescNation> getDescNation(String date);

    int insert(DescNation descNation);

    int delete(String date);
}
