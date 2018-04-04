package com.jtx.admin.common;

/**
 * @author yangqun
 * @create 2018-03-20
 */
public enum ResponseCode {
    SUCCESS(0,"SUCCESS"),
    ERROR(1,"ERROR"),
    ILLEGAL_ARGUMENT(2,"ILLEGAL_ARGUMENT"),
    NEED_AUTH(3,"NEED_AUTH"),
    NEED_LOGIN(10,"NEED_LOGIN");

    private int code;
    private String desc;

    ResponseCode(int code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public int getCode(){
        return code;
    }
    public String getDesc(){
        return desc;
    }
}
