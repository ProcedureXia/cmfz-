package com.baizhi.cmfz.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by yx on 2018/7/8.
 */
public class Article implements Serializable {
    private Integer articleId;
    private String articleName;
    private String articleContent;
    private Date articleDate;
    private String articleAddress; //路径
    private String articleStatus;
    private Integer masterId;

    public Article() {
    }

    public Article(Integer articleId, String articleName, String articleContent, Date articleDate, String articleAddress, String articleStatus, Integer masterId) {
        this.articleId = articleId;
        this.articleName = articleName;
        this.articleContent = articleContent;
        this.articleDate = articleDate;
        this.articleAddress = articleAddress;
        this.articleStatus = articleStatus;
        this.masterId = masterId;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public Date getArticleDate() {
        return articleDate;
    }

    public void setArticleDate(Date articleDate) {
        this.articleDate = articleDate;
    }

    public String getArticleAddress() {
        return articleAddress;
    }

    public void setArticleAddress(String articleAddress) {
        this.articleAddress = articleAddress;
    }

    public String getArticleStatus() {
        return articleStatus;
    }

    public void setArticleStatus(String articleStatus) {
        this.articleStatus = articleStatus;
    }

    public Integer getMasterId() {
        return masterId;
    }

    public void setMasterId(Integer masterId) {
        this.masterId = masterId;
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleId=" + articleId +
                ", articleName='" + articleName + '\'' +
                ", articleContent='" + articleContent + '\'' +
                ", articleDate=" + articleDate +
                ", articleAddress='" + articleAddress + '\'' +
                ", articleStatus='" + articleStatus + '\'' +
                ", masterId=" + masterId +
                '}';
    }
}
