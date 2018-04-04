package com.jtx.admin.controller;

import com.jtx.admin.common.ServerResponse;
import com.jtx.admin.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

/**
 * @author
 * @date 2018-4.4
 * 套餐管理
 */
@Controller
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private IItemService itemService;


    @RequestMapping("/list")
    @ResponseBody
    public ServerResponse itemList(){
        return itemService.itemList();
    }

    @RequestMapping("/add")
    @ResponseBody
    public ServerResponse addItem(@RequestParam(value = "title") String title,
                                  @RequestParam(value = "subTitle") String subTitle,
                                  @RequestParam(value = "titleDesc") String titleDesc,
                                  @RequestParam(value = "price") BigDecimal price,
                                  @RequestParam(value = "image") MultipartFile image,
                                  @RequestParam(value = "category",defaultValue = "1") Integer category,
                                  @RequestParam(value = "sortOrder",defaultValue = "0") Integer sortOrder,
                                  @RequestParam(value = "status",defaultValue = "1") Integer status,
                                  @RequestParam(value = "url") String url){
        return itemService.itemAdd(title, subTitle, titleDesc, price,image, category, sortOrder, status, url);
    }

    @RequestMapping("/upload")
    @ResponseBody
    public ServerResponse uploadItem(@RequestParam(value = "title",required = false) String title,
                                  @RequestParam(value = "itemId",required = true)Long itemId,
                                  @RequestParam(value = "subTitle",required = false) String subTitle,
                                  @RequestParam(value = "titleDesc",required = false) String titleDesc,
                                  @RequestParam(value = "price",required = false) BigDecimal price,
                                  @RequestParam(value = "image",required = false) MultipartFile image,
                                  @RequestParam(value = "category",required = false) Integer category,
                                  @RequestParam(value = "sortOrder",required = false) Integer sortOrder,
                                  @RequestParam(value = "status",required = false) Integer status,
                                  @RequestParam(value = "url",required = false) String url){
        return null;
//        return itemService.itemUpload(itemId,title, subTitle, titleDesc, price,image, category, sortOrder, status, url);
    }


}
