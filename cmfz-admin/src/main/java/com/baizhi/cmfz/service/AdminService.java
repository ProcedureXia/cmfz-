package com.baizhi.cmfz.service;
import com.baizhi.cmfz.entity.Admin;
import com.baizhi.cmfz.entity.Permission;
import com.baizhi.cmfz.entity.Role;

import java.util.List;

/**
 * Created by yx on 2018/7/5.
 */
public interface AdminService {
    public Admin login(Admin admin);
    //角色
    public List<Role> queryRoleByName(String mgrName);

    //权限
    public List<Permission> queryPermissionByName(String mgrName);
}
