package cn.edu.whu.ashman.entities;

import java.sql.Date;


/**
 * @Author LiuWeiFan
 * @create 2020/7/19 10:59
 */
public class Policy {
    private String title;//标题
    private String tag;//分类，标签
    private String indexNumber;//索引号
    private String issuingNumber;//发文字号
    private String issuingAgency;//发文机关
    private java.sql.Date createdDate;//成文日期
    private java.sql.Date publishDate;//发布日期
    private String contexts;//正文

    public Policy(String title, String tag, String indexNumber, String issuingNumber, String issuingAgency, Date createdDate, Date publishDate, String contexts) {
        this.title = title;
        this.tag = tag;
        this.indexNumber = indexNumber;
        this.issuingNumber = issuingNumber;
        this.issuingAgency = issuingAgency;
        this.createdDate = createdDate;
        this.publishDate = publishDate;
        this.contexts = contexts;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getIndexNumber() {
        return indexNumber;
    }

    public void setIndexNumber(String indexNumber) {
        this.indexNumber = indexNumber;
    }

    public String getIssuingNumber() {
        return issuingNumber;
    }

    public void setIssuingNumber(String issuingNumber) {
        this.issuingNumber = issuingNumber;
    }

    public String getIssuingAgency() {
        return issuingAgency;
    }

    public void setIssuingAgency(String issuingAgency) {
        this.issuingAgency = issuingAgency;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getContexts() {
        return contexts;
    }

    public void setContexts(String contexts) {
        this.contexts = contexts;
    }

    @Override
    public String toString() {
        return "Policy{" +
                "title='" + title + '\'' +
                ", tag='" + tag + '\'' +
                ", indexNumber='" + indexNumber + '\'' +
                ", issuingNumber='" + issuingNumber + '\'' +
                ", issuingAgency='" + issuingAgency + '\'' +
                ", createdDate=" + createdDate +
                ", publishDate=" + publishDate +
                ", contexts='" + contexts + '\'' +
                '}';
    }
}
