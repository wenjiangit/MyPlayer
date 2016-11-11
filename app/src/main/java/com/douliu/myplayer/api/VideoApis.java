package com.douliu.myplayer.api;

import com.douliu.myplayer.bean.VideoHttpResponse;
import com.douliu.myplayer.bean.VideoRes;
import com.douliu.myplayer.bean.VideoType;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
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
    Observable<VideoHttpResponse<VideoRes>> getHomePage();


    @GET("videoDetailApi/videoDetail.do")
    Observable<VideoHttpResponse<VideoRes>> getVideoDetail(@Query("mediaId") String mediaId);

}
