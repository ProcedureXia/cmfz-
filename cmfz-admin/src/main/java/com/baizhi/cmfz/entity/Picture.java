package com.baizhi.cmfz.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by yx on 2018/7/5.
 */
public class Picture implements Serializable{
    private String pictureId;
    private String pictureName;
    private String pictureDescription;
    private String pictureStatus;
    private Date createTime;

    public Picture() {
    }

    public Picture(String pictureId, String pictureName, String pictureDescription, String pictureStatus, Date createTime) {
        this.pictureId = pictureId;
        this.pictureName = pictureName;
        this.pictureDescription = pictureDescription;
        this.pictureStatus = pictureStatus;
        this.createTime = createTime;
    }

    public String getPictureId() {
        return pictureId;
    }

    public void setPictureId(String pictureId) {
        this.pictureId = pictureId;
    }

    public String getPictureName() {
        return pictureName;
    }

    public void setPictureName(String pictureName) {
        this.pictureName = pictureName;
    }

    public String getPictureDescription() {
        return pictureDescription;
    }

    public void setPictureDescription(String pictureDescription) {
        this.pictureDescription = pictureDescription;
    }

    public String getPictureStatus() {
        return pictureStatus;
    }

    public void setPictureStatus(String pictureStatus) {
        this.pictureStatus = pictureStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Picture{" +
                "pictureId='" + pictureId + '\'' +
                ", pictureName='" + pictureName + '\'' +
                ", pictureDescription='" + pictureDescription + '\'' +
                ", pictureStatus='" + pictureStatus + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
