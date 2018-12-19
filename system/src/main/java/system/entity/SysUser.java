/*
*
* SysUser.java
* Copyright(C) 2017-2020 fendo公司
* @date 2018-12-19
*/
package system.entity;

import lombok.ToString;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.util.Date;
/**
 * @author zhuyc
 */
@ToString
@Alias("user")
public class SysUser implements Serializable {
    private static final long serialVersionUID = 3192511910759572592L;
    /**
     * 
     */
    private Integer id;

    /**
     * 创建时间
     */
    private Date crateTime;

    /**
     * 是否开启
     */
    private Boolean isEnable;

    /**
     * 是否过期
     */
    private Boolean isExpired;

    /**
     * 是否锁定
     */
    private Boolean isLock;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 密码
     */
    private String password;

    /**
     * 性别
     */
    private String sex;

    /**
     * 用户名
     */
    private String username;

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
     * 创建时间
     * @return crate_time 创建时间
     */
    public Date getCrateTime() {
        return crateTime;
    }

    /**
     * 创建时间
     * @param crateTime 创建时间
     */
    public void setCrateTime(Date crateTime) {
        this.crateTime = crateTime;
    }

    /**
     * 是否开启
     * @return is_enable 是否开启
     */
    public Boolean getIsEnable() {
        return isEnable;
    }

    /**
     * 是否开启
     * @param isEnable 是否开启
     */
    public void setIsEnable(Boolean isEnable) {
        this.isEnable = isEnable;
    }

    /**
     * 是否过期
     * @return is_expired 是否过期
     */
    public Boolean getIsExpired() {
        return isExpired;
    }

    /**
     * 是否过期
     * @param isExpired 是否过期
     */
    public void setIsExpired(Boolean isExpired) {
        this.isExpired = isExpired;
    }

    /**
     * 是否锁定
     * @return is_lock 是否锁定
     */
    public Boolean getIsLock() {
        return isLock;
    }

    /**
     * 是否锁定
     * @param isLock 是否锁定
     */
    public void setIsLock(Boolean isLock) {
        this.isLock = isLock;
    }

    /**
     * 昵称
     * @return nickname 昵称
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 昵称
     * @param nickname 昵称
     */
    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    /**
     * 密码
     * @return password 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 密码
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 性别
     * @return sex 性别
     */
    public String getSex() {
        return sex;
    }

    /**
     * 性别
     * @param sex 性别
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /**
     * 用户名
     * @return username 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 用户名
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }
}