package com.jtx.admin.controller;

import com.jtx.admin.common.ServerResponse;
import com.jtx.admin.service.IContentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author
 * @date 2018-4.4
 */
@Controller
@RequestMapping("/content")
public class ContentController {

    @Autowired
    private IContentService contentService;

    @RequestMapping("/list")
    @ResponseBody
    public ServerResponse contentList(@RequestParam(value = "pageSize",defaultValue = "10") int pageSize,
                                      @RequestParam(value = "pageNum",defaultValue = "1")int pageNum,
                                      @RequestParam(value = "category",required = false)Integer category){
        return contentService.contentList(pageSize, pageNum, category);
    }

    @RequestMapping("/add")
    @ResponseBody
    public ServerResponse contentAdd(@RequestParam("title") String title,
                                     @RequestParam("category") Integer category,
                                     @RequestParam("url") String url,
                                     @RequestParam("image") MultipartFile image){

        return contentService.contentAdd(title, category, url, image);
    }

    @RequestMapping("/update")
    @ResponseBody
    public ServerResponse contentUpdate(@RequestParam(value = "title",required = false) String title,
                                     @RequestParam(value = "category",required = false) Integer category,
                                     @RequestParam(value = "url",required = false) String url,
                                     @RequestParam(value = "image",required = false) MultipartFile image,
                                        @RequestParam("contentId") Long contentId){
        System.out.println(image);
        return contentService.contentUpdate(title, category, url, image, contentId);
    }
    @RequestMapping("/del")
    @ResponseBody
    public ServerResponse contentDel(Long contentId){
        return  contentService.contentDel(contentId);
    }


}
