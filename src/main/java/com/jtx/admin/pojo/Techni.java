package com.jtx.admin.pojo;

import java.util.Date;

public class Techni {
    private Integer id;

    private String name;

    private String headImage;

    private Integer gender;

    private Long phone;

    private String cameraId;

    private Integer orderTotal;

    private Integer evaluation;

    private Integer status;

    private Date createTime;

    private Date updateTime;

    public Techni(Integer id, String name, String headImage, Integer gender, Long phone, String cameraId, Integer orderTotal, Integer evaluation, Integer status, Date createTime, Date updateTime) {
        this.id = id;
        this.name = name;
        this.headImage = headImage;
        this.gender = gender;
        this.phone = phone;
        this.cameraId = cameraId;
        this.orderTotal = orderTotal;
        this.evaluation = evaluation;
        this.status = status;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Techni() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getHeadImage() {
        return headImage;
    }

    public void setHeadImage(String headImage) {
        this.headImage = headImage == null ? null : headImage.trim();
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getCameraId() {
        return cameraId;
    }

    public void setCameraId(String cameraId) {
        this.cameraId = cameraId == null ? null : cameraId.trim();
    }

    public Integer getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(Integer orderTotal) {
        this.orderTotal = orderTotal;
    }

    public Integer getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(Integer evaluation) {
        this.evaluation = evaluation;
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