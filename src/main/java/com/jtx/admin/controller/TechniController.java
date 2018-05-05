package com.jtx.admin.controller;

import com.jtx.admin.common.ServerResponse;
import com.jtx.admin.service.TechniService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author a
 */
@Controller
@RequestMapping("/techni")
public class TechniController {

    @Autowired
    private TechniService techniService;

    @RequestMapping("/add")
    @ResponseBody
    public ServerResponse addTechni(String name,

                                    MultipartFile headImage,
                                    Integer gender,
                                    String phone,
                                    String cameraId){
        return techniService.addTechni(name, headImage, gender, phone, cameraId);
    }

    @RequestMapping("/upload")
    @ResponseBody
    public ServerResponse uploadTechni(String name,
                                    MultipartFile headImage,
                                    Integer gender,
                                    String phone,
                                    String cameraId,
                                       Integer techniId,
                                       Integer status){
        return techniService.uploadTechni(name, headImage, gender, phone, cameraId, techniId, status);
    }



}
