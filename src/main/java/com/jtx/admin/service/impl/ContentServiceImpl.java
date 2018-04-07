package com.jtx.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jtx.admin.common.ServerResponse;
import com.jtx.admin.dao.WashContentMapper;
import com.jtx.admin.pojo.WashContent;
import com.jtx.admin.service.IContentService;
import com.jtx.admin.service.IFileService;
import com.jtx.admin.utils.PropertiesUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service("iContentService")
public class ContentServiceImpl implements IContentService {

    @Autowired
    WashContentMapper contentMapper;
    @Autowired
    private IFileService fileService;

    @Override
    public ServerResponse contentList(int pageSize,int pageNum,Integer category){
        PageHelper.startPage(pageNum, pageSize);
        List<WashContent> washContentList = contentMapper.selectContentList(category);
        if(CollectionUtils.isEmpty(washContentList)){
            return ServerResponse.createByErrorMessage("暂无信息");
        }
        PageInfo pageResult = new PageInfo(washContentList);
        pageResult.setList(washContentList);
        return ServerResponse.createBySuccess("所有信息",pageResult);
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public ServerResponse contentAdd(String title,Integer category,String url,MultipartFile image){
        String DefaultImageName = PropertiesUtil.getProperty("ftp.servxer.http.prefi") + "ContentDefaultImage.jpg";
        if(StringUtils.isBlank(title) || null == url || StringUtils.isBlank(url) || null == image){
            return ServerResponse.createByErrorMessage("参数错误");
        }
        WashContent washContent = new WashContent();
        washContent.setTitle(title);
        washContent.setCategory(category);
        washContent.setUrl(url);
        washContent.setImage(DefaultImageName);

        int reuslt = contentMapper.insert(washContent);
        if(reuslt < 0){
            return ServerResponse.createByErrorMessage("新增失败");
        }

        if(category == 3){
            return ServerResponse.createBySuccessMessage("新增成功");
        }
        ServerResponse serverResponse = fileService.updateContentImage(image,"img",washContent.getId());
        if(serverResponse.isSuccess()){
            return ServerResponse.createBySuccessMessage("新增成功");
        }
        try {
            throw new RuntimeException("图片上传失败");
        }catch (Exception e){
            e.printStackTrace();
        }
        return ServerResponse.createByErrorMessage("新增失败");


    }

    @Override
    public ServerResponse contentUpdate(String title,Integer category,String url,MultipartFile image,Long contentId){
        if(StringUtils.isBlank(title) || StringUtils.isBlank(url) || null == category || null == image || null == contentId){
            return ServerResponse.createByErrorMessage("参数错误");
        }
        if(null != image && category != 3){
            ServerResponse serverResponse = fileService.updateContentImage(image,"img",contentId);
            if(!serverResponse.isSuccess()){
                return ServerResponse.createByErrorMessage("更新失败");
            }
        }
        WashContent washContent = new WashContent();
        washContent.setUrl(title);
        washContent.setUrl(url);
        washContent.setCategory(category);
        washContent.setId(contentId);
        int ruselt = contentMapper.updateByPrimaryKeySelective(washContent);

        if(ruselt < 0){
            return ServerResponse.createByErrorMessage("更新失败");
        }
        return ServerResponse.createBySuccessMessage("更新成功");
    }

    @Override
    public ServerResponse contentDel(Long contentId){
        String iamgeName = contentMapper.selectContentImageById(contentId);
        String DefaultImageName = PropertiesUtil.getProperty("ftp.servxer.http.prefi") + "ItemDefaultImage.jpg";

        if(iamgeName != DefaultImageName){
            if(!fileService.delImage(iamgeName.substring(20))){
                return ServerResponse.createBySuccessMessage("删除失败");
            }
        }
        int result = contentMapper.deleteByPrimaryKey(contentId);
        if(result <= 0){
            return ServerResponse.createBySuccessMessage("删除失败");
        }
        return ServerResponse.createBySuccess("删除成功");

    }

}
