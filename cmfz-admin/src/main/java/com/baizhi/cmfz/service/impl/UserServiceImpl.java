package com.baizhi.cmfz.service.impl;

import com.baizhi.cmfz.entity.User;
import com.baizhi.cmfz.service.UserService;
import com.baizhi.cmfz.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by yx on 2018/7/9.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> queryAllUser() {
        return null;
    }

    @Override
    public Integer queryUserBySex(String userSex) {
        return userDao.selectUserBySex(userSex);

    }
}
