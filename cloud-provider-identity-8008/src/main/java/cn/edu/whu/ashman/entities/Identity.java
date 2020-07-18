package cn.edu.whu.ashman.entities;

import io.micrometer.core.instrument.Meter;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.imageio.ImageIO;

/**
 * 电子身份证实体类
 *
 * @author Zhuyuhan
 * @date 2020-07-17 15:58
 */
@AllArgsConstructor
public class Identity {
    private String openId;
    private String name;
    private String gender;
    private String idNum;
    private String place;
    private String imageUrl;
    private Integer state;
    public Identity(){
    }
    public Identity(String openId,String name,String gender,String idNum,String place,String imageUrl){
        this.gender = gender;
        this.idNum = idNum;
        this.imageUrl = imageUrl;
        this.place = place;
        this.openId = openId;
        this.name = name;
  }

  public Identity(String openId){
        this.state = 0;
        this.openId = openId;
  }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Identity{" +
                "openId='" + openId + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", idNum='" + idNum + '\'' +
                ", place='" + place + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", state=" + state +
                '}';
    }
}
