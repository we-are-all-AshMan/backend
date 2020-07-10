package cn.edu.whu.ashman.entities;

import lombok.Data;

/**
 * 国内疫情实体类
 *
 * @author Zhuyuhan
 * @date 2020-07-10 16:54
 */
@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class DescNation {
    /**
     *  "desc": {
     *         "id": 1,
     *         "createTime": 1579537899000,
     *         "modifyTime": 1594368642000,
     *         "summary": "",
     *         "deleted": false,
     *         "countRemark": "",
     *         "currentConfirmedCount": 531, //现存确诊人数
     *         "confirmedCount": 85447,  //累计确诊人数
     *         "suspectedCount": 1962, //现存疑似人数
     *         "curedCount": 80268, //累计治愈人数
     *         "deadCount": 4648,//累计死亡人数
     *         "seriousCount": 113,//现存重症人数
     *         "suspectedIncr": 4,//新增疑似人数
     *         "currentConfirmedIncr": 20,//相比昨天现存确诊人数变化
     *         "confirmedIncr": 48,//相比昨天累计确诊人数
     *         "curedIncr": 28,//相比昨天新增治愈人数
     *         "deadIncr": 0,//相比昨天新增死亡人数
     *         "seriousIncr": 1,//相比昨天现存重症人数
     */
    private String date;
    private String currentConfirmedCount;
    private String confirmedCount;
    private String suspectedCount;
    private String curedCount;
    private String deadCount;
    private String seriousCount;
    private String suspectedIncr;
    private String currentConfirmedIncr;
    private String confirmedIncr;
    private String curedIncr;
    private String deadIncr;
    private String seriousIncr;

    public DescNation(){}

    public DescNation(String date,String currentConfirmedCount,String confirmedCount, String suspectedCount,
                       String curedCount,String deadCount,String suspectedIncr,String currentConfirmedIncr,
                       String confirmedIncr,String curedIncr,String deadIncr,String seriousCount,String seriousIncr
    ){
        this.confirmedCount = confirmedCount;
        this.confirmedIncr = confirmedIncr;
        this.curedCount = curedCount;
        this.curedIncr = curedIncr;
        this.date = date;
        this.deadCount = deadCount;
        this.deadIncr = deadIncr;
        this.currentConfirmedCount =currentConfirmedCount;
        this.currentConfirmedIncr = currentConfirmedIncr;
        this.suspectedCount = suspectedCount;
        this.suspectedIncr = suspectedIncr;
        this.seriousCount = seriousCount;
        this.seriousIncr = seriousIncr;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCurrentConfirmedCount() {
        return currentConfirmedCount;
    }

    public void setCurrentConfirmedCount(String currentConfirmedCount) {
        this.currentConfirmedCount = currentConfirmedCount;
    }

    public String getConfirmedCount() {
        return confirmedCount;
    }

    public void setConfirmedCount(String confirmedCount) {
        this.confirmedCount = confirmedCount;
    }

    public String getSuspectedCount() {
        return suspectedCount;
    }

    public void setSuspectedCount(String suspectedCount) {
        this.suspectedCount = suspectedCount;
    }

    public String getCuredCount() {
        return curedCount;
    }

    public void setCuredCount(String curedCount) {
        this.curedCount = curedCount;
    }

    public String getDeadCount() {
        return deadCount;
    }

    public void setDeadCount(String deadCount) {
        this.deadCount = deadCount;
    }

    public String getSeriousCount() {
        return seriousCount;
    }

    public void setSeriousCount(String seriousCount) {
        this.seriousCount = seriousCount;
    }

    public String getSuspectedIncr() {
        return suspectedIncr;
    }

    public void setSuspectedIncr(String suspectedIncr) {
        this.suspectedIncr = suspectedIncr;
    }

    public String getCurrentConfirmedIncr() {
        return currentConfirmedIncr;
    }

    public void setCurrentConfirmedIncr(String currentConfirmedIncr) {
        this.currentConfirmedIncr = currentConfirmedIncr;
    }

    public String getConfirmedIncr() {
        return confirmedIncr;
    }

    public void setConfirmedIncr(String confirmedIncr) {
        this.confirmedIncr = confirmedIncr;
    }

    public String getCuredIncr() {
        return curedIncr;
    }

    public void setCuredIncr(String curedIncr) {
        this.curedIncr = curedIncr;
    }

    public String getDeadIncr() {
        return deadIncr;
    }

    public void setDeadIncr(String deadIncr) {
        this.deadIncr = deadIncr;
    }

    public String getSeriousIncr() {
        return seriousIncr;
    }

    public void setSeriousIncr(String seriousIncr) {
        this.seriousIncr = seriousIncr;
    }

    @Override
    public String toString() {
        return  "国内疫情数据对象"+"DescNation{" +
                "date='" + date + '\'' +
                ", currentConfirmedCount='" + currentConfirmedCount + '\'' +
                ", confirmedCount='" + confirmedCount + '\'' +
                ", suspectedCount='" + suspectedCount + '\'' +
                ", curedCount='" + curedCount + '\'' +
                ", deadCount='" + deadCount + '\'' +
                ", seriousCount='" + seriousCount + '\'' +
                ", suspectedIncr='" + suspectedIncr + '\'' +
                ", currentConfirmedIncr='" + currentConfirmedIncr + '\'' +
                ", confirmedIncr='" + confirmedIncr + '\'' +
                ", curedIncr='" + curedIncr + '\'' +
                ", deadIncr='" + deadIncr + '\'' +
                ", seriousIncr='" + seriousIncr + '\'' +
                '}';
    }
}
