package com.jtx.admin.controller;

import com.github.pagehelper.PageInfo;
import com.jtx.admin.common.ServerResponse;
import com.jtx.admin.pojo.WashUser;
import com.jtx.admin.service.IUserService;
import com.jtx.admin.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * @author zeki
 * @date 2018-04-02
 */

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/list")
    @ResponseBody
    public PageInfo getUserList(@RequestParam (value = "pageSize",defaultValue = "10",required = false)int pageSize,
                                @RequestParam(value = "pageNum",defaultValue = "1",required = false)int pageNum,
                                @RequestParam(value = "isVip",required = false)Integer isvip,
                                @RequestParam(value = "gender",required = false)Integer gender,
                                @RequestParam(value = "state",required = false)Integer state,
                                @RequestParam(value = "integralBegin",required = false) String integralBegin,
                                @RequestParam(value = "integralEnd",required = false) String integralEnd,
                                    @DateTimeFormat(pattern = "yyyy-MM-dd")
                                @RequestParam(value = "cTimeBegin",required = false)Date cTimeBegin,
                                    @DateTimeFormat(pattern = "yyyy-MM-dd")
                                @RequestParam(value = "cTimeEnd",required = false)Date cTimeEnd,
                                @RequestParam(value = "sortField",required = false)String sortField){
        return (PageInfo) userService.getUserList(pageSize, pageNum, isvip, gender, state,integralBegin,integralEnd, cTimeBegin, cTimeEnd, sortField).getdata();
    }

    @RequestMapping("/setState/{userId}")
    @ResponseBody
    public ServerResponse setUserState(@PathVariable(value = "userId")String userId, Integer state){
        return userService.setState(userId, state);
    }

    @RequestMapping("/details/{userId}")
    @ResponseBody
    public ServerResponse getUserDetails(@PathVariable(value = "userId")String userId){
        return userService.getUserDetails(userId);
    }


}
