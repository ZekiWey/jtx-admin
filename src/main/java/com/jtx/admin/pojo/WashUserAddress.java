package com.jtx.admin.pojo;

import java.util.Date;

public class WashUserAddress {
    private String id;

    private String userId;

    private String contact;

    private String phone;

    private String address;

    private String note;

    private String addressDesc;

    private Date createTime;

    private Date updateTime;

    public WashUserAddress(String id, String userId, String contact, String phone, String address, String note, String addressDesc, Date createTime, Date updateTime) {
        this.id = id;
        this.userId = userId;
        this.contact = contact;
        this.phone = phone;
        this.address = address;
        this.note = note;
        this.addressDesc = addressDesc;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public WashUserAddress() {
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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public String getAddressDesc() {
        return addressDesc;
    }

    public void setAddressDesc(String addressDesc) {
        this.addressDesc = addressDesc == null ? null : addressDesc.trim();
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