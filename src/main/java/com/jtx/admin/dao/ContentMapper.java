package com.jtx.admin.dao;

import com.jtx.admin.pojo.Content;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ContentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Content record);

    int insertSelective(Content record);

    Content selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Content record);

    int updateByPrimaryKey(Content record);

    List<Content> selectContentList(@Param("category") Integer category);

    String selectContentImageById(Long contentId);

    int updateImageById(@Param("contentId") Long contentId,@Param("image") String image);
}