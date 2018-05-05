package com.jtx.admin.dao;

import com.jtx.admin.pojo.Order;
import com.jtx.admin.vo.OrderListDto;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(String id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    List<OrderListDto> selectOrderList(@Param("userId") String userId, @Param("itemId") Long itemId,
                                       @Param("status") Integer status, @Param("techniId") Integer techniId,
                                       @Param("reservationTimeBegin") Date reservationTimeBegin, @Param("reservationTimeEnd") Date reservationTimeEnd,
                                       @Param("createTimeBegin") Date createTimeBegin, @Param("createTimeEnd") Date createTimeEnd,
                                       @Param("sortField") List<String> sortField);
}