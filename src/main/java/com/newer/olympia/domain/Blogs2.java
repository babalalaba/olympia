package com.newer.olympia.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

//备份博文或动态
public class Blogs2 implements Serializable {
    private static final long serialVersionUID = -2744280225872193944L;
    private Integer Blogs_id;//
    private Integer User_id;//用户id
    private String Blogs_content;//发布的内容
    private Integer Blogs_type;//判断发布的类型
    private String Blogs_img;//用户上传的图片
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date Blogs_time;//发布时间
    private Integer Blogs_like;//点赞数
    private Integer Blogs_state;//博文状态
    private String Blogs_season;//举报理由或驳回理由

    public Blogs2() {
    }

    public Blogs2(Integer blogs_id, Integer user_id, String blogs_content, Integer blogs_type, String blogs_img, Date blogs_time, Integer blogs_like, Integer blogs_state, String blogs_season) {
        Blogs_id = blogs_id;
        User_id = user_id;
        Blogs_content = blogs_content;
        Blogs_type = blogs_type;
        Blogs_img = blogs_img;
        Blogs_time = blogs_time;
        Blogs_like = blogs_like;
        Blogs_state = blogs_state;
        Blogs_season = blogs_season;
    }

    public Integer getBlogs_id() {
        return Blogs_id;
    }

    public void setBlogs_id(Integer blogs_id) {
        Blogs_id = blogs_id;
    }

    public Integer getUser_id() {
        return User_id;
    }

    public void setUser_id(Integer user_id) {
        User_id = user_id;
    }

    public String getBlogs_content() {
        return Blogs_content;
    }

    public void setBlogs_content(String blogs_content) {
        Blogs_content = blogs_content;
    }

    public Integer getBlogs_type() {
        return Blogs_type;
    }

    public void setBlogs_type(Integer blogs_type) {
        Blogs_type = blogs_type;
    }

    public String getBlogs_img() {
        return Blogs_img;
    }

    public void setBlogs_img(String blogs_img) {
        Blogs_img = blogs_img;
    }

    public Date getBlogs_time() {
        return Blogs_time;
    }

    public void setBlogs_time(Date blogs_time) {
        Blogs_time = blogs_time;
    }

    public Integer getBlogs_like() {
        return Blogs_like;
    }

    public void setBlogs_like(Integer blogs_like) {
        Blogs_like = blogs_like;
    }

    public Integer getBlogs_state() {
        return Blogs_state;
    }

    public void setBlogs_state(Integer blogs_state) {
        Blogs_state = blogs_state;
    }

    public String getBlogs_season() {
        return Blogs_season;
    }

    public void setBlogs_season(String blogs_season) {
        Blogs_season = blogs_season;
    }

    @Override
    public String toString() {
        return "Blogs2{" +
                "Blogs_id=" + Blogs_id +
                ", User_id=" + User_id +
                ", Blogs_content='" + Blogs_content + '\'' +
                ", Blogs_type=" + Blogs_type +
                ", Blogs_img='" + Blogs_img + '\'' +
                ", Blogs_time=" + Blogs_time +
                ", Blogs_like=" + Blogs_like +
                ", Blogs_state=" + Blogs_state +
                ", Blogs_season='" + Blogs_season + '\'' +
                '}';
    }
}
