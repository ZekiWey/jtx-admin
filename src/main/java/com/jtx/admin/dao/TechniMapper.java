package com.jtx.admin.dao;

import com.jtx.admin.pojo.Techni;

public interface TechniMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Techni record);

    int insertSelective(Techni record);

    Techni selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Techni record);

    int updateByPrimaryKey(Techni record);
}