package com.jtx.admin.dao;

import com.jtx.admin.pojo.WashUserCar;

import java.util.List;

public interface WashUserCarMapper {
    int deleteByPrimaryKey(String id);

    int insert(WashUserCar record);

    int insertSelective(WashUserCar record);

    WashUserCar selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(WashUserCar record);

    int updateByPrimaryKey(WashUserCar record);

    List<WashUserCar> selectCarListByUserId(String userId);
}