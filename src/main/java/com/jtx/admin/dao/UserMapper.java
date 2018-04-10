package com.jtx.admin.dao;

import com.jtx.admin.pojo.User;
import com.jtx.admin.pojo.UserKey;
import com.jtx.admin.vo.UserVO;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(UserKey key);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(UserKey key);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<UserVO> selectAllUsers(@Param("isVip") Integer isVip, @Param("gender")Integer gender,
                                @Param("state")Integer state, @Param("integralBegin") String integralBegin,
                                @Param("integralEnd") String integralEnd,
                                @Param("cTimeBegin")Date cTimeBegin,
                                @Param("cTimeEnd")Date cTimeEnd, @Param("orderFiled") List<String> orderFiled);

    int updateStateByUserId(@Param("userId") String userId,@Param("state") Integer state);

    User selectByUserId(String userId);
}