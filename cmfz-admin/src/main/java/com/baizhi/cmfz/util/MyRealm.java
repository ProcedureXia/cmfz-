package com.baizhi.cmfz.util;

import com.baizhi.cmfz.dao.AdminDao;
import com.baizhi.cmfz.entity.Admin;
import com.baizhi.cmfz.entity.Permission;
import com.baizhi.cmfz.entity.Role;
import com.baizhi.cmfz.service.AdminService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

/**
 * Created by yx on 2018/7/12.
 */
public class MyRealm extends AuthorizingRealm {
    @Autowired
    private AdminDao adminDao;
    @Autowired
    private AdminService adminService;

    /**
     * 1.编程式
     * 2.标签式
     * 3.注解式
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取主身份信息
        String mgrName = (String) principalCollection.getPrimaryPrincipal();
        /*
         String adminname = (String) principalCollection.getPrimaryPrincipal();
        Admin admin = adminDao.selectAdminByName(adminname);
        if(admin!=null){
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            info.addRole("admin");
            info.addRole("user");
            info.addStringPermission("user:add");
            info.addStringPermission("user:delete");
            info.addStringPermission("user:query");
            return info;
        }*/
        List<Role> roles = adminService.queryRoleByName(mgrName);

        //封装查询到的授权信息对象
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        for (Role role : roles) {
            //将角色标签保存到返回值里
            info.addRole(role.getRoleTag());
        }
        //===============以上角色信息的获取=================

        //===============以下权限信息的获取=================
        List<Permission> permissions = adminService.queryPermissionByName(mgrName);
        for (Permission permission : permissions) {
            info.addStringPermission(permission.getPermissionTag());
        }
        return info;
    }

    /**
     *获取认证信息方法
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken)authenticationToken;
        String username = usernamePasswordToken.getUsername();
        //根据名字从数据中进行查询
        Admin admin = adminDao.selectAdminByName(username);
        if(admin !=null){
            return new SimpleAuthenticationInfo(admin.getMgrName(),
                    admin.getMgrPassword(),
                    ByteSource.Util.bytes(admin.getSalt()),
                    UUID.randomUUID().toString());
        }
        return null;
    }
}
