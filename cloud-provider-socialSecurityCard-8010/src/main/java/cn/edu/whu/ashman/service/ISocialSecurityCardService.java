package cn.edu.whu.ashman.service;

import cn.edu.whu.ashman.entities.SocialSecurityCard;

import java.util.Collection;

/**
 * @Author LiuWeiFan
 * @create 2020/7/18 10:49
 */
public interface ISocialSecurityCardService {

    SocialSecurityCard getSocialSecurityCardByOpenId(String openId);

    int insertSocialSecurityCard(SocialSecurityCard socialSecurityCard);

    int updateSocialSecurityCard(SocialSecurityCard socialSecurityCard);

    Collection<SocialSecurityCard> getSocialSecurityCardsByState(Integer integer);

    Collection<SocialSecurityCard> getAllSocialSecurityCards();

    int delete(String openId);

    int updateState(SocialSecurityCard socialSecurityCard);
}
