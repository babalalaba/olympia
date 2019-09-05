package com.newer.olympia.domain;

import java.io.Serializable;


/*
/06-ProfilePage.html
封装页面好友数据的实体类
 */
public class ProfilePage_06 implements Serializable {
    private static final long serialVersionUID = 4071852398979730114L;

    private Integer User_id;//好友ID
    private String title_img;//好友名片路径
    private String User_img;//好友头像路径
    private String User_name;//好友名称
    private String User_address;//好友住址
    private Integer FriendCount;//好友的好友数量
    private Integer PhotoCount;//好友照片数据
    private Integer BlogsCount;//好友发布的博文数量
    private String intro;//好友简介
    private String Time;//与他成为好友的时间

    public ProfilePage_06() {
    }

    public ProfilePage_06(Integer user_id, String title_img, String user_img, String user_name, String user_address, Integer friendCount, Integer photoCount, Integer blogsCount, String intro, String time) {
        User_id = user_id;
        this.title_img = title_img;
        User_img = user_img;
        User_name = user_name;
        User_address = user_address;
        FriendCount = friendCount;
        PhotoCount = photoCount;
        BlogsCount = blogsCount;
        this.intro = intro;
        Time = time;
    }

    public Integer getUser_id() {
        return User_id;
    }

    public void setUser_id(Integer user_id) {
        User_id = user_id;
    }

    public String getTitle_img() {
        return title_img;
    }

    public void setTitle_img(String title_img) {
        this.title_img = title_img;
    }

    public String getUser_img() {
        return User_img;
    }

    public void setUser_img(String user_img) {
        User_img = user_img;
    }

    public String getUser_name() {
        return User_name;
    }

    public void setUser_name(String user_name) {
        User_name = user_name;
    }

    public String getUser_address() {
        return User_address;
    }

    public void setUser_address(String user_address) {
        User_address = user_address;
    }

    public Integer getFriendCount() {
        return FriendCount;
    }

    public void setFriendCount(Integer friendCount) {
        FriendCount = friendCount;
    }

    public Integer getPhotoCount() {
        return PhotoCount;
    }

    public void setPhotoCount(Integer photoCount) {
        PhotoCount = photoCount;
    }

    public Integer getBlogsCount() {
        return BlogsCount;
    }

    public void setBlogsCount(Integer blogsCount) {
        BlogsCount = blogsCount;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    @Override
    public String toString() {
        return "ProfilePage_06{" +
                "User_id=" + User_id +
                ", title_img='" + title_img + '\'' +
                ", User_img='" + User_img + '\'' +
                ", User_name='" + User_name + '\'' +
                ", User_address='" + User_address + '\'' +
                ", FriendCount=" + FriendCount +
                ", PhotoCount=" + PhotoCount +
                ", BlogsCount=" + BlogsCount +
                ", intro='" + intro + '\'' +
                ", Time='" + Time + '\'' +
                '}';
    }
}

