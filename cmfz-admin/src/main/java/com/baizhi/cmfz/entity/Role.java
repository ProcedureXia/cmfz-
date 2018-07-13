package com.baizhi.cmfz.entity;

import java.io.Serializable;

/**
 * Created by yx on 2018/7/12.
 */
public class Role{
    private Integer roleId;
    private String roleName;
    private String roleTag;

    public Role() {
    }

    public Role(Integer roleId, String roleName, String roleTag) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.roleTag = roleTag;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleTag() {
        return roleTag;
    }

    public void setRoleTag(String roleTag) {
        this.roleTag = roleTag;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", roleTag='" + roleTag + '\'' +
                '}';
    }
}
