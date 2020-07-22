package cn.edu.whu.ashman.entites;

import java.sql.Timestamp;

/**
 * @Author LiuWeiFan
 * @create 2020/7/22 9:15
 */
public class Meeting {
    private String openId;//主键
    private String title;//标题
    private String contexts;//正文
    private Timestamp times;//时间

    public  Meeting(){}

    public Meeting(String openId, String title) {
        this.openId = openId;
        this.title = title;
    }

    public Meeting(String openId, String title, String contexts, Timestamp times) {
        this.openId = openId;
        this.title = title;
        this.contexts = contexts;
        this.times = times;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContexts() {
        return contexts;
    }

    public void setContexts(String contexts) {
        this.contexts = contexts;
    }

    public Timestamp getTimes() {
        return times;
    }

    public void setTimes(Timestamp times) {
        this.times = times;
    }

    @Override
    public String toString() {
        return "meeting{" +
                "openId='" + openId + '\'' +
                ", title='" + title + '\'' +
                ", contexts='" + contexts + '\'' +
                ", times=" + times +
                '}';
    }
}
