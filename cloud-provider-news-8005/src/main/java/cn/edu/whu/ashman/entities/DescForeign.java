package cn.edu.whu.ashman.entities;

/**
 * 外国疫情数据实体类
 *
 * @author Zhuyuhan
 * @date 2020-07-10 17:31
 */

public class DescForeign {
    /**
     * "foreignStatistics": {
     *           "currentConfirmedCount": 5078773,
     *           "confirmedCount": 12156163,
     *           "suspectedCount": 4,
     *           "curedCount": 6527541,
     *           "deadCount": 549849,
     *           "suspectedIncr": 0,
     *           "currentConfirmedIncr": 7326,
     *           "confirmedIncr": 90987,
     *           "curedIncr": 81685,
     *           "deadIncr": 1976
     *         },
     */
    private String date;
    private String currentConfirmedCount;
    private String confirmedCount;
    private String suspectedCount;
    private String curedCount;
    private String deadCount;
    private String suspectedIncr;
    private String currentConfirmedIncr;
    private String confirmedIncr;
    private String curedIncr;
    private String deadIncr;

    public DescForeign(){}

    public DescForeign(String date,String currentConfirmedCount,String confirmedCount, String suspectedCount,
                       String curedCount,String deadCount,String suspectedIncr,String currentConfirmedIncr,
                       String confirmedIncr,String curedIncr,String deadIncr
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
}
