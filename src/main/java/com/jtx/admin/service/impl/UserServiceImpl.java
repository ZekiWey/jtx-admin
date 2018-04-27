package com.jtx.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.jtx.admin.common.ServerResponse;
import com.jtx.admin.dao.FeedbackMapper;
import com.jtx.admin.dao.UserAddressMapper;
import com.jtx.admin.dao.UserCarMapper;
import com.jtx.admin.dao.UserMapper;
import com.jtx.admin.pojo.Feedback;
import com.jtx.admin.pojo.User;
import com.jtx.admin.service.IUserService;
import com.jtx.admin.vo.UserDetails;
import com.jtx.admin.vo.UserVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service("iUserService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper UserMapper;
    @Autowired
    private UserCarMapper UserCarMapper;
    @Autowired
    private UserAddressMapper UserAddressMapper;
    @Autowired
    private FeedbackMapper feedbackMapper;

    @Override
    public ServerResponse getUserList(
            int pageSize, int pageNum, Integer isVip, Integer gender,
            Integer state,String integralBegin,String integralEnd, Date cTimeBegin, Date cTimeEnd,String sortField){

        if(null != integralBegin && null != integralEnd){
            if(Double.parseDouble(integralBegin) > Double.parseDouble(integralEnd)){
                return ServerResponse.createByErrorMessage("积分开始区间大于结束区间");
            }
        }
        if(null != cTimeBegin && null != cTimeEnd){
            if(cTimeBegin.compareTo(cTimeEnd) == 1){
                return ServerResponse.createByErrorMessage("时间开始区间大于结束区间");
            }
        }
        List<String> sortFieldMap = Lists.newArrayList();
        if(null != sortField) {
            List<String> sortFieldList = Arrays.asList(sortField.split(","));


            for (String s : sortFieldList) {
                Integer order = Integer.parseInt(s.substring(0, 1));
                String filed = s.substring(1);
                sortFieldMap.add(filed + (order == 0 ? " asc" : " desc"));
            }
            System.out.println(sortFieldMap.toString());
        }
        PageHelper.startPage(pageNum,pageSize);
        List<UserVO> washUserList = UserMapper.selectAllUsers(isVip, gender, state, integralBegin, integralEnd, cTimeBegin, cTimeEnd,sortFieldMap);
        PageInfo pageResult = new PageInfo(washUserList);
        pageResult.setList(washUserList);
        return ServerResponse.createBySuccess("总共"+ washUserList.size() +"条记录",pageResult);
    }

    @Override
    public ServerResponse setState(String userId,Integer state){
        if(StringUtils.isBlank(userId) || null == state){
            return ServerResponse.createByErrorMessage("参数错误");
        }
        if(state < 0 || state > 1){
            return ServerResponse.createByErrorMessage("参数错误");
        }
        int result = UserMapper.updateStateByUserId(userId, state);
        if(result > 0){
            return ServerResponse.createBySuccessMessage("状态设置成功");
        }
        return ServerResponse.createByErrorMessage("状态设置失败");
    }

    @Override
    public ServerResponse getUserDetails(String userId){
        User washUser = UserMapper.selectByUserId(userId);
        if(null == washUser){
            return ServerResponse.createByErrorMessage("未找到该用户");
        }
        UserDetails userDetails = new UserDetails();
        userDetails.setId(washUser.getId());
        userDetails.setPhone(washUser.getPhone().toString());
        userDetails.setNikeName(washUser.getNickName());
        userDetails.setIsVip(washUser.getIsVip() == 0 ? "否" : "是");
        userDetails.setGender(washUser.getGender() == 0 ? "女" : "男");
        userDetails.setState(washUser.getState() == 0 ? "禁封" : "正常");
        userDetails.setCreateTime(washUser.getCreateTime().toString());
        userDetails.setUpdateTime(washUser.getUpdateTime().toString());
        userDetails.setCarList(UserCarMapper.selectCarListByUserId(userId));
        userDetails.setUserAddresses(UserAddressMapper.selectListAdressByUserId(userId));
        return ServerResponse.createBySuccess(userDetails);
    }

    @Override
    public ServerResponse feedbackList(int pageSize,int pageNum,String userId){
        PageHelper.startPage(pageNum, pageSize);
        List<Feedback> feedbackList = feedbackMapper.selectFeedback(userId);
        if(CollectionUtils.isEmpty(feedbackList)){
            return ServerResponse.createByErrorMessage("空空如也");
        }
        PageInfo pageInfo = new PageInfo(feedbackList);
        pageInfo.setList(feedbackList);
        return ServerResponse.createBySuccess("所有的反馈信息",pageInfo);
    }

}
