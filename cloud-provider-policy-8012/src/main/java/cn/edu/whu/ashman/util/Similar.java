package cn.edu.whu.ashman.util;

import cn.edu.whu.ashman.dao.IPolicyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author LiuWeiFan
 * @create 2020/7/19 15:22
 */
@Component
public class Similar {
    @Autowired
    IPolicyDao iPolicyDao = null;

    List<String> policies = new ArrayList<String>();//所有政策的list
    List<String> resultList = new ArrayList<String>();

    /**
     * 根据字符串匹配获取，最外层的方法，用起来还可以。目前正在使用的方法
     *
     * @param message
     * @return
     */
    public List<String> getSimilarTitle(String message) {
        try {
            policies = iPolicyDao.getAllTitleOfPolicy();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        resultList.clear();
        for (String s : policies) {
            if (s.indexOf(message) >= 0) {
                resultList.add(s);
            }
        }
        System.err.println(resultList);
        System.err.println(policies);
        return resultList;
    }
}
