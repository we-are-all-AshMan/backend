package cn.edu.whu.ashman.Service;

import cn.edu.whu.ashman.entities.News;

import java.util.Collection;

/**
 * Created by Zhu yuhan
 * Date:2020/7/10 16:35
 **/
public interface INewsService {

    Collection<News> getAllNews();

    Collection<News> getNewsByDate(String date);

    int insert(News news);

    int delete(String id);

    int update(String id);

    boolean refreshOrNot(String date);
}
