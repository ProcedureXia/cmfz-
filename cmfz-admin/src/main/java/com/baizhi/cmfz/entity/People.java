package com.baizhi.cmfz.entity;

import java.io.Serializable;

/**
 * Created by yx on 2018/7/9.
 */
public class People implements Serializable {
    private String name;
    private Integer value;

    public People() {
    }

    public People(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
