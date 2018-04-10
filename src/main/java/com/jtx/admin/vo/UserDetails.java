package com.jtx.admin.vo;

import com.jtx.admin.pojo.UserAddress;
import com.jtx.admin.pojo.UserCar;

import java.util.List;

public class UserDetails {
    private String id;
    private String phone;
    private String nikeName;
    private String gender;
    private String isVip;
    private String state;
    private String createTime;
    private String updateTime;
    private List<UserCar> carList;
    private List<UserAddress> userAddresses;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNikeName() {
        return nikeName;
    }

    public void setNikeName(String nikeName) {
        this.nikeName = nikeName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIsVip() {
        return isVip;
    }

    public void setIsVip(String isVip) {
        this.isVip = isVip;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public List<UserCar> getCarList() {
        return carList;
    }

    public void setCarList(List<UserCar> carList) {
        this.carList = carList;
    }

    public List<UserAddress> getUserAddresses() {
        return userAddresses;
    }

    public void setUserAddresses(List<UserAddress> userAddresses) {
        this.userAddresses = userAddresses;
    }
}
