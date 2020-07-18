package cn.edu.whu.ashman.entities;

/**
 * 用户实体类
 *
 * @author Zhuyuhan
 * @date 2020-07-09 15:31
 */

public class User {
    private Integer id;
    private String tel;
    private String userName;
    private String openId;
    private String imageUrl;

    public User(){}
    public User(String userName, String tel, String openId, String imageUrl){
        //通过手机短信验证码登录或者微信授权登录的用户字段填充有差异
        this.userName = userName;
        this.openId = openId;
        this.tel = tel;
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", tel='" + tel + '\'' +
                ", userName='" + userName + '\'' +
                ", openId='" + openId + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
