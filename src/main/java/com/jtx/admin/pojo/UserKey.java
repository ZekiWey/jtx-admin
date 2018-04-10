package com.jtx.admin.pojo;

public class UserKey {
    private String id;

    private Long phone;

    public UserKey(String id, Long phone) {
        this.id = id;
        this.phone = phone;
    }

    public UserKey() {
        super();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }
}