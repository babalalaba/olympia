package com.newer.olympia.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class User_table implements Serializable {
    private static final long serialVersionUID = 725570862182738098L;
    private Integer User_table_id;//主键
    private Integer User_id;//点赞人ID
    private Integer Blogs_id;//文章动态ID
    private Integer Status;//点赞状态
    private Date User_table_time;//点赞时间
    private List<User> user;
    private List<Blogs> blogs;
    private List<Friend> friend;
    private List<Comment> comment;
    public User_table() {
    }

    public User_table(Integer user_table_id, Integer user_id, Integer blogs_id, Integer status, Date user_table_time) {
        User_table_id = user_table_id;
        User_id = user_id;
        Blogs_id = blogs_id;
        Status = status;
        User_table_time = user_table_time;
    }
    public User_table(Integer user_table_id, Integer user_id, Integer blogs_id, Integer status, Date user_table_time, List<User> user, List<Blogs> blogs, List<Friend> friend, List<Comment> comment) {
        User_table_id = user_table_id;
        User_id = user_id;
        Blogs_id = blogs_id;
        Status = status;
        User_table_time = user_table_time;
        this.user = user;
        this.blogs = blogs;
        this.friend = friend;
        this.comment = comment;
    }
    public Integer getUser_table_id() {
        return User_table_id;
    }

    public void setUser_table_id(Integer user_table_id) {
        User_table_id = user_table_id;
    }

    public Integer getUser_id() {
        return User_id;
    }

    public void setUser_id(Integer user_id) {
        User_id = user_id;
    }

    public Integer getBlogs_id() {
        return Blogs_id;
    }

    public void setBlogs_id(Integer blogs_id) {
        Blogs_id = blogs_id;
    }

    public Integer getStatus() {
        return Status;
    }

    public void setStatus(Integer status) {
        Status = status;
    }

    public Date getUser_table_time() {
        return User_table_time;
    }

    public void setUser_table_time(Date user_table_time) {
        User_table_time = user_table_time;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    public List<Blogs> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blogs> blogs) {
        this.blogs = blogs;
    }

    public List<Friend> getFriend() {
        return friend;
    }

    public void setFriend(List<Friend> friend) {
        this.friend = friend;
    }

    public List<Comment> getComment() {
        return comment;
    }

    public void setComment(List<Comment> comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "User_table{" +
                "User_table_id=" + User_table_id +
                ", User_id=" + User_id +
                ", Blogs_id=" + Blogs_id +
                ", Status=" + Status +
                ", User_table_time=" + User_table_time +
                ", user=" + user +
                ", blogs=" + blogs +
                ", friend=" + friend +
                ", comment=" + comment +
                '}';
    }
}
