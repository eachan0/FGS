/*
*
* Fged.java
* Copyright(C) 2017-2020 fendo公司
* @date 2019-03-13
*/
package system.entity;

import java.util.List;

public class Fged {
    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 拼团ID
     */
    private Integer fgId;

    public Fged(List<Integer> list) {
        this.userId = list.get(0);
        this.fgId = list.get(1);
    }

    public Fged(){}

    /**
     * 用户ID
     * @return user_id 用户ID
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 用户ID
     * @param userId 用户ID
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 拼团ID
     * @return fg_id 拼团ID
     */
    public Integer getFgId() {
        return fgId;
    }

    /**
     * 拼团ID
     * @param fgId 拼团ID
     */
    public void setFgId(Integer fgId) {
        this.fgId = fgId;
    }
}
