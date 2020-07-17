package cn.edu.whu.ashman.entities;

/**
 * 用户实体类
 *
 * @author Zhuyuhan
 * @date 2020-07-09 15:31
 */

public class User {
    private String tel;
    private String userName;
    private String identity;
    private String birth;
    private String place;
    private String url;

    public User(){}
    public User(String userName,String identity, String tel, String birth, String place,String url){
        //通过手机短信验证码登录或者微信授权登录的用户字段填充有差异
        this.userName = userName;
        this.birth = birth;
        this.identity = identity;
        this.url = url;
        this.place = place;
        this.tel = tel;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "User{" +
                "tel='" + tel + '\'' +
                ", userName='" + userName + '\'' +
                ", identity='" + identity + '\'' +
                ", birth='" + birth + '\'' +
                ", place='" + place + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
