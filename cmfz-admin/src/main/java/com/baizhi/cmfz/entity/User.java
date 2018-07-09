package com.baizhi.cmfz.entity;

import java.io.Serializable;

/**
 * Created by yx on 2018/7/9.
 */
public class User implements Serializable {
    private Integer userId;
    private String userName;
    private String userSex;
    private String userBuddhishName;
    private String userPassword;
    private String userHeadPic;
    private String userAddress;
    private String userPhone;
    private String userSingature;

    public User() {
    }

    public User(Integer userId, String userName, String userSex, String userBuddhishName, String userPassword, String userHeadPic, String userAddress, String userPhone, String userSingature) {
        this.userId = userId;
        this.userName = userName;
        this.userSex = userSex;
        this.userBuddhishName = userBuddhishName;
        this.userPassword = userPassword;
        this.userHeadPic = userHeadPic;
        this.userAddress = userAddress;
        this.userPhone = userPhone;
        this.userSingature = userSingature;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserBuddhishName() {
        return userBuddhishName;
    }

    public void setUserBuddhishName(String userBuddhishName) {
        this.userBuddhishName = userBuddhishName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserHeadPic() {
        return userHeadPic;
    }

    public void setUserHeadPic(String userHeadPic) {
        this.userHeadPic = userHeadPic;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserSingature() {
        return userSingature;
    }

    public void setUserSingature(String userSingature) {
        this.userSingature = userSingature;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userBuddhishName='" + userBuddhishName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userHeadPic='" + userHeadPic + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userSingature='" + userSingature + '\'' +
                '}';
    }
}
