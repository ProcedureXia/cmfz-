package com.baizhi.cmfz.service;

import com.baizhi.cmfz.entity.User;

import java.util.List;

/**
 * Created by yx on 2018/7/9.
 */
public interface UserService {
    public List<User> queryAllUser();


    public Integer queryUserBySex(String userSex);
}
