package cn.edu.whu.ashman.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 新闻实体类
 *
 * @author Zhuyuhan
 * @date 2020-07-10 16:24
 */
//@AllArgsConstructor
@NoArgsConstructor
public class News {
    /**
     *create table news(
     * id char(10) primary key,
     * title char(50),
     * summary TEXT,
     * infoSource char(50),
     * surl TEXT
     * date char(20),
     * tag int
     * );
     */
    private String id;
    private String title;
    private String summary;
    private String infoSource;
    private String sUrl;
    private String date;
    private Integer tag;

    public News(String id,String title,String summary, String infoSource,String sUrl,String date,
            Integer tag){
        this.id = id;
        this.infoSource = infoSource;
        this.summary = summary;
        this.sUrl = sUrl;
        this.title = title;
        this.date = date;
        this.tag = tag;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getInfoSource() {
        return infoSource;
    }

    public void setInfoSource(String infoSource) {
        this.infoSource = infoSource;
    }

    public String getsUrl() {
        return sUrl;
    }

    public void setsUrl(String sUrl) {
        this.sUrl = sUrl;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getTag() {
        return tag;
    }

    public void setTag(Integer tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", infoSource='" + infoSource + '\'' +
                ", sUrl='" + sUrl + '\'' +
                '}';
    }
}
