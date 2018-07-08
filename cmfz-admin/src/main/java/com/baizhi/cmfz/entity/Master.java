package com.baizhi.cmfz.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.io.Serializable;

/**
 * Created by yx on 2018/7/6.
 */
public class Master implements Serializable {

    @Excel(name="编号")
    private Integer masterId;

    @Excel(name="法名")
    private String masterName;

    @Excel(name="手机号")
    private String masterPhone;

    @Excel(name="简介")
    private String masterSummer;

    private String masterPhoto;

    //@Excel(name="性别",replace = {"男_1","女_2"})
    private String masterGender;

    public Master() {
    }

    public Master(Integer masterId, String masterName, String masterPhone, String masterSummer, String masterPhoto, String masterGender) {
        this.masterId = masterId;
        this.masterName = masterName;
        this.masterPhone = masterPhone;
        this.masterSummer = masterSummer;
        this.masterPhoto = masterPhoto;
        this.masterGender = masterGender;
    }

    public Integer getMasterId() {
        return masterId;
    }

    public void setMasterId(Integer masterId) {
        this.masterId = masterId;
    }

    public String getMasterName() {
        return masterName;
    }

    public void setMasterName(String masterName) {
        this.masterName = masterName;
    }

    public String getMasterPhone() {
        return masterPhone;
    }

    public void setMasterPhone(String masterPhone) {
        this.masterPhone = masterPhone;
    }

    public String getMasterSummer() {
        return masterSummer;
    }

    public void setMasterSummer(String masterSummer) {
        this.masterSummer = masterSummer;
    }

    public String getMasterPhoto() {
        return masterPhoto;
    }

    public void setMasterPhoto(String masterPhoto) {
        this.masterPhoto = masterPhoto;
    }

    public String getMasterGender() {
        return masterGender;
    }

    public void setMasterGender(String masterGender) {
        this.masterGender = masterGender;
    }

    @Override
    public String toString() {
        return "Master{" +
                "masterId=" + masterId +
                ", masterName='" + masterName + '\'' +
                ", masterPhone='" + masterPhone + '\'' +
                ", masterSummer='" + masterSummer + '\'' +
                ", masterPhoto='" + masterPhoto + '\'' +
                ", masterGender='" + masterGender + '\'' +
                '}';
    }
}

