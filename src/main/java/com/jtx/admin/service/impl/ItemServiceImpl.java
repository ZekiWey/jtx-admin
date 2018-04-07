package com.jtx.admin.service.impl;

import com.jtx.admin.common.ServerResponse;
import com.jtx.admin.dao.WashItemMapper;
import com.jtx.admin.pojo.WashItem;
import com.jtx.admin.service.IFileService;
import com.jtx.admin.service.IItemService;
import com.jtx.admin.utils.PropertiesUtil;
import net.sf.jsqlparser.schema.Server;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@Service("iItemService")
public class ItemServiceImpl implements IItemService {

    @Autowired
    private  WashItemMapper itemMapper;
    @Autowired
    private IFileService fileService;


    @Override
    public ServerResponse itemList(){
        List<WashItem> washItemList = itemMapper.selectItemList();
        if(null == washItemList || CollectionUtils.isEmpty(washItemList)){
            return ServerResponse.createByErrorMessage("暂无套餐信息");
        }

        return ServerResponse.createBySuccess("所有套餐信息",washItemList);
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public ServerResponse itemAdd(String title, String subTitle, String titleDesc, BigDecimal price,
                                  MultipartFile file,Integer category,Integer sortOrder,Integer status,String url){
        if(null == file || null == price || null == category || null == sortOrder || null == status || strsIsBlank(title,subTitle,titleDesc,url)){
            return ServerResponse.createByErrorMessage("参数错误");
        }
        String DefaultImageName = PropertiesUtil.getProperty("ftp.servxer.http.prefi") + "ItemDefaultImage.jpg";
        WashItem washItem = new WashItem();
        washItem.setTitle(title);
        washItem.setSubTitle(subTitle);
        washItem.setTitleDesc(titleDesc);
        washItem.setCategory(category);
        washItem.setStatus(status);
        washItem.setSortOrder(sortOrder);
        washItem.setPrice(price);
        washItem.setImage(DefaultImageName);
        washItem.setUrl(url);
        int result = itemMapper.insert(washItem);
        if(result < 0){
            return ServerResponse.createByErrorMessage("新增失败");
        }

        ServerResponse serverResponse = fileService.updateItemImage(file,"img",washItem.getId());
        if(serverResponse.isSuccess()) {
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
    @Transactional(rollbackFor = IOException.class)
    public ServerResponse itemUpload(Long itemId,String title, String subTitle, String titleDesc, BigDecimal price,
                                  MultipartFile file,Integer category,Integer sortOrder,Integer status,String url){
        if(null == itemId){
            return ServerResponse.createByErrorMessage("参数错误");
        }
        if(null == price && null == category && null == sortOrder && null == status && null == title && null==subTitle && null == titleDesc && null == url) {
            if(null == file){
                return ServerResponse.createByErrorMessage("参数错误");
            }
        }
        ServerResponse serverResponse = fileService.updateItemImage(file,"img",itemId);
        if(!serverResponse.isSuccess()){
            return ServerResponse.createByErrorMessage("修改失败");
        }

        WashItem washItem = new WashItem();
        washItem.setId(itemId);
        washItem.setTitle(title);
        washItem.setSubTitle(subTitle);
        washItem.setTitleDesc(titleDesc);
        washItem.setCategory(category);
        washItem.setStatus(status);
        washItem.setSortOrder(sortOrder);
        washItem.setPrice(price);
        washItem.setUrl(url);
        int result = itemMapper.updateByPrimaryKeySelective(washItem);
        if(result < 0){
            return ServerResponse.createByErrorMessage("更新失败");
        }
        return ServerResponse.createBySuccessMessage("更新成功");
    }

    @Override
    public ServerResponse getItem(Long itemId){
        WashItem washItem = itemMapper.selectByPrimaryKey(itemId);
        if(null == washItem){
            return ServerResponse.createBySuccessMessage("未找到套餐信息");
        }
        return ServerResponse.createBySuccess("套餐信息如下",washItem);
    }

    @Override
    public ServerResponse delItem(Long itemId){
        String iamgeName = itemMapper.selectImageByItemId(itemId);
        String DefaultImageName = PropertiesUtil.getProperty("ftp.servxer.http.prefi") + "ItemDefaultImage.jpg";

        if(iamgeName != DefaultImageName){
            if(!fileService.delImage(iamgeName.substring(20))){
                return ServerResponse.createBySuccessMessage("删除失败");
            }
        }
        int result = itemMapper.deleteByPrimaryKey(itemId);
        if(result <= 0){
            return ServerResponse.createBySuccessMessage("删除失败");
        }
        return ServerResponse.createBySuccess("删除成功");

    }

    /*public static void main(String[] args) {
        String s = "http://172.16.7.157/e77d9791-3a6b-4e00-8dd8-f72d0e9be343.jpg";
        String name = s.substring(20);
        System.out.println(name);
    }*/

    /**
     * 判断一个或者多个字符串是否为空
     * @param strs
     * @return true 有一个或者多个为空  false都不为空
     */
    private boolean strsIsBlank(String ... strs){
        if(null != strs && strs.length > 0){
            if(strs.length == 1){
                return StringUtils.isBlank(strs[0]);
            }else {
                for (int i = 0; i < strs.length; i++) {
                    if(StringUtils.isBlank(strs[i])){
                        return true;
                    }
                }
                return false;
            }
        }else {
            return true;
        }
    }

}
