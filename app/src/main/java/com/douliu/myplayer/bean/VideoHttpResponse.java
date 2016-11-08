package com.douliu.myplayer.bean;

import java.util.List;

/**
 * Created by douliu on 2016/11/8.
 */
public class VideoHttpResponse {


    private String msg;
    private Ret ret;
    private String code;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Ret getRet() {
        return ret;
    }

    public void setRet(Ret ret) {
        this.ret = ret;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
