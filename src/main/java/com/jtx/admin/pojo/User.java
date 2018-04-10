package com.jtx.admin.pojo;

import java.util.Date;

public class User extends UserKey {
    private String nickName;

    private Integer gender;

    private Integer isVip;

    private Integer state;

    private Date createTime;

    private Date updateTime;

    public User(String id, Long phone, String nickName, Integer gender, Integer isVip, Integer state, Date createTime, Date updateTime) {
        super(id, phone);
        this.nickName = nickName;
        this.gender = gender;
        this.isVip = isVip;
        this.state = state;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public User() {
        super();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getIsVip() {
        return isVip;
    }

    public void setIsVip(Integer isVip) {
        this.isVip = isVip;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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