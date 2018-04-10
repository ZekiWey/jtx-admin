package com.jtx.admin.dao;

import com.jtx.admin.pojo.Item;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ItemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Item record);

    int insertSelective(Item record);

    Item selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Item record);

    int updateByPrimaryKey(Item record);

    List<Item> selectItemList();

    String selectImageByItemId(Long itemId);

    int updateImageByItemId(@Param("itemId") Long itemId, @Param("iamge") String iamge);
}