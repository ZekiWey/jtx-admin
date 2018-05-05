package com.jtx.admin.vo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单详情页面
 * @author a
 * @date  2018-5-5
 */
public class OrderDetailDTO {

    private String orderId;
    private String userId;
    private Long itemId;
    private Long couponsId;
    private BigDecimal totalPrice;
    private BigDecimal discountPrice;
    private BigDecimal practicalPrice;
    private Integer paymentMethod;
    private Date payment_time;
    private Integer status;
    private Date createTime;
    private String carInfo;
    private Integer techniId;
    private String addressInfo;
    private String contactInfo;
    private String platformTradeNo;
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

    public Date getPayment_time() {
        return payment_time;
    }

    public void setPayment_time(Date payment_time) {
        this.payment_time = payment_time;
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

    public String getCarInfo() {
        return carInfo;
    }

    public void setCarInfo(String carInfo) {
        this.carInfo = carInfo;
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

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getPlatformTradeNo() {
        return platformTradeNo;
    }

    public void setPlatformTradeNo(String platformTradeNo) {
        this.platformTradeNo = platformTradeNo;
    }

    public Date getReservationTime() {
        return reservationTime;
    }

    public void setReservationTime(Date reservationTime) {
        this.reservationTime = reservationTime;
    }

    public OrderDetailDTO(String orderId, String userId, Long itemId, Long couponsId, BigDecimal totalPrice, BigDecimal discountPrice, BigDecimal practicalPrice, Integer paymentMethod, Date payment_time, Integer status, Date createTime, String carInfo, Integer techniId, String addressInfo, String contactInfo, String platformTradeNo, Date reservationTime) {
        this.orderId = orderId;
        this.userId = userId;
        this.itemId = itemId;
        this.couponsId = couponsId;
        this.totalPrice = totalPrice;
        this.discountPrice = discountPrice;
        this.practicalPrice = practicalPrice;
        this.paymentMethod = paymentMethod;
        this.payment_time = payment_time;
        this.status = status;
        this.createTime = createTime;
        this.carInfo = carInfo;
        this.techniId = techniId;
        this.addressInfo = addressInfo;
        this.contactInfo = contactInfo;
        this.platformTradeNo = platformTradeNo;
        this.reservationTime = reservationTime;
    }

    public OrderDetailDTO() {
    }
}
