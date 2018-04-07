package com.jtx.admin.service;

import com.jtx.admin.common.ServerResponse;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

public interface IItemService {

    /**
     * 获取所有的套餐列表
     * @return
     */
    ServerResponse itemList();

    ServerResponse itemAdd(String title, String subTitle, String titleDesc, BigDecimal price,
                           MultipartFile file, Integer category, Integer sortOrder, Integer status, String url);

    ServerResponse itemUpload(Long itemId,String title, String subTitle, String titleDesc, BigDecimal price,
                              MultipartFile file,Integer category,Integer sortOrder,Integer status,String url);

    /**
     * 获取单个的套餐信息
     * @param itemId
     * @return
     */
    ServerResponse getItem(Long itemId);

    ServerResponse delItem(Long itemId);
}
