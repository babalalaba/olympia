package com.newer.olympia.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/*
/封装相册表评论页面上所有显示内容
 */
public class Album_comment_07 implements Serializable {

    private static final long serialVersionUID = -8271530974601755557L;
    private Integer Comment_id;//
    private Integer Comment_user_id;//评论用户id
    private Integer Album_id;//相册id
    private String Comment_content;//评论内容
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date Comment_time;//评论时间
    private Integer User_id;//用户id
    private String User_img;//评论人头像路径
    private String User_name;//评论人名称
    private String pinglun_time;//页面上显示的评论时间 如几小时前 几分钟前

    public Album_comment_07() {
    }

    public Album_comment_07(Integer comment_id, Integer comment_user_id, Integer album_id, String comment_content, Date comment_time, Integer user_id, String user_img, String user_name, String pinglun_time) {
        Comment_id = comment_id;
        Comment_user_id = comment_user_id;
        Album_id = album_id;
        Comment_content = comment_content;
        Comment_time = comment_time;
        User_id = user_id;
        User_img = user_img;
        User_name = user_name;
        this.pinglun_time = pinglun_time;
    }

    public Integer getComment_id() {
        return Comment_id;
    }

    public void setComment_id(Integer comment_id) {
        Comment_id = comment_id;
    }

    public Integer getComment_user_id() {
        return Comment_user_id;
    }

    public void setComment_user_id(Integer comment_user_id) {
        Comment_user_id = comment_user_id;
    }

    public Integer getAlbum_id() {
        return Album_id;
    }

    public void setAlbum_id(Integer album_id) {
        Album_id = album_id;
    }

    public String getComment_content() {
        return Comment_content;
    }

    public void setComment_content(String comment_content) {
        Comment_content = comment_content;
    }

    public Date getComment_time() {
        return Comment_time;
    }

    public void setComment_time(Date comment_time) {
        Comment_time = comment_time;
    }

    public Integer getUser_id() {
        return User_id;
    }

    public void setUser_id(Integer user_id) {
        User_id = user_id;
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

    public String getPinglun_time() {
        return pinglun_time;
    }

    public void setPinglun_time(String pinglun_time) {
        this.pinglun_time = pinglun_time;
    }
}
