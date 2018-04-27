package com.jtx.admin.service;

import com.jtx.admin.common.ServerResponse;

/**
 * 订单管理系统
 * @author zeki
 * @date 2018-4-12
 */
public interface IOrderService {

    /**
     * 浏览所有的订单信息
     * @return
     */
    ServerResponse orderList();

}
