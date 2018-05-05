package com.jtx.admin.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Order {
    private String id;

    private String userId;

    private Long itemId;

    private Long couponsId;

    private Integer reservationId;

    private BigDecimal totalPrice;

    private BigDecimal discountPrice;

    private BigDecimal practicalPrice;

    private Integer paymentMethod;

    private Date paymentTime;

    private Integer status;

    private Date createTime;

    private Date updateTime;

    public Order(String id, String userId, Long itemId, Long couponsId, Integer reservationId, BigDecimal totalPrice, BigDecimal discountPrice, BigDecimal practicalPrice, Integer paymentMethod, Date paymentTime, Integer status, Date createTime, Date updateTime) {
        this.id = id;
        this.userId = userId;
        this.itemId = itemId;
        this.couponsId = couponsId;
        this.reservationId = reservationId;
        this.totalPrice = totalPrice;
        this.discountPrice = discountPrice;
        this.practicalPrice = practicalPrice;
        this.paymentMethod = paymentMethod;
        this.paymentTime = paymentTime;
        this.status = status;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Order() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
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

    public Integer getReservationId() {
        return reservationId;
    }

    public void setReservationId(Integer reservationId) {
        this.reservationId = reservationId;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(BigDecimal discountPrice) {
        this.discountPrice = discountPrice;
    }

    public BigDecimal getPracticalPrice() {
        return practicalPrice;
    }

    public void setPracticalPrice(BigDecimal practicalPrice) {
        this.practicalPrice = practicalPrice;
    }

    public Integer getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(Integer paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
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

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}