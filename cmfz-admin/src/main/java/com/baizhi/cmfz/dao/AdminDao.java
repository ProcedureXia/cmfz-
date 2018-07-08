package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Admin;

/**
 * Created by yx on 2018/7/5.
 * @Description 通过姓名查询
 */

public interface AdminDao {
    public Admin selectAdminByName(String mgrName);
}
