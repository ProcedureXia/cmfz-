package com.baizhi.cmfz.dao;

import com.baizhi.cmfz.entity.Admin;
import com.baizhi.cmfz.entity.Permission;
import com.baizhi.cmfz.entity.Role;

import java.util.List;

/**
 * Created by yx on 2018/7/5.
 * @Description 通过姓名查询
 */

public interface AdminDao {
    public Admin selectAdminByName(String mgrName);

    //查询角色
    public List<Role> selectRoleByName(String mgrName);

    //查询权限
    public List<Permission> selectPermissionByName(String mgrName);

}
