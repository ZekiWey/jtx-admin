package com.jtx.admin.service;

import com.jtx.admin.common.ServerResponse;

import java.util.Date;

/**
 * 订单管理系统
 * @author zeki
 * @date 2018-4-12
 */
public interface IOrderService {

    /**
     * 浏览订单
     * @param pageSize 每页显示
     * @param pageNum  页码
     * @return
     */
    ServerResponse orderList(int pageSize,
                             int pageNum,
                             String userId,
                             Long itemId,
                             Integer status,
                             Integer techniId,
                             Date reservationTimeBegin,
                             Date reservationTimeEnd,
                             Date createTimeBegin,
                             Date createTimeEnd,
                             String sortField);

}
