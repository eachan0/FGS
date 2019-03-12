/*
*
* FightGroup.java
* Copyright(C) 2017-2020 fendo公司
* @date 2019-03-12
*/
package system.entity;

import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@ToString
public class FightGroup implements Serializable {
    private static final long serialVersionUID = -654156179894117020L;
    /**
     * 商品编号
     */
    private Integer proId;

    /**
     * 总人数
     */
    private Integer totalNum;

    /**
     * 当前人数
     */
    private Integer currentNum;

    /**
     * 开始时间
     */
    private Date startTime;

    /**
     * 结束时间
     */
    private Date endTime;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 商品编号
     * @return pro_id 商品编号
     */
    public Integer getProId() {
        return proId;
    }

    /**
     * 商品编号
     * @param proId 商品编号
     */
    public void setProId(Integer proId) {
        this.proId = proId;
    }

    /**
     * 总人数
     * @return total_num 总人数
     */
    public Integer getTotalNum() {
        return totalNum;
    }

    /**
     * 总人数
     * @param totalNum 总人数
     */
    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    /**
     * 当前人数
     * @return current _num 当前人数
     */
    public Integer getCurrentNum() {
        return currentNum;
    }

    /**
     * 当前人数
     * @param currentNum 当前人数
     */
    public void setCurrentNum(Integer currentNum) {
        this.currentNum = currentNum;
    }

    /**
     * 开始时间
     * @return start_time 开始时间
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * 开始时间
     * @param startTime 开始时间
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * 结束时间
     * @return end_time 结束时间
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * 结束时间
     * @param endTime 结束时间
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * 状态
     * @return status 状态
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态
     * @param status 状态
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}
