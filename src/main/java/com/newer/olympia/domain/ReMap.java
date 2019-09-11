package com.newer.olympia.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class ReMap implements Serializable {

    private static final long serialVersionUID = -1698238227656585379L;
    private Integer User_id;//用户id
    private String User_last_name;//用户
    private String User_name;//用户
    private String User_img;//头像
    private Integer Blogs_id;//博客的id
    private String Blogs_content;//动态
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date Blogs_time;//发布时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private String Comment_content;//评论的时间
    private Integer count;//总数
    private String howTime;//距离时间
    private Integer Blogs_like;//点赞数
    public ReMap() {
    }

    public ReMap(Integer user_id, String user_last_name, String user_name, String user_img, Integer blogs_id, String blogs_content, Date blogs_time, String comment_content, Integer count, String howTime, Integer blogs_like) {
        User_id = user_id;
        User_last_name = user_last_name;
        User_name = user_name;
        User_img = user_img;
        Blogs_id = blogs_id;
        Blogs_content = blogs_content;
        Blogs_time = blogs_time;
        Comment_content = comment_content;
        this.count = count;
        this.howTime = howTime;
        Blogs_like = blogs_like;
    }

    public Integer getUser_id() {
        return User_id;
    }

    public void setUser_id(Integer user_id) {
        User_id = user_id;
    }

    public String getUser_last_name() {
        return User_last_name;
    }

    public void setUser_last_name(String user_last_name) {
        User_last_name = user_last_name;
    }

    public String getUser_name() {
        return User_name;
    }

    public void setUser_name(String user_name) {
        User_name = user_name;
    }

    public String getUser_img() {
        return User_img;
    }

    public void setUser_img(String user_img) {
        User_img = user_img;
    }

    public Integer getBlogs_id() {
        return Blogs_id;
    }

    public void setBlogs_id(Integer blogs_id) {
        Blogs_id = blogs_id;
    }

    public String getBlogs_content() {
        return Blogs_content;
    }

    public void setBlogs_content(String blogs_content) {
        Blogs_content = blogs_content;
    }

    public Date getBlogs_time() {
        return Blogs_time;
    }

    public void setBlogs_time(Date blogs_time) {
        Blogs_time = blogs_time;
    }

    public String getComment_content() {
        return Comment_content;
    }

    public void setComment_content(String comment_content) {
        Comment_content = comment_content;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getHowTime() {
        return howTime;
    }

    public void setHowTime(String howTime) {
        this.howTime = howTime;
    }

    public Integer getBlogs_like() {
        return Blogs_like;
    }

    public void setBlogs_like(Integer blogs_like) {
        Blogs_like = blogs_like;
    }
}
