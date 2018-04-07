package com.jtx.admin.service;

import com.jtx.admin.common.ServerResponse;
import com.jtx.admin.pojo.WashUser;

import java.util.Date;
import java.util.List;

public interface IUserService {

    /**
     *分页筛选查询用户信息
     * @param pageSize 页面大小
     * @param pageNum  页码
     * @param isVip    VIP字段 0否 1 是
     * @param gender   性别字段 0女 1男
     * @param state    账号状态字段 0禁封 1正常
     * @param integralBegin 积分区间开始
     * @param integralEnd   积分区间结束
     * @param cTimeBegin 注册时间开始
     * @param cTimeEnd   注册时间结束
     * @param sortField  排序字段逗号分隔格式 0 + [filed] 0升序1降序 可排序字段(integral,is_vip,gender,nick_name,state,create_time)
     * @return
     */
    ServerResponse getUserList(
            int pageSize, int pageNum, Integer isVip, Integer gender,
            Integer state,String integralBegin,String integralEnd,
            Date cTimeBegin, Date cTimeEnd, String sortField);

    /**
     * 设置用户的账号状态
     * @param userId 用户ID
     * @param state  要设置的状态 取值0  1
     * @return
     */
    ServerResponse setState(String userId,Integer state);

    /**
     * 获取用户详情
     * @param userId
     * @return
     */
    ServerResponse getUserDetails(String userId);

}
