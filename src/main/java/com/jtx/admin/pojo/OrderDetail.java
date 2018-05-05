package com.jtx.admin.pojo;

import java.util.Date;

public class OrderDetail {
    private String id;

    private String orderId;

    private String car;

    private String techniId;

    private String address;

    private String longitude;

    private String latitude;

    private String contact;

    private String platformTradeNo;

    private Date reservationTime;

    private Date closeTime;

    private Date createTime;

    private Date updateTime;

    public OrderDetail(String id, String orderId, String car, String techniId, String address, String longitude, String latitude, String contact, String platformTradeNo, Date reservationTime, Date closeTime, Date createTime, Date updateTime) {
        this.id = id;
        this.orderId = orderId;
        this.car = car;
        this.techniId = techniId;
        this.address = address;
        this.longitude = longitude;
        this.latitude = latitude;
        this.contact = contact;
        this.platformTradeNo = platformTradeNo;
        this.reservationTime = reservationTime;
        this.closeTime = closeTime;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public OrderDetail() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car == null ? null : car.trim();
    }

    public String getTechniId() {
        return techniId;
    }

    public void setTechniId(String techniId) {
        this.techniId = techniId == null ? null : techniId.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude == null ? null : longitude.trim();
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude == null ? null : latitude.trim();
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }

    public String getPlatformTradeNo() {
        return platformTradeNo;
    }

    public void setPlatformTradeNo(String platformTradeNo) {
        this.platformTradeNo = platformTradeNo == null ? null : platformTradeNo.trim();
    }

    public Date getReservationTime() {
        return reservationTime;
    }

    public void setReservationTime(Date reservationTime) {
        this.reservationTime = reservationTime;
    }

    public Date getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
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