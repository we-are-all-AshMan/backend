package cn.edu.whu.ashman.Service;

import cn.edu.whu.ashman.entities.DescGlobal;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by Zhu yuhan
 * Date:2020/7/10 20:19
 **/
public interface IDescGlobalService {
    Collection<DescGlobal> getDescGlobal(String date);

    int insert(DescGlobal descGlobal);

    int delete(String date);
}
