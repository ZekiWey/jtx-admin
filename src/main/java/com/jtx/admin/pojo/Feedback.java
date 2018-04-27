package com.jtx.admin.pojo;

public class Feedback {
    private Integer id;

    private String userId;

    private String description;

    public Feedback(Integer id, String userId, String description) {
        this.id = id;
        this.userId = userId;
        this.description = description;
    }

    public Feedback() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}