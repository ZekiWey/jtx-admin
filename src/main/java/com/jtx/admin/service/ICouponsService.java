package com.jtx.admin.service;

import com.jtx.admin.common.ServerResponse;
import com.jtx.admin.pojo.Coupons;

/**
 * 优惠卷服务
 * @author Zeki
 * @date 2018-4-10
 */
public interface ICouponsService {

    /**
     * 分页查看优惠卷列表
     * @param pageSize  每页展示的大小
     * @param pageNum   页码
     * @param preferentialWay 优惠方式筛选 1立减 2打折
     * @return
     */
    ServerResponse couponsList(int pageSize,int pageNum,Integer preferentialWay);

    /**
     * 新增一个优惠卷
     * @param coupons 优惠卷pojo
     * @return
     */
    ServerResponse couponsAdd(Coupons coupons);

    /**
     *获取单个的优惠卷信息
     * @param couponsId  优惠卷ID
     * @return
     */
    ServerResponse couponsGetOne(Integer couponsId);

    /**
     * 更新优惠卷信息
     * @param coupons
     * @return
     */
    ServerResponse couponsUpdate(Coupons coupons);

}
