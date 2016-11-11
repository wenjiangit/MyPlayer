package com.douliu.myplayer.bean;

/**
 * Created by douliu on 2016/11/8.
 */
public class VideoHttpResponse<T>{

    private String msg;
    private T ret;
    private int code;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getRet() {
        return ret;
    }

    public void setRet(T ret) {
        this.ret = ret;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}
