package cn.edu.whu.ashman.Service;

import cn.edu.whu.ashman.entities.DescGlobal;

import java.util.List;
import java.util.Map;

/**
 * Created by Zhu yuhan
 * Date:2020/7/10 20:19
 **/
public interface IDescGlobalService {
    DescGlobal getDescGlobal(String date);

    int insert(DescGlobal descGlobal);

    int delete(String date);

    String getGlobalCurrentConfirmedCountByDate(String date);

    List<Map<String,String>> getCurrentConfirmedCounts(Integer start, Integer end);

    int update(DescGlobal descGlobal);
}
