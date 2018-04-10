package com.jtx.admin.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class Item {
    private Long id;

    private String title;

    private String subTitle;

    private String titleDesc;

    private BigDecimal price;

    private String image;

    private Integer category;

    private Integer sortOrder;

    private Integer status;

    private String url;

    private Date createTime;

    private Date updateTime;

    public Item(Long id, String title, String subTitle, String titleDesc, BigDecimal price, String image, Integer category, Integer sortOrder, Integer status, String url, Date createTime, Date updateTime) {
        this.id = id;
        this.title = title;
        this.subTitle = subTitle;
        this.titleDesc = titleDesc;
        this.price = price;
        this.image = image;
        this.category = category;
        this.sortOrder = sortOrder;
        this.status = status;
        this.url = url;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Item() {
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

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle == null ? null : subTitle.trim();
    }

    public String getTitleDesc() {
        return titleDesc;
    }

    public void setTitleDesc(String titleDesc) {
        this.titleDesc = titleDesc == null ? null : titleDesc.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
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