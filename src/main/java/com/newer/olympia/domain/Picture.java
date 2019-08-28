package com.newer.olympia.domain;

import java.io.Serializable;
import java.util.List;

//照片表
public class Picture implements Serializable {
    private static final long serialVersionUID = -8306443686864027272L;
    private  Integer Picture_id;//
    private String Picture_path;//图片上传路径
    private Integer User_id;//用户id
    private List<User> user;
    public Picture() {
    }

    public Picture(Integer picture_id, String picture_path, Integer user_id, List<User> user) {
        Picture_id = picture_id;
        Picture_path = picture_path;
        User_id = user_id;
        this.user = user;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    public Integer getPicture_id() {
        return Picture_id;
    }

    public void setPicture_id(Integer picture_id) {
        Picture_id = picture_id;
    }

    public String getPicture_path() {
        return Picture_path;
    }

    public void setPicture_path(String picture_path) {
        Picture_path = picture_path;
    }

    public Integer getUser_id() {
        return User_id;
    }

    public void setUser_id(Integer user_id) {
        User_id = user_id;
    }

    @Override
    public String toString() {
        return "Picture{" +
                "Picture_id=" + Picture_id +
                ", Picture_path='" + Picture_path + '\'' +
                ", User_id=" + User_id +
                ", user=" + user +
                '}';
    }
}
