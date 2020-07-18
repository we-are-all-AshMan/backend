package cn.edu.whu.ashman.service.Impl;

import cn.edu.whu.ashman.dao.ISocialSecurityCardDao;
import cn.edu.whu.ashman.entities.SocialSecurityCard;
import cn.edu.whu.ashman.service.ISocialSecurityCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @Author LiuWeiFan
 * @create 2020/7/18 10:51
 */
@Service
public class SocialSecurityService implements ISocialSecurityCardService {
    @Autowired
    ISocialSecurityCardDao iSocialSecurityCardDao;
    @Override
    public SocialSecurityCard getSocialSecurityCardByOpenId(String openId) {
        return iSocialSecurityCardDao.getSocialSecurityCardByOpenId(openId);
    }

    @Override
    public int insertSocialSecurityCard(SocialSecurityCard socialSecurityCard) {
        return iSocialSecurityCardDao.insertSocialSecurityCard(socialSecurityCard);
    }

    @Override
    public int updateSocialSecurityCard(SocialSecurityCard socialSecurityCard) {
        return iSocialSecurityCardDao.updateSocialSecurityCard(socialSecurityCard);
    }

    @Override
    public Collection<SocialSecurityCard> getSocialSecurityCardsByState(Integer integer) {
        return iSocialSecurityCardDao.getSocialSecurityCardsByState(integer);
    }

    @Override
    public Collection<SocialSecurityCard> getAllSocialSecurityCards() {
        return iSocialSecurityCardDao.getAllSocialSecurityCards();
    }

    @Override
    public int delete(String openId) {
        return iSocialSecurityCardDao.delete(openId);
    }
}
