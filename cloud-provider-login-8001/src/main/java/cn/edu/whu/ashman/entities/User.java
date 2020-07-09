package cn.edu.whu.ashman.entities;

/**
 * 用户实体类
 *
 * @author Zhuyuhan
 * @date 2020-07-09 15:31
 */

public class User {
    private int id;
    private String userName;
    private String password;
    private String tel;
    private String openId;
    private String unionId;

    public User(){}
    public User(String userName,String password, String tel, String openId, String unionId){
        //通过手机短信验证码登录或者微信授权登录的用户字段填充有差异
        this.userName = userName;
        this.password = password;
        this.openId = openId;
        this.unionId = unionId;
        this.tel = tel;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", tel='" + tel + '\'' +
                ", openId='" + openId + '\'' +
                ", unionId='" + unionId + '\'' +
                '}';
    }
}
