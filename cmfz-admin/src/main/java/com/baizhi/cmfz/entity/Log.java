package com.baizhi.cmfz.entity;

import com.sun.xml.internal.ws.spi.db.DatabindingException;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * Created by yx on 2018/7/9.
 */
public class Log implements Serializable{

    //操作日志ID
    private String logId;

    //操作日志的管理员
    private String user;

    //操作时间
    private Date time;

    //操作的资源类型
    private String resource;

    //操作的动作
    private String action;

    //操作的内容
    private String message;

    //操作的结果
    private String result;


    public Log() {
        this.logId = UUID.randomUUID().toString().replace("-","");
    }

    public Log(String logId, String user, Date time, String resource, String action, String message, String result) {
        this.logId = logId;
        this.user = user;
        this.time = time;
        this.resource = resource;
        this.action = action;
        this.message = message;
        this.result = result;
    }

    public String getLogId() {
        return logId;
    }

    public void setLogId(String logId) {
        this.logId = logId;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Log{" +
                "logId='" + logId + '\'' +
                ", user='" + user + '\'' +
                ", time=" + time +
                ", resource='" + resource + '\'' +
                ", action='" + action + '\'' +
                ", message='" + message + '\'' +
                ", result='" + result + '\'' +
                '}';
    }
}
