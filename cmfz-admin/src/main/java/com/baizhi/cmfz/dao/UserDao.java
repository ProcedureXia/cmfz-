package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.User;

import java.util.List;

/**
 * Created by yx on 2018/7/9.
 */
public interface UserDao {
    public List<User> selectAll();

    public Integer count();

    public Integer selectUserBySex(String userSex);
}
