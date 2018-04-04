package com.jtx.admin.dao;

import com.jtx.admin.pojo.WashUser;
import com.jtx.admin.pojo.WashUserKey;
import com.jtx.admin.vo.UserVO;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface WashUserMapper {
    int deleteByPrimaryKey(WashUserKey key);

    int insert(WashUser record);

    int insertSelective(WashUser record);

    WashUser selectByPrimaryKey(WashUserKey key);

    int updateByPrimaryKeySelective(WashUser record);

    int updateByPrimaryKey(WashUser record);

    List<UserVO> selectAllUsers(@Param("isVip") Integer isVip, @Param("gender")Integer gender,
                                @Param("state")Integer state, @Param("integralBegin") String integralBegin,
                                @Param("integralEnd") String integralEnd,
                                @Param("cTimeBegin")Date cTimeBegin,
                                @Param("cTimeEnd")Date cTimeEnd, @Param("orderFiled") List<String> orderFiled);

    int updateStateByUserId(@Param("userId") String userId,@Param("state") Integer state);

    WashUser selectByUserId(String userId);
}