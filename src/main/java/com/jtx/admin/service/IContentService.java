package com.jtx.admin.service;

import com.jtx.admin.common.ServerResponse;
import org.springframework.web.multipart.MultipartFile;

public interface IContentService {

    /**
     * 获取首页轮播图列表
     * @return
     */
    ServerResponse contentList(int pageSize,int pageNum,Integer category);

    /**
     * 上传一个新的公告或者轮播图
     * @param title  标题
     * @param category 分类 1 轮播 2公告
     * @param url      网页链接
     * @param image    图片链接
     * @return
     */
    ServerResponse contentAdd(String title,Integer category,String url,MultipartFile image);

    /**
     * 更新一个公告或者轮播图
     * @param title 标题
     * @param category 分类
     * @param url 链接
     * @param image 图片
     * @param contentId
     * @return
     */
    ServerResponse contentUpdate(String title,Integer category,String url,MultipartFile image,Long contentId);

    /**
     * 删除公告或者轮播图
     * @param contentId
     * @return
     */
    ServerResponse contentDel(Long contentId);

}
