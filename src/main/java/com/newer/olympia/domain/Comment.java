package com.newer.olympia.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

//评论表
public class Comment implements Serializable {

    private static final long serialVersionUID = -2756749384970050818L;
    private Integer Comment_id;//id
    private Integer Comment_user_id;//用户评论id
    private Integer Blogs_id;//评论的动态或博文的ad
    private String Comment_content;//评论的内容
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date Comment_time;//评论时间
    private Integer User_id;//用户id

    public Comment() {
    }

    public Comment(Integer comment_id, Integer comment_user_id, Integer blogs_id, String comment_content, Date comment_time, Integer user_id) {
        Comment_id = comment_id;
        Comment_user_id = comment_user_id;
        Blogs_id = blogs_id;
        Comment_content = comment_content;
        Comment_time = comment_time;
        User_id = user_id;
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

    @Override
    public String toString() {
        return "Comment{" +
                "Comment_id=" + Comment_id +
                ", Comment_user_id=" + Comment_user_id +
                ", Blogs_id=" + Blogs_id +
                ", Comment_content='" + Comment_content + '\'' +
                ", Comment_time=" + Comment_time +
                ", User_id=" + User_id +
                '}';
    }
}
