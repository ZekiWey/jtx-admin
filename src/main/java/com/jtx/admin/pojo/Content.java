package com.jtx.admin.pojo;

import java.util.Date;

public class Content {
    private Long id;

    private String title;

    private Integer category;

    private String url;

    private String image;

    private Date createTime;

    private Date updateTime;

    public Content(Long id, String title, Integer category, String url, String image, Date createTime, Date updateTime) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.url = url;
        this.image = image;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Content() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
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