package com.jtx.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author
 * @date
 */
@RequestMapping("/test")
@Controller
public class TestController {

    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        return "<h1>Hello World</h1>";
    }

}
