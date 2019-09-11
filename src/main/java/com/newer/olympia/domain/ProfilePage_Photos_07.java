package com.newer.olympia.domain;


import java.io.Serializable;
import java.util.List;

/*
/封装了07页面的 显示数据
 */
public class ProfilePage_Photos_07 implements Serializable {

    private static final long serialVersionUID = -1664549329450461594L;
    private Integer Album_id;//id
    private String Album_name;//相册名
    private Integer Picture_id;//照片id
    private Integer User_id;//用户id
    private String Album_describe;//相册描述
    private Integer Album_like;//点赞数
    private String Album_time;//创建时间
    private Integer Picture_count;//照片数
    private Integer Album_comment_count;//评论数
    private String Picture_path;//封面路径
    private String Img_path;//头像路径
    private String User_name;//用户名
    private List<Picture> pictures;//相册下所有照片集合
    public ProfilePage_Photos_07() {
    }

    public ProfilePage_Photos_07(Integer album_id, String album_name, Integer picture_id, Integer user_id, String album_describe, Integer album_like, String album_time, Integer picture_count, Integer album_comment_count, String picture_path, String img_path, String user_name, List<Picture> pictures) {
        Album_id = album_id;
        Album_name = album_name;
        Picture_id = picture_id;
        User_id = user_id;
        Album_describe = album_describe;
        Album_like = album_like;
        Album_time = album_time;
        Picture_count = picture_count;
        Album_comment_count = album_comment_count;
        Picture_path = picture_path;
        Img_path = img_path;
        User_name = user_name;
        this.pictures = pictures;
    }

    public List<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(List<Picture> pictures) {
        this.pictures = pictures;
    }

    public String getImg_path() {
        return Img_path;
    }

    public void setImg_path(String img_path) {
        Img_path = img_path;
    }

    public String getUser_name() {
        return User_name;
    }

    public void setUser_name(String user_name) {
        User_name = user_name;
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

    public Integer getPicture_count() {
        return Picture_count;
    }

    public void setPicture_count(Integer picture_count) {
        Picture_count = picture_count;
    }

    public Integer getAlbum_comment_count() {
        return Album_comment_count;
    }

    public void setAlbum_comment_count(Integer album_comment_count) {
        Album_comment_count = album_comment_count;
    }

    public String getPicture_path() {
        return Picture_path;
    }

    public void setPicture_path(String picture_path) {
        Picture_path = picture_path;
    }
}
