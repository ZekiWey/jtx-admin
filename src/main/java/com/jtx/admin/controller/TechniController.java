package com.jtx.admin.controller;

import com.jtx.admin.common.ServerResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author a
 */
@RestController
@RequestMapping("/techni")
public class TechniController {

    @RequestMapping("/add")
    public ServerResponse addTechni(String name,
                                    MultipartFile headImage,
                                    Integer gender,
                                    String phone,
                                    String cameraId){
        return null;
    }



}
