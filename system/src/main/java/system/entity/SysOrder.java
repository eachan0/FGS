/*
*
* SysOrder.java
* Copyright(C) 2017-2020 fendo公司
* @date 2019-03-07
*/
package system.entity;

import java.util.Date;

public class SysOrder {
    /**
     * 订单编号
     */
    private String orderNo;

    /**
     * 用户编号
     */
    private Integer userId;

    /**
     * 商品编号
     */
    private Integer proId;

    /**
     * 成交价格
     */
    private Double price;

    /**
     * 成交数量
     */
    private Integer num;

    /**
     * 成交总价
     */
    private Double amount;

    /**
     * 成交时间
     */
    private Date createTime;

    /**
     * 交易状态
     */
    private String schedule;

    /**
     * 是否删除
     */
    private Integer status;

    /**
     * 订单编号
     * @return order_no 订单编号
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * 订单编号
     * @param orderNo 订单编号
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
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
     * 成交价格
     * @return price 成交价格
     */
    public Double getPrice() {
        return price;
    }

    /**
     * 成交价格
     * @param price 成交价格
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * 成交数量
     * @return num 成交数量
     */
    public Integer getNum() {
        return num;
    }

    /**
     * 成交数量
     * @param num 成交数量
     */
    public void setNum(Integer num) {
        this.num = num;
    }

    /**
     * 成交总价
     * @return amount 成交总价
     */
    public Double getAmount() {
        return amount;
    }

    /**
     * 成交总价
     * @param amount 成交总价
     */
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    /**
     * 成交时间
     * @return create_time 成交时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 成交时间
     * @param createTime 成交时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 交易状态
     * @return schedule 交易状态
     */
    public String getSchedule() {
        return schedule;
    }

    /**
     * 交易状态
     * @param schedule 交易状态
     */
    public void setSchedule(String schedule) {
        this.schedule = schedule == null ? null : schedule.trim();
    }

    /**
     * 是否删除
     * @return status 是否删除
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 是否删除
     * @param status 是否删除
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}