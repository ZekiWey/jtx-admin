package com.jtx.admin.service.impl;

import com.jtx.admin.common.ServerResponse;
import com.jtx.admin.dao.TechniMapper;
import com.jtx.admin.pojo.Techni;
import com.jtx.admin.service.IFileService;
import com.jtx.admin.service.TechniService;
import com.jtx.admin.utils.PropertiesUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

/**
 * @author a
 */
@Service("techniService")
public class TechniServiceImpl implements TechniService{

    @Autowired
    private TechniMapper techniMapper;
    @Autowired
    private IFileService iFileService;

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public ServerResponse addTechni(String name, MultipartFile headImage, Integer gender, String phone, String cameraId) {
        String DefaultImageName = PropertiesUtil.getProperty("ftp.servxer.http.prefi") + "techniHeadImage.jpg";
        if(StringUtils.isBlank(name) || null == headImage || null == gender || StringUtils.isBlank(phone) || StringUtils.isBlank(cameraId)){
            return ServerResponse.createByErrorMessage("参数错误");
        }
        Date now = new Date();
        Techni techni = new Techni();
        techni.setName(name);
        techni.setGender(gender);
        techni.setPhone(Long.valueOf(phone));
        techni.setCameraId(cameraId);
        techni.setHeadImage(DefaultImageName);
        techni.setOrderTotal(0);
        techni.setEvaluation(100);
        techni.setStatus(1);
        techni.setCreateTime(now);
        techni.setUpdateTime(now);

        int result = techniMapper.insert(techni);

        if(result <= 0){
            return ServerResponse.createByErrorMessage("新增失败");
        }

        ServerResponse serverResponse =  iFileService.updateTechniHeadImage(headImage,"img",techni.getId());
        if(!serverResponse.isSuccess()){
            throw new RuntimeException(serverResponse.getMsg());
        }

        return ServerResponse.createBySuccessMessage("新增成功");
    }

    @Override
    public ServerResponse uploadTechni(String name, MultipartFile headImage, Integer gender, String phone, String cameraId, Integer techniId, Integer status) {
        if(null == techniId){
            return ServerResponse.createByErrorMessage("参数错误");
        }
        if(StringUtils.isBlank(name) && null == headImage && null == gender && StringUtils.isBlank(phone) && StringUtils.isBlank(cameraId) && null == techniId && null == status){
            return ServerResponse.createByErrorMessage("参数错误");
        }
        if(null != headImage) {
            ServerResponse serverResponse = iFileService.updateTechniHeadImage(headImage, "img", techniId);
            if(!serverResponse.isSuccess()){
                return ServerResponse.createByErrorMessage("头像上传失败");
            }
        }
        if(StringUtils.isBlank(name) && null == gender && StringUtils.isBlank(phone) && StringUtils.isBlank(cameraId) && null == techniId && null == status){
            return ServerResponse.createBySuccessMessage("更新成功");
        }
        Techni techni = new Techni();
        techni.setId(techniId);
        techni.setName(StringUtils.isBlank(name) ? null : name);
        techni.setGender(gender);
        techni.setPhone(StringUtils.isBlank(phone) ? null : Long.valueOf(phone));
        techni.setCameraId(StringUtils.isBlank(cameraId) ? null : cameraId);
        techni.setStatus(status);
        techni.setUpdateTime(new Date());

        int result = techniMapper.updateByPrimaryKeySelective(techni);
        if(result > 0){
            return ServerResponse.createBySuccessMessage("修改成功");
        }
        return ServerResponse.createByErrorMessage("修改失败");
    }
}
