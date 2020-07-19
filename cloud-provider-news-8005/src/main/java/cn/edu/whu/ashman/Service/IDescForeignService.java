package cn.edu.whu.ashman.Service;

import cn.edu.whu.ashman.entities.DescForeign;

/**
 * Created by Zhu yuhan
 * Date:2020/7/10 20:14
 **/
public interface IDescForeignService {

    DescForeign getDescForeign(String date);

    int insert(DescForeign descForeign);

    int delete(String date);

    String getForeignCurrentConfirmedCountByDate(String date);

    int update(DescForeign descForeign);
}
