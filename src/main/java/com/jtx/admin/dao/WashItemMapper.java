package com.jtx.admin.dao;

import com.jtx.admin.pojo.WashItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WashItemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(WashItem record);

    int insertSelective(WashItem record);

    WashItem selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(WashItem record);

    int updateByPrimaryKey(WashItem record);

    List<WashItem> selectItemList();

    String selectImageByItemId(Long itemId);

    int updateImageByItemId(@Param("itemId") Long itemId, @Param("iamge") String iamge);
}