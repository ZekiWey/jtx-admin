package com.jtx.admin.controller;

import com.jtx.admin.common.ServerResponse;
import com.jtx.admin.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;


/**
 * 订单系统
 * @author a
 * @date
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @RequestMapping("/list")
    @ResponseBody
    public ServerResponse orderList(@RequestParam(value = "pageSize",required = false,defaultValue = "10") int pageSize,
                                    @RequestParam(value = "pageNum",required = false,defaultValue = "1") int pageNum,
                                    @RequestParam(value = "userId",required = false) String userId,
                                    @RequestParam(value = "itemId",required = false) Long itemId,
                                    @RequestParam(value = "status",required = false) Integer status,
                                    @RequestParam(value = "techniId",required = false) Integer techniId,
                                    @RequestParam(value = "reservationTimeBegin",required = false) Date reservationTimeBegin,
                                    @RequestParam(value = "reservationTimeEnd",required = false) Date reservationTimeEnd,
                                    @RequestParam(value = "beginTime",required = false) Date createTimeBegin,
                                    @RequestParam(value = "endTime",required = false) Date createTimeEnd,
                                    @RequestParam(value = "sortField",required = false)String sortField){

        return orderService.orderList(pageSize, pageNum, userId, itemId, status, techniId, reservationTimeBegin, reservationTimeEnd, createTimeBegin, createTimeEnd,sortField);
    }
}
