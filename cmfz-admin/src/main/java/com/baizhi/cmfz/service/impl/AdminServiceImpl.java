package com.baizhi.cmfz.service.impl;
import com.baizhi.cmfz.dao.AdminDao;
import com.baizhi.cmfz.entity.Admin;
import com.baizhi.cmfz.entity.Permission;
import com.baizhi.cmfz.entity.Role;
import com.baizhi.cmfz.service.AdminService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by yx on 2018/7/5.
 */
@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;
        public Admin login(Admin admin) {
            Admin selected = adminDao.selectAdminByName(admin.getMgrName());
             if (selected != null && selected.getMgrStatus().equals("1")) {
                String salt = selected.getSalt();
                 String inputPassword = DigestUtils.md5Hex(admin.getMgrPassword() + salt);
                if(selected.getMgrPassword().equals(inputPassword)) {
                    return selected;
                }
            }
            return null;
        }

    @Override
    public List<Role> queryRoleByName(String mgrName) {

        return adminDao.selectRoleByName(mgrName);
    }

    @Override
    public List<Permission> queryPermissionByName(String mgrName) {
        return adminDao.selectPermissionByName(mgrName);
    }
}

