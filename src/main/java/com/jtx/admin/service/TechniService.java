package com.jtx.admin.service;

import com.jtx.admin.common.ServerResponse;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author a
 */
public interface TechniService {

    /**
     * 添加一个员工
     * @param name  姓名
     * @param headImage  头像
     * @param gender   性别
     * @param phone      手机号
     * @param cameraId   摄像头ID
     * @return
     */
    ServerResponse addTechni(String name,
                             MultipartFile headImage,
                             Integer gender,
                             String phone,
                             String cameraId);

    /**
     * 修改员工
     * @param name
     * @param headImage
     * @param gender
     * @param phone
     * @param cameraId
     * @param techniId
     * @return
     */
    ServerResponse uploadTechni(String name,
                             MultipartFile headImage,
                             Integer gender,
                             String phone,
                             String cameraId,
                                Integer techniId,
                                Integer status);


}
