package com.jtx.admin.pojo;

import java.util.Date;

public class Coupons {
    private Integer id;

    private String name;

    private String couponsDesc;

    private Integer preferentialWay;

    private String preferentialInfo;

    private String scope;

    private Date createTime;

    private Date updateTime;

    public Coupons(Integer id, String name, String couponsDesc, Integer preferentialWay, String preferentialInfo, String scope, Date createTime, Date updateTime) {
        this.id = id;
        this.name = name;
        this.couponsDesc = couponsDesc;
        this.preferentialWay = preferentialWay;
        this.preferentialInfo = preferentialInfo;
        this.scope = scope;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Coupons() {
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

    public String getCouponsDesc() {
        return couponsDesc;
    }

    public void setCouponsDesc(String couponsDesc) {
        this.couponsDesc = couponsDesc == null ? null : couponsDesc.trim();
    }

    public Integer getPreferentialWay() {
        return preferentialWay;
    }

    public void setPreferentialWay(Integer preferentialWay) {
        this.preferentialWay = preferentialWay;
    }

    public String getPreferentialInfo() {
        return preferentialInfo;
    }

    public void setPreferentialInfo(String preferentialInfo) {
        this.preferentialInfo = preferentialInfo == null ? null : preferentialInfo.trim();
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope == null ? null : scope.trim();
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