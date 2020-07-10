package cn.edu.whu.ashman.Service;

import cn.edu.whu.ashman.entities.DescForeign;
import cn.edu.whu.ashman.entities.DescNation;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by Zhu yuhan
 * Date:2020/7/10 20:14
 **/
public interface IDescForeignService {

    Collection<DescForeign> getDescForeign(String date);

    int insert(DescForeign descForeign);

    int delete(String date);
}
