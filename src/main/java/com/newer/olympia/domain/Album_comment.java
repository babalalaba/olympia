package com.newer.olympia.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Album_comment implements Serializable {
    private static final long serialVersionUID = -1660641927983572543L;
    private Integer Comment_id;//
    private Integer Comment_user_id;//评论用户id
    private Integer Album_id;//相册id
    private String Comment_content;//评论内容
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date Comment_time;//评论时间
    private Integer User_id;//用户id、

    public Album_comment() {
    }

    public Album_comment(Integer comment_id, Integer comment_user_id, Integer album_id, String comment_content, Date comment_time, Integer user_id) {
        Comment_id = comment_id;
        Comment_user_id = comment_user_id;
        Album_id = album_id;
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
}
