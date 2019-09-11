package com.newer.olympia.domain;

import java.io.Serializable;
import java.util.List;

//相册表
public class Album implements Serializable {
    private static final long serialVersionUID = -1112284983777099985L;
    private Integer Album_id;//id
    private String Album_name;//相册名
    private Integer Picture_id;//照片id
    private Integer User_id;//用户id
    private String Album_describe;//相册描述
    private Integer Album_like;//点赞数
/*    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")*/
    private String Album_time;
    private List<User> user;
    private List<Picture> picture;

    public Album() {
    }

    public Album(Integer album_id, String album_name, Integer picture_id, Integer user_id, String album_describe, Integer album_like, String album_time, List<User> user, List<Picture> picture) {
        Album_id = album_id;
        Album_name = album_name;
        Picture_id = picture_id;
        User_id = user_id;
        Album_describe = album_describe;
        Album_like = album_like;
        Album_time = album_time;
        this.user = user;
        this.picture = picture;
    }

    public Integer getAlbum_id() {
        return Album_id;
    }

    public void setAlbum_id(Integer album_id) {
        Album_id = album_id;
    }

    public String getAlbum_name() {
        return Album_name;
    }

    public void setAlbum_name(String album_name) {
        Album_name = album_name;
    }

    public Integer getPicture_id() {
        return Picture_id;
    }

    public void setPicture_id(Integer picture_id) {
        Picture_id = picture_id;
    }

    public Integer getUser_id() {
        return User_id;
    }

    public void setUser_id(Integer user_id) {
        User_id = user_id;
    }

    public String getAlbum_describe() {
        return Album_describe;
    }

    public void setAlbum_describe(String album_describe) {
        Album_describe = album_describe;
    }

    public Integer getAlbum_like() {
        return Album_like;
    }

    public void setAlbum_like(Integer album_like) {
        Album_like = album_like;
    }

    public String getAlbum_time() {
        return Album_time;
    }

    public void setAlbum_time(String album_time) {
        Album_time = album_time;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    public List<Picture> getPicture() {
        return picture;
    }

    public void setPicture(List<Picture> picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "Album{" +
                "Album_id=" + Album_id +
                ", Album_name='" + Album_name + '\'' +
                ", Picture_id=" + Picture_id +
                ", User_id=" + User_id +
                ", Album_describe='" + Album_describe + '\'' +
                ", Album_like=" + Album_like +
                ", Album_time=" + Album_time +
                ", user=" + user +
                ", picture=" + picture +
                '}';
    }
}
