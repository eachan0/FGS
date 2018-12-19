/*
*
* SysMenu.java
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
@Alias("menu")
public class SysMenu implements Serializable {
    private static final long serialVersionUID = 6273948047295761629L;
    /**
     *
     */
    private Integer id;

    /**
     * 图标
     */
    private String ico;

    /**
     * 名称
     */
    private String menuName;

    /**
     * 父级菜单
     */
    private Integer parentid;

    /**
     * 权限
     */
    private String permission;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 类型
     */
    private String type;

    /**
     * 链接
     */
    private String url;

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
     * 图标
     * @return ico 图标
     */
    public String getIco() {
        return ico;
    }

    /**
     * 图标
     * @param ico 图标
     */
    public void setIco(String ico) {
        this.ico = ico == null ? null : ico.trim();
    }

    /**
     * 名称
     * @return menu_name 名称
     */
    public String getMenuName() {
        return menuName;
    }

    /**
     * 名称
     * @param menuName 名称
     */
    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    /**
     * 父级菜单
     * @return parentid 父级菜单
     */
    public Integer getParentid() {
        return parentid;
    }

    /**
     * 父级菜单
     * @param parentid 父级菜单
     */
    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    /**
     * 权限
     * @return permission 权限
     */
    public String getPermission() {
        return permission;
    }

    /**
     * 权限
     * @param permission 权限
     */
    public void setPermission(String permission) {
        this.permission = permission == null ? null : permission.trim();
    }

    /**
     * 排序
     * @return sort 排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 排序
     * @param sort 排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 类型
     * @return type 类型
     */
    public String getType() {
        return type;
    }

    /**
     * 类型
     * @param type 类型
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 链接
     * @return url 链接
     */
    public String getUrl() {
        return url;
    }

    /**
     * 链接
     * @param url 链接
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }
}