/*
*
* SysRoleMenu.java
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
@Alias(value = "rolemenu")
public class SysRoleMenu implements Serializable {
    private static final long serialVersionUID = -8381645578438529044L;
    /**
     * 
     */
    private Integer id;

    /**
     * 菜单编号
     */
    private Integer menuId;

    /**
     * 角色编号
     */
    private Integer roleId;

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
     * 菜单编号
     * @return menu_id 菜单编号
     */
    public Integer getMenuId() {
        return menuId;
    }

    /**
     * 菜单编号
     * @param menuId 菜单编号
     */
    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
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
}