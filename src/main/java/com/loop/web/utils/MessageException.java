package com.loop.web.utils;



//自定义异常类
public class MessageException extends Exception{
    private String msg;

    public MessageException(String msg) {
        super();
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}