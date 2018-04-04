package com.jtx.admin.vo;

public class UserVO {

    private String id;
    private String phone;
    private String nickName;
    private String gender;
    private String isVip;
    private String state;
    private String integral;
    private String create_time;

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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
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

    public String getIntegral() {
        return integral;
    }

    public void setIntegral(String integral) {
        this.integral = integral;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public UserVO() {
    }

    public UserVO(String id, String phone, String nickName, String gender, String isVip, String state, String integral, String create_time) {
        this.id = id;
        this.phone = phone;
        this.nickName = nickName;
        this.gender = gender;
        this.isVip = isVip;
        this.state = state;
        this.integral = integral;
        this.create_time = create_time;
    }
}
