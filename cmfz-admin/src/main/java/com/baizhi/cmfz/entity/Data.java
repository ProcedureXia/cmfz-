package com.baizhi.cmfz.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by yx on 2018/7/9.
 */
public class Data implements Serializable{

    private List<String> sex; //用户性别
    private List<Integer> counts; //用户数量

    public Data() {
    }

    public Data(List<String> sex, List<Integer> counts) {
        this.sex = sex;
        this.counts = counts;
    }

    public List<String> getSex() {
        return sex;
    }

    public void setSex(List<String> sex) {
        this.sex = sex;
    }

    public List<Integer> getCounts() {
        return counts;
    }

    public void setCounts(List<Integer> counts) {
        this.counts = counts;
    }

    @Override
    public String toString() {
        return "Data{" +
                "sex=" + sex +
                ", counts=" + counts +
                '}';
    }
}
