package com.douliu.myplayer.bean;

import android.text.TextUtils;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Description:
 * Creator: yxc
 * date: $date $time
 */
public class VideoRes {
    private
    @SerializedName("list")
    List<VideoType> list;
    private String title;
    private String score;
    private String videoType;
    private String region;
    private String airTime;
    private String director;
    private String actors;
    private String pic;
    private String description;
    private String smoothURL;
    private String SDURL;
    private String HDURL;

    public String getVideoUrl() {
        if (!TextUtils.isEmpty(HDURL))
            return HDURL;
        else if (!TextUtils.isEmpty(SDURL))
            return SDURL;
        else if (!TextUtils.isEmpty(smoothURL))
            return smoothURL;
        else
            return "";
    }

    public List<VideoType> getList() {
        return list;
    }

    public void setList(List<VideoType> list) {
        this.list = list;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVideoType() {
        return videoType;
    }

    public void setVideoType(String videoType) {
        this.videoType = videoType;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getAirTime() {
        return airTime;
    }

    public void setAirTime(String airTime) {
        this.airTime = airTime;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSmoothURL() {
        return smoothURL;
    }

    public void setSmoothURL(String smoothURL) {
        this.smoothURL = smoothURL;
    }

    public String getSDURL() {
        return SDURL;
    }

    public void setSDURL(String SDURL) {
        this.SDURL = SDURL;
    }

    public String getHDURL() {
        return HDURL;
    }

    public void setHDURL(String HDURL) {
        this.HDURL = HDURL;
    }
}
