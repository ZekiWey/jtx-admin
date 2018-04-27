package com.jtx.admin.controller;

import com.jtx.admin.common.ServerResponse;
import org.apache.ibatis.binding.BindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author a
 */
@ControllerAdvice
public class BusinessException{

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Object throwableHandler(RuntimeException e){
        return ServerResponse.createByErrorMessage(e.getMessage());
    }
}
