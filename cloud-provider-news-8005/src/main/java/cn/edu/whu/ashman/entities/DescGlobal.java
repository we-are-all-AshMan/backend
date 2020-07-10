package cn.edu.whu.ashman.entities;

/**
 * 全球疫情数据实体类
 *
 * @author Zhuyuhan
 * @date 2020-07-10 17:40
 */
public class DescGlobal {
    /**
     * "globalStatistics": {
     *           "currentConfirmedCount": 5079304,
     *           "confirmedCount": 12241610,
     *           "curedCount": 6607809,
     *           "deadCount": 554497,
     *           "currentConfirmedIncr": 7346,
     *           "confirmedIncr": 91035,
     *           "curedIncr": 81713,
     *           "deadIncr": 1976
     *         }
     */
    private String date;
    private String currentConfirmedCount;
    private String confirmedCount;
    private String curedCount;
    private String deadCount;
    private String currentConfirmedIncr;
    private String confirmedIncr;
    private String curedIncr;
    private String deadIncr;

    public DescGlobal(){
    }
    public DescGlobal(String date,String currentConfirmedCount,String confirmedCount,
                       String curedCount,String deadCount,String currentConfirmedIncr,
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
