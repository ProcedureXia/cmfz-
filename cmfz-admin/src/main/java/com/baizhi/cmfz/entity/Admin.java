package com.baizhi.cmfz.entity;

import java.io.Serializable;

/**
 * Created by yx on 2018/7/5.
 */
public class Admin implements Serializable{
    private Integer mgrId;
    private String mgrName;
    private String mgrPassword;
    private String salt;
    private String mgrStatus;

    public Admin() {

    }

    public Admin(Integer mgrId, String mgrName, String mgrPassword, String salt, String mgrStatus) {
        this.mgrId = mgrId;
        this.mgrName = mgrName;
        this.mgrPassword = mgrPassword;
        this.salt = salt;
        this.mgrStatus = mgrStatus;
    }

    public Integer getMgrId() {
        return mgrId;
    }

    public void setMgrId(Integer mgrId) {
        this.mgrId = mgrId;
    }

    public String getMgrName() {
        return mgrName;
    }

    public void setMgrName(String mgrName) {
        this.mgrName = mgrName;
    }

    public String getMgrPassword() {
        return mgrPassword;
    }

    public void setMgrPassword(String mgrPassword) {
        this.mgrPassword = mgrPassword;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getMgrStatus() {
        return mgrStatus;
    }

    public void setMgrStatus(String mgrStatus) {
        this.mgrStatus = mgrStatus;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "mgrId=" + mgrId +
                ", mgrName='" + mgrName + '\'' +
                ", mgrPassword='" + mgrPassword + '\'' +
                ", salt='" + salt + '\'' +
                ", mgrStatus='" + mgrStatus + '\'' +
                '}';
    }
}
