package com.jtx.admin.service.impl;

import com.google.common.collect.Lists;
import com.jtx.admin.common.ServerResponse;
import com.jtx.admin.dao.ContentMapper;
import com.jtx.admin.dao.ItemMapper;
import com.jtx.admin.dao.TechniMapper;
import com.jtx.admin.service.IFileService;
import com.jtx.admin.utils.FTPUtil;
import com.jtx.admin.utils.PropertiesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author
 * @date 2018-4.4
 */
@Service("iFileService")
public class FileService implements IFileService {

    @Autowired
    private ItemMapper itemMapper;
    @Autowired
    private ContentMapper contentMapper;
    @Autowired
    private TechniMapper techniMapper;

    @Override
    public ServerResponse updateItemImage(MultipartFile file, String path,Long itemId){
        String DefaultImageName = PropertiesUtil.getProperty("ftp.servxer.http.prefi") + "ItemDefaultImage.jpg";
        String fileName = file.getOriginalFilename();
        String fileExtName = fileName.substring(fileName.lastIndexOf(".") + 1);
        String name = "item" + UUID.randomUUID().toString();
        String upLoadFileName = name + "." + fileExtName;
        File fileDir = new File(path);
        if (!fileDir.exists()) {
            fileDir.setWritable(true);
            fileDir.mkdirs();
        }
        File targetFile = new File(path, upLoadFileName);
        try {
            file.transferTo(targetFile);

            String oldImage = itemMapper.selectImageByItemId(itemId);
            if (null == oldImage) {
                return ServerResponse.createByErrorMessage("封面上传失败，请重试");
            }
            if (!oldImage.equals(DefaultImageName)) {
                if (!FTPUtil.delefile(oldImage.replace(PropertiesUtil.getProperty("ftp.servxer.http.prefi") + path + "/",""))) {
                    return ServerResponse.createByErrorMessage("封面上传失败，请重试");
                }
            }
            FTPUtil.upLoadFile(Lists.newArrayList(targetFile));
            targetFile.delete();
        } catch (IOException e) {
            itemMapper.updateImageByItemId(itemId,DefaultImageName);
            return ServerResponse.createByErrorMessage("封面上传失败，请重试");
        }
        int reulst = itemMapper.updateImageByItemId(itemId,PropertiesUtil.getProperty("ftp.servxer.http.prefi") + path + "/" + targetFile.getName());

        if (reulst > 0) {
            return ServerResponse.createBySuccessMessage("封面上传成功");
        }
        return ServerResponse.createByErrorMessage("封面上传失败，请重试");
    }
    @Override
    public ServerResponse updateContentImage(MultipartFile file, String path,Long contentId){
        String DefaultImageName = PropertiesUtil.getProperty("ftp.servxer.http.prefi") + "ContentDefaultImage.jpg";
        String fileName = file.getOriginalFilename();
        String fileExtName = fileName.substring(fileName.lastIndexOf(".") + 1);
        String name = "content" +  UUID.randomUUID().toString();
        String upLoadFileName = name + "." + fileExtName;
        File fileDir = new File(path);
        if (!fileDir.exists()) {
            fileDir.setWritable(true);
            fileDir.mkdirs();
        }
        File targetFile = new File(path, upLoadFileName);
        try {
            file.transferTo(targetFile);

            String oldImage = contentMapper.selectContentImageById(contentId);
            if (null == oldImage) {
                return ServerResponse.createByErrorMessage("图片上传失败，请重试");
            }
            if (!oldImage.equals(DefaultImageName)) {
                if (!FTPUtil.delefile(oldImage.replace(PropertiesUtil.getProperty("ftp.servxer.http.prefi") + path + "/",""))) {
                    return ServerResponse.createByErrorMessage("图片上传失败，请重试");
                }
            }
            FTPUtil.upLoadFile(Lists.newArrayList(targetFile));
            targetFile.delete();
        } catch (IOException e) {
            contentMapper.updateImageById(contentId,DefaultImageName);
            return ServerResponse.createByErrorMessage("图片上传失败，请重试");
        }
        int reulst = contentMapper.updateImageById(contentId,PropertiesUtil.getProperty("ftp.servxer.http.prefi")+ path + "/" + targetFile.getName());

        if (reulst > 0) {
            return ServerResponse.createBySuccessMessage("图片上传成功");
        }
        return ServerResponse.createByErrorMessage("图片上传失败，请重试");
    }

    @Override
    public ServerResponse updateTechniHeadImage(MultipartFile file, String path,Integer techniId){
        String DefaultImageName = PropertiesUtil.getProperty("ftp.servxer.http.prefi") + "techniHeadImage.jpg";
        String fileName = file.getOriginalFilename();
        String fileExtName = fileName.substring(fileName.lastIndexOf(".") + 1);
        String name = "techniHeadImage" +  UUID.randomUUID().toString();
        String upLoadFileName = name + "." + fileExtName;
        File fileDir = new File(path);
        if (!fileDir.exists()) {
            fileDir.setWritable(true);
            fileDir.mkdirs();
        }
        File targetFile = new File(path, upLoadFileName);
        try {
            file.transferTo(targetFile);

            String oldImage = techniMapper.selectHeadImageByTechniId(techniId);
            if (null == oldImage) {
                return ServerResponse.createByErrorMessage("头像上传失败，请重试");
            }
            if (!oldImage.equals(DefaultImageName)) {
                if (!FTPUtil.delefile(oldImage.replace(PropertiesUtil.getProperty("ftp.servxer.http.prefi") + path + "/",""))) {
                    return ServerResponse.createByErrorMessage("头像上传失败，请重试");
                }
            }
            FTPUtil.upLoadFile(Lists.newArrayList(targetFile));
            targetFile.delete();
        } catch (IOException e) {
            techniMapper.updateHeadImageByTechniId(techniId,DefaultImageName);
            return ServerResponse.createByErrorMessage("头像上传失败，请重试");
        }
        int reulst = techniMapper.updateHeadImageByTechniId(techniId,PropertiesUtil.getProperty("ftp.servxer.http.prefi")+ path + "/" + targetFile.getName());

        if (reulst > 0) {
            return ServerResponse.createBySuccessMessage("头像上传成功");
        }
        return ServerResponse.createByErrorMessage("头像上传失败，请重试");
    }

    @Override
    public boolean delImage(String imageName){
        try {
            return FTPUtil.delefile(imageName);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

}