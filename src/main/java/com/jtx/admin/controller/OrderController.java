package com.jtx.admin.controller;

import com.jtx.admin.common.ServerResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 订单系统
 * @author a
 * @date
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    @RequestMapping("/list")
    @ResponseBody
    public ServerResponse orderList(){
        return null;
    }
}
