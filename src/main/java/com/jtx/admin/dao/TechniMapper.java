package com.jtx.admin.dao;

import com.jtx.admin.pojo.Techni;
import org.apache.ibatis.annotations.Param;

public interface TechniMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Techni record);

    int insertSelective(Techni record);

    Techni selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Techni record);

    int updateByPrimaryKey(Techni record);

    String selectHeadImageByTechniId(Integer techniId);

    int updateHeadImageByTechniId(@Param("techniId") Integer techniId, @Param("headImage") String headImage);
}