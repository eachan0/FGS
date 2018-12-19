/*
*
* SysUserRole.java
* Copyright(C) 2017-2020 fendo公司
* @date 2018-12-19
*/
package system.entity;

import lombok.ToString;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * @author zhuyc
 */
@ToString
@Alias("userrole")
public class SysUserRole implements Serializable {
    private static final long serialVersionUID = -3098979506364465157L;
    /**
     * 
     */
    private Integer id;

    /**
     * 角色编号
     */
    private Integer roleId;

    /**
     * 用户编号
     */
    private Integer userId;

    /**
     * 
     * @return id 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 角色编号
     * @return role_id 角色编号
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * 角色编号
     * @param roleId 角色编号
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * 用户编号
     * @return user_id 用户编号
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 用户编号
     * @param userId 用户编号
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}