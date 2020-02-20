package com.dd.spring.util;

/**
 * 自定义异常类
 */
public class MyFileException extends Exception {
    //异常信息
    private String message;

    //构造函数
    public MyFileException(String message){
        super(message);
        this.message = message;
    }
}
