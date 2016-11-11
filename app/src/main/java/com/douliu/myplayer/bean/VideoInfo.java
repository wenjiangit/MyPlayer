package com.douliu.myplayer.bean;

import java.io.Serializable;

/**
 * Created by douliu on 2016/11/8.
 */
public class VideoInfo implements Serializable {
    /**
     * airTime : 2016
     * duration : 01:34:22
     * loadType : video
     * score : 10
     * angleIcon : http://yweb0.cnliveimg.com/sites/160329181030511_575.png
     * dataId : CMCC_00000000000000001_622496000
     * description : 电影《六弄咖啡馆》改编自藤井树（吴子云）的同名畅销小说，同时导演和编剧也是由原著作者出任，刘杰担任影片监制。主要讲述男主小绿（董子健 饰）和女主心蕊（颜卓灵 饰）之间一场真挚却无奈的青春爱情故事，对于亲情和友情的探究，以及距离对爱情的考验，同时关注年轻人对待成长和人生的态度与状态。
     * loadURL : http://api.svipmovie.com/front/videoDetailApi/videoDetail.do?mediaId=CMCC_00000000000000001_622496000
     * shareURL : http://h5.svipmovie.com/jctj/CMCC_00000000000000001_622496000.shtml?fromTo=shoujimovie
     * pic : http://phonemovie.ks3-cn-beijing.ksyun.com/image/2016/11/09/1478673356796077170.jpg
     * title : 类似的青春  不一样的人生
     * roomId :
     */
    private int airTime;
    private String duration;
    private String loadType;
    private String score;
    private String angleIcon;
    private String dataId;
    private String description;
    private String loadURL;
    private String shareURL;
    private String pic;
    private String title;
    private String roomId;

    public int getAirTime() {
        return airTime;
    }

    public void setAirTime(int airTime) {
        this.airTime = airTime;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getLoadType() {
        return loadType;
    }

    public void setLoadType(String loadType) {
        this.loadType = loadType;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getAngleIcon() {
        return angleIcon;
    }

    public void setAngleIcon(String angleIcon) {
        this.angleIcon = angleIcon;
    }

    public String getDataId() {
        return dataId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLoadURL() {
        return loadURL;
    }

    public void setLoadURL(String loadURL) {
        this.loadURL = loadURL;
    }

    public String getShareURL() {
        return shareURL;
    }

    public void setShareURL(String shareURL) {
        this.shareURL = shareURL;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    @Override
    public String toString() {
        return "VideoInfo{" +
                "airTime=" + airTime +
                ", duration='" + duration + '\'' +
                ", loadType='" + loadType + '\'' +
                ", score='" + score + '\'' +
                ", angleIcon='" + angleIcon + '\'' +
                ", dataId='" + dataId + '\'' +
                ", description='" + description + '\'' +
                ", loadURL='" + loadURL + '\'' +
                ", shareURL='" + shareURL + '\'' +
                ", pic='" + pic + '\'' +
                ", title='" + title + '\'' +
                ", roomId='" + roomId + '\'' +
                '}';
    }
}
