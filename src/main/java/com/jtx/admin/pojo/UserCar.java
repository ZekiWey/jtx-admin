package com.jtx.admin.pojo;

import java.util.Date;

public class UserCar {
    private String id;

    private String userId;

    private String model;

    private String color;

    private String number;

    private Date createTime;

    private Date updateTime;

    public UserCar(String id, String userId, String model, String color, String number, Date createTime, Date updateTime) {
        this.id = id;
        this.userId = userId;
        this.model = model;
        this.color = color;
        this.number = number;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public UserCar() {
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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color == null ? null : color.trim();
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
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