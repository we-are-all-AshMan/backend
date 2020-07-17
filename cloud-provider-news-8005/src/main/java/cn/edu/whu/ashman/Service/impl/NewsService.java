package cn.edu.whu.ashman.Service.impl;

import cn.edu.whu.ashman.Service.INewsService;
import cn.edu.whu.ashman.dao.INewsDao;
import cn.edu.whu.ashman.entities.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Collection;

/**
 * @author Zhuyuhan
 * @date 2020-07-10 16:35
 */
@Service
public class NewsService implements INewsService {

    @Autowired
    INewsDao iNewsDao = null;
    @Override
    public Collection<News> getAllNews() {
        return iNewsDao.getAllNews();
    }

    @Override
    public Collection<News> getNewsByDate(String date) {
        return iNewsDao.getNewsByDate(date);
    }

    @Override
    public int insert(News news) {
        return iNewsDao.insert(news);
    }

    @Override
    public int delete(String id) {
        return iNewsDao.delete(id);
    }

    @Override
    public int update(String id) {
        return iNewsDao.updateNewsTag(id);
    }

    @Override
    public boolean refreshOrNot(String date) {
        if(!getNewsByDate(date).isEmpty())
        return true;
        else return false;
    }
}
