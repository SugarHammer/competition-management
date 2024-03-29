package com.example.entity;

import java.io.Serializable;

/**
 * @author limeng
 * @create 2020-10-06 10:30
 */
public class CollectInfo implements Serializable {
    private Long id;
    private String shoucangmingcheng;
    private Long userId;
    private Long shujuid;
    private String level;
    private String addtime;
    private String biao;

    public CollectInfo() {
    }

    public CollectInfo(Long id, String shoucangmingcheng, Long userId, Long shujuid, String level,String biao) {
        this.id = id;
        this.shoucangmingcheng = shoucangmingcheng;
        this.userId = userId;
        this.shujuid = shujuid;
        this.level = level;
        this.biao = biao;
        //this.time = time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShoucangmingcheng() {
        return shoucangmingcheng;
    }

    public void setShoucangmingcheng(String shoucangmingcheng) {
        this.shoucangmingcheng = shoucangmingcheng;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getShujuid() {
        return shujuid;
    }

    public void setShujuid(Long shujuid) {
        this.shujuid = shujuid;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getBiao() {
        return biao;
    }

    public void setBiao(String biao) {
        this.biao = biao;
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }

    @Override
    public String toString() {
        return "CollectInfo{" +
                "id='" + id + '\'' +
                ", shoucangmingcheng='" + shoucangmingcheng + '\'' +
                ", userId=" + userId +
                ", shujuid=" + shujuid +
                ", level=" + level +
                ", biao=" + biao +
                ", addtime='" + addtime + '\'' +
                '}';
    }
}
