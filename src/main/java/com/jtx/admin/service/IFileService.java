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
    ServerResponse updateItemImage(MultipartFile file, String path,Long itemId) throws IOException;
}
