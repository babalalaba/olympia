package com.newer.olympia.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

//博文动态
public class Blogs  implements Serializable {
    private static final long serialVersionUID = -7434725189264952354L;
    private Integer Blogs_id;//id
    private Integer User_id;//用户id
    private String Blogs_content;//发布内容
    private Integer Blogs_type;//判断发布的类型
    private String Blogs_img;//上传图片
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date Blogs_time;//发布时间
    private Integer Blogs_like;//点赞数
    private Integer Blogs_state;//博文状态
    private List<User> user;
    private List<Comment> comment;
    private List<Friend> friend;
    public Blogs() {
    }

    public Blogs(Integer blogs_id, Integer user_id, String blogs_content, Integer blogs_type, String blogs_img, Date blogs_time, Integer blogs_like, Integer blogs_state, List<User> user, List<Comment> comment, List<Friend> friend) {
        Blogs_id = blogs_id;
        User_id = user_id;
        Blogs_content = blogs_content;
        Blogs_type = blogs_type;
        Blogs_img = blogs_img;
        Blogs_time = blogs_time;
        Blogs_like = blogs_like;
        Blogs_state = blogs_state;
        this.user = user;
        this.comment = comment;
        this.friend = friend;
    }

    public List<Friend> getFriend() {
        return friend;
    }

    public void setFriend(List<Friend> friend) {
        this.friend = friend;
    }

    public List<User> getUser() {
        return user;
    }

    public List<Comment> getComment() {
        return comment;
    }

    public void setComment(List<Comment> comment) {
        this.comment = comment;
    }

    public void setUser(List<User> user) {
        this.user = user;
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

    @Override
    public String toString() {
        return "Blogs{" +
                "Blogs_id=" + Blogs_id +
                ", User_id=" + User_id +
                ", Blogs_content='" + Blogs_content + '\'' +
                ", Blogs_type=" + Blogs_type +
                ", Blogs_img='" + Blogs_img + '\'' +
                ", Blogs_time=" + Blogs_time +
                ", Blogs_like=" + Blogs_like +
                ", Blogs_state=" + Blogs_state +
                ", user=" + user +
                ", comment=" + comment +
                ", friend=" + friend +
                '}';
    }
}
