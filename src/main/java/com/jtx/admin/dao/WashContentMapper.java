package com.jtx.admin.dao;

import com.jtx.admin.pojo.WashContent;

public interface WashContentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(WashContent record);

    int insertSelective(WashContent record);

    WashContent selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(WashContent record);

    int updateByPrimaryKey(WashContent record);
}