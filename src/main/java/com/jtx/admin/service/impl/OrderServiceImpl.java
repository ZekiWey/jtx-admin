package com.jtx.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.jtx.admin.common.ServerResponse;
import com.jtx.admin.dao.OrderDetailMapper;
import com.jtx.admin.dao.OrderMapper;
import com.jtx.admin.service.IOrderService;
import com.jtx.admin.vo.OrderListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author a
 * @date 2018-5.3
 */
@Service("iOrderService")
public class OrderServiceImpl implements IOrderService{

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Override
    public ServerResponse orderList(int pageSize, int pageNum,
                                    String userId, Long itemId,
                                    Integer status, Integer techniId,
                                    Date reservationTimeBegin, Date reservationTimeEnd,
                                    Date createTimeBegin, Date createTimeEnd,
                                    String sortField) {

        if(null != reservationTimeBegin && null != reservationTimeEnd){
            if(reservationTimeBegin.compareTo(reservationTimeEnd) == 1){
                return ServerResponse.createByErrorMessage("预约时间开始区间大于结束区间");
            }
        }
        if(null != createTimeBegin && null != createTimeEnd){
            if(createTimeBegin.compareTo(createTimeEnd) == 1){
                return ServerResponse.createByErrorMessage("订单创建时间开始区间大于结束区间");
            }
        }
        if(null != status){
            if(status < 0 || status > 5){
                return ServerResponse.createByErrorMessage("订单状态填写错误");
            }
        }
        List<String> sortFieldMap = Lists.newArrayList();
        if(null != sortField) {
            List<String> sortFieldList = Arrays.asList(sortField.split(","));


            for (String s : sortFieldList) {
                Integer order = Integer.parseInt(s.substring(0, 1));
                String filed = s.substring(1);
                sortFieldMap.add(filed + (order == 0 ? " asc" : " desc"));
            }
            System.out.println(sortFieldMap.toString());
        }
        PageHelper.startPage(pageNum,pageSize);
        List<OrderListDto> orderListDtoList = orderMapper.selectOrderList(userId, itemId, status, techniId, reservationTimeBegin, reservationTimeEnd, createTimeBegin, createTimeEnd,sortFieldMap);
        if(CollectionUtils.isEmpty(orderListDtoList) && pageNum == 1){
            return ServerResponse.createByErrorMessage("没有找到匹配的信息");
        }
        PageInfo pageResult = new PageInfo(orderListDtoList);
        pageResult.setList(orderListDtoList);
        return ServerResponse.createBySuccess("总共"+ orderListDtoList.size() +"条记录",pageResult);
    }
}
