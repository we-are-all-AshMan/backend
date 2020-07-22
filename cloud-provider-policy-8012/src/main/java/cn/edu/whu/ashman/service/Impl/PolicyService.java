package cn.edu.whu.ashman.service.Impl;

import cn.edu.whu.ashman.entities.Policy;
import cn.edu.whu.ashman.dao.IPolicyDao;
import cn.edu.whu.ashman.service.IPolicyService;
import cn.edu.whu.ashman.util.Similar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * @Author LiuWeiFan
 * @create 2020/7/19 11:24
 */
@Service
public class PolicyService implements IPolicyService {

    @Autowired
    IPolicyDao iPolicyDao = null;
    @Autowired
    Similar similar = null;

    @Override
    public Collection<Policy> selectAllPolicies() {
        return iPolicyDao.selectAllPolicies();
    }

    @Override
    public Collection<Policy> selectPoliciesByPage(int curPage) {
        return iPolicyDao.selectPoliciesByPage((curPage-1)*10);
    }

    @Override
    public int insertPolicy(Policy policy) {
        return iPolicyDao.insertPolicy(policy);
    }

    @Override
    public List<String> getAllTitleOfPolicy() {
        return iPolicyDao.getAllTitleOfPolicy();
    }

    @Override
    public Policy getPolicyByTitle(String title) {
        return iPolicyDao.getPolicyByTitle(title);
    }

    @Override
    public List<String> getPolicyByTag(String tag) {
        return iPolicyDao.getPolicyByTag(tag);
    }

    @Override
    public Collection<String> getSimilarTitle(String message) {
        return iPolicyDao.getSimilarTitle(message);
    }
}
