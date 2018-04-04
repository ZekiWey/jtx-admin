package com.jtx.admin.dao;

import com.jtx.admin.pojo.WashUserAddress;

import java.util.List;

public interface WashUserAddressMapper {
    int deleteByPrimaryKey(String id);

    int insert(WashUserAddress record);

    int insertSelective(WashUserAddress record);

    WashUserAddress selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(WashUserAddress record);

    int updateByPrimaryKey(WashUserAddress record);

    List<WashUserAddress> selectListAdressByUserId(String userId);
}