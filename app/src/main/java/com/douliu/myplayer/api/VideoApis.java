package com.douliu.myplayer.api;

import com.douliu.myplayer.bean.VideoHttpResponse;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by douliu on 2016/11/8.
 */
public interface VideoApis {

    String HOST = "http://api.svipmovie.com/front/";

    /**
     * 首页详情
     * @return
     */

    @GET("homePageApi/homePage.do")
    Observable<VideoHttpResponse> getHomePage();


}
