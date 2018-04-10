package com.jtx.admin.dao;

import com.jtx.admin.pojo.Coupons;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CouponsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Coupons record);

    int insertSelective(Coupons record);

    Coupons selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Coupons record);

    int updateByPrimaryKey(Coupons record);

    List<Coupons> selectCouponsList(@Param("preferentialWay") Integer preferentialWay);
}