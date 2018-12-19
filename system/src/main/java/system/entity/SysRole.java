/*
*
* SysRole.java
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
@Alias("role")
public class SysRole implements Serializable {
    private static final long serialVersionUID = -6244993181691460931L;
    /**
     * 
     */
    private Integer id;

    /**
     * 是否启用
     */
    private Boolean isEnable;

    /**
     * 名称
     */
    private String roleName;

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
     * 是否启用
     * @return is_enable 是否启用
     */
    public Boolean getIsEnable() {
        return isEnable;
    }

    /**
     * 是否启用
     * @param isEnable 是否启用
     */
    public void setIsEnable(Boolean isEnable) {
        this.isEnable = isEnable;
    }

    /**
     * 名称
     * @return role_name 名称
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * 名称
     * @param roleName 名称
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }
}