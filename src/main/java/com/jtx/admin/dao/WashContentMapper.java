package com.jtx.admin.dao;

import com.jtx.admin.pojo.WashContent;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WashContentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(WashContent record);

    int insertSelective(WashContent record);

    WashContent selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(WashContent record);

    int updateByPrimaryKey(WashContent record);

    List<WashContent> selectContentList(@Param("category") Integer category);

    String selectContentImageById(Long contentId);

    int updateImageById(@Param("contentId") Long contentId,@Param("image") String image);
}