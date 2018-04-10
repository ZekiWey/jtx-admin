package com.jtx.admin.dao;

import com.jtx.admin.pojo.UserCar;

import java.util.List;

public interface UserCarMapper {
    int deleteByPrimaryKey(String id);

    int insert(UserCar record);

    int insertSelective(UserCar record);

    UserCar selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserCar record);

    int updateByPrimaryKey(UserCar record);

    List<UserCar> selectCarListByUserId(String userId);
}