package cn.edu.whu.ashman.entities;

/**
 * ETC业务信息实体类
 *
 * @author Zhuyuhan
 * @date 2020-07-18 9:06
 */
/**
 * create table ETC(
 * car char(10) primary key,
 * host char(10),
 * consignee char(20),
 * tel char(11),
 * province char(20),
 * city char(20),
 * address TEXT,
 * openId char(10),
 * state int
 * );
 */
public class ETC {
    private String car;
    private String host;
    //收件人
    private String consignee;
    private String tel;
    private String province;
    private String city;
    private String address;
    private Integer state;
    private String openId;

    public ETC(String car, String host, String consignee, String tel, String province, String city, String address, Integer state, String openId) {
        this.car = car;
        this.host = host;
        this.consignee = consignee;
        this.tel = tel;
        this.province = province;
        this.city = city;
        this.address = address;
        this.state = state;
        this.openId = openId;
    }

    public ETC() {
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    @Override
    public String toString() {
        return "ETC{" +
                "car='" + car + '\'' +
                ", host='" + host + '\'' +
                ", consignee='" + consignee + '\'' +
                ", tel='" + tel + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", state=" + state +
                ", openId='" + openId + '\'' +
                '}';
    }
}
