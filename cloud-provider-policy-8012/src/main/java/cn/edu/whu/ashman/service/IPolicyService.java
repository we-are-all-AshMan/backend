package cn.edu.whu.ashman.service;

import cn.edu.whu.ashman.entities.Policy;

import java.util.Collection;
import java.util.List;

/**
 * @Author LiuWeiFan
 * @create 2020/7/19 11:23
 */
public interface IPolicyService {

    Collection<Policy> selectAllPolicies();

    Collection<Policy> selectPoliciesByPage(int curPage);

    int insertPolicy(Policy policy);

    List<String> getAllTitleOfPolicy();

    Policy getPolicyByTitle(String title);

    List<String> getPolicyByTag(String tag);

    List<String> getSimilarTitle(String message);
}
