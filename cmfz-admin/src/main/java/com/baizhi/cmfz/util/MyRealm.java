package com.baizhi.cmfz.util;

import com.baizhi.cmfz.dao.AdminDao;
import com.baizhi.cmfz.entity.Admin;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

/**
 * Created by yx on 2018/7/12.
 */
public class MyRealm extends AuthorizingRealm {
    @Autowired
    private AdminDao adminDao;

    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取主身份信息
        String adminname= (String) principalCollection.getPrimaryPrincipal();
        Admin admin = adminDao.selectAdminByName(adminname);
        if(admin!=null){
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            info.addRole("admin");
            info.addRole("user");
            info.addStringPermission("user:add");
            info.addStringPermission("user:delete");
            info.addStringPermission("user:query");
            return info;
        }
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken)authenticationToken;
        String username = usernamePasswordToken.getUsername();
        //根据名字从数据中进行查询
        Admin admin = adminDao.selectAdminByName(username);
        if(admin !=null){
            return new SimpleAuthenticationInfo(admin.getMgrName(),admin.getMgrPassword(), ByteSource.Util.bytes(admin.getSalt()), UUID.randomUUID().toString());
        }
        return null;
    }
}
