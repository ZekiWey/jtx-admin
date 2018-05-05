package com.jtx.admin.vo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单列表页面的Dto
 * @author  a
 * @date 2018-5-5
 */
public class OrderListDto {

    private String orderId;
    private String userId;
    private Long itemId;
    private Long couponsId;
    private BigDecimal practicalPrice;
    private Integer status;
    private Date createTime;
    private Integer techniId;
    private String addressInfo;
    private Date reservationTime;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getCouponsId() {
        return couponsId;
    }

    public void setCouponsId(Long couponsId) {
        this.couponsId = couponsId;
    }

    public BigDecimal getPracticalPrice() {
        return practicalPrice;
    }

    public void setPracticalPrice(BigDecimal practicalPrice) {
        this.practicalPrice = practicalPrice;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getTechniId() {
        return techniId;
    }

    public void setTechniId(Integer techniId) {
        this.techniId = techniId;
    }

    public String getAddressInfo() {
        return addressInfo;
    }

    public void setAddressInfo(String addressInfo) {
        this.addressInfo = addressInfo;
    }

    public Date getReservationTime() {
        return reservationTime;
    }

    public void setReservationTime(Date reservationTime) {
        this.reservationTime = reservationTime;
    }

    public OrderListDto(String orderId, String userId, Long itemId, Long couponsId, BigDecimal practicalPrice, Integer status, Date createTime, Integer techniId, String addressInfo, Date reservationTime) {
        this.orderId = orderId;
        this.userId = userId;
        this.itemId = itemId;
        this.couponsId = couponsId;
        this.practicalPrice = practicalPrice;
        this.status = status;
        this.createTime = createTime;
        this.techniId = techniId;
        this.addressInfo = addressInfo;
        this.reservationTime = reservationTime;
    }
}
