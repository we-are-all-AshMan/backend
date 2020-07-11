package cn.edu.whu.ashman.entities;

import lombok.NoArgsConstructor;

/**
 * @Author Liu WeiFan
 * @create 2020年7月11日 20：56
 */
@NoArgsConstructor
public class Administrator {
    private int id;
    private String userName;
    private String password;
    private String tel;
    public Administrator(String userName, String password, String tel){
        this.userName = userName;
        this.password = password;
        this.tel = tel;
    }
    public Administrator(String userName, String password){
        this.userName = userName;
        this.password = password;
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

    @Override
    public String toString() {
        return "Administrator{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }
}

