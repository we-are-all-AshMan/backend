package cn.edu.whu.ashman.entities;

import lombok.AllArgsConstructor;

/**
 * @Author LiuWeiFan
 * @create 2020/7/18 15:36
 */
@AllArgsConstructor
public class SocialSecurityCard {
        private String openId; //唯一的标识符，主键
        private String name;
        private String socialSecurityNumber;
        private String socialSecurityCardNumber;
        private Integer state;

        public SocialSecurityCard(){}
        /**
         *
         * @param openId
         */
        public SocialSecurityCard(String openId) {
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

        public String getSocialSecurityNumber() {
            return socialSecurityNumber;
        }

        public void setSocialSecurityNumber(String socialSecurityNumber) {
            this.socialSecurityNumber = socialSecurityNumber;
        }

        public String getSocialSecurityCardNumber() {
            return socialSecurityCardNumber;
        }

        public void setSocialSecurityCardNumber(String socialSecurityCardNumber) {
            this.socialSecurityCardNumber = socialSecurityCardNumber;
        }

        public Integer getState() {
            return state;
        }

        public void setState(Integer state) {
            this.state = state;
        }

        @Override
        public String toString() {
            return "SocialSecurityCard{" +
                    "openId='" + openId + '\'' +
                    ", name='" + name + '\'' +
                    ", socialSecurityNumber='" + socialSecurityNumber + '\'' +
                    ", socialSecurityCardNumber='" + socialSecurityCardNumber + '\'' +
                    ", state=" + state +
                    '}';
        }
    }

