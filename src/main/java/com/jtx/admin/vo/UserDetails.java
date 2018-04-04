package com.jtx.admin.vo;

import com.jtx.admin.pojo.WashUserAddress;
import com.jtx.admin.pojo.WashUserCar;

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
    private List<WashUserCar> carList;
    private List<WashUserAddress> userAddresses;

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

    public List<WashUserCar> getCarList() {
        return carList;
    }

    public void setCarList(List<WashUserCar> carList) {
        this.carList = carList;
    }

    public List<WashUserAddress> getUserAddresses() {
        return userAddresses;
    }

    public void setUserAddresses(List<WashUserAddress> userAddresses) {
        this.userAddresses = userAddresses;
    }
}
