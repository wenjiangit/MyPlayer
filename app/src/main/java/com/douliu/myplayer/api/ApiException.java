package com.douliu.myplayer.api;

/**
 * Api异常处理
 * Created by douliu on 2016/11/11.
 */
public class ApiException extends Exception{

    public ApiException(String message) {
        super(message);
    }
}
