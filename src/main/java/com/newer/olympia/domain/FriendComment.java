package com.newer.olympia.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
//封装了页面上评论的显示内容
public class FriendComment implements Serializable {

    private static final long serialVersionUID = 5722808533739073423L;
    private Integer Comment_id;//id
    private Integer Comment_user_id;//用户评论id
    private Integer Blogs_id;//评论的动态或博文的ad
    private String Comment_content;//评论的内容
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date Comment_time;//数据库中评论时间
    private Integer User_id;//用户id
    private String Comment_user_name;//评论好友的名字
    private String Comment_user_img;//评论好友头像
    private String pinglun_time;//页面上显示的评论时间 如几小时前 几分钟前

    public FriendComment() {
    }

    public FriendComment(Integer comment_id, Integer comment_user_id, Integer blogs_id, String comment_content, Date comment_time, Integer user_id, String comment_user_name, String comment_user_img, String pinglun_time) {
        Comment_id = comment_id;
        Comment_user_id = comment_user_id;
        Blogs_id = blogs_id;
        Comment_content = comment_content;
        Comment_time = comment_time;
        User_id = user_id;
        Comment_user_name = comment_user_name;
        Comment_user_img = comment_user_img;
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

    public Integer getBlogs_id() {
        return Blogs_id;
    }

    public void setBlogs_id(Integer blogs_id) {
        Blogs_id = blogs_id;
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

    public String getComment_user_name() {
        return Comment_user_name;
    }

    public void setComment_user_name(String comment_user_name) {
        Comment_user_name = comment_user_name;
    }

    public String getComment_user_img() {
        return Comment_user_img;
    }

    public void setComment_user_img(String comment_user_img) {
        Comment_user_img = comment_user_img;
    }

    public String getPinglun_time() {
        return pinglun_time;
    }

    public void setPinglun_time(String pinglun_time) {
        this.pinglun_time = pinglun_time;
    }
}
