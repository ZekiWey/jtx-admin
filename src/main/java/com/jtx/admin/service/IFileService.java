package com.jtx.admin.service;

import com.jtx.admin.common.ServerResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author
 * @date
 */
public interface IFileService {
    /**
     * 上传套餐的图片
     * @param file
     * @param path
     * @param itemId
     * @return
     * @throws IOException
     */
    ServerResponse updateItemImage(MultipartFile file, String path,Long itemId);

    /**
     * 上传首页广告和公告的图片
     * @param file
     * @param path
     * @param contentId 公告ID
     * @return
     * @throws IOException
     */
    ServerResponse updateContentImage(MultipartFile file, String path,Long contentId);

    boolean delImage(String imageName);
}
