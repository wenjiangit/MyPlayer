package com.douliu.myplayer.bean;

/**
 * Created by douliu on 2016/11/8.
 */
public class VideoType {
    /**
     * airTime : 0
     * duration :
     * loadType : activityLive
     * score : 0
     * angleIcon :
     * dataId : 0000000055c4376a0155c46d9117001c
     * description : xinyingshi
     * loadURL : http://ips.cnlive.com/IPS/live/rd2015.action?cid=xinyingshi
     * shareURL : http://h5.svipmovie.com/hdzb/0000000055c4376a0155c46d9117001c.shtml?fromTo=shoujimovie
     * pic : http://phonemovie.ks3-cn-beijing.ksyun.com/image/2016/11/08/1478568752671046023.jpg
     * title : 蒂姆波顿带你走进佩小姐的奇幻城堡
     * roomId : 2016081905
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
        return "VideoType{" +
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
