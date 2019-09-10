package com.newer.olympia.domain;

import java.io.Serializable;
import java.util.List;

public class Hobbies implements Serializable {
    private static final long serialVersionUID = -8519755984279929143L;
    private Integer User_id;//用户id
    private String Hobbies_hobby;//嗜好
    private String Hobbies_music;//喜欢的音乐、乐队
    private String Hobbies_telecast;//喜欢的电视节目
    private String Hobbies_book;//喜欢的书
    private String Hobbies_movie;//喜欢的电影
    private String Hobbies_writer;//喜欢的作家
    private String Hobbies_game;//喜欢的游戏
    private String Hobbies_else;//其他兴趣爱好
    private List<User> user;

    public Hobbies() {
    }

    public Hobbies(Integer user_id, String hobbies_hobby, String hobbies_music, String hobbies_telecast, String hobbies_book, String hobbies_movie, String hobbies_writer, String hobbies_game, String hobbies_else, List<User> user) {
        User_id = user_id;
        Hobbies_hobby = hobbies_hobby;
        Hobbies_music = hobbies_music;
        Hobbies_telecast = hobbies_telecast;
        Hobbies_book = hobbies_book;
        Hobbies_movie = hobbies_movie;
        Hobbies_writer = hobbies_writer;
        Hobbies_game = hobbies_game;
        Hobbies_else = hobbies_else;
        this.user = user;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    public Integer getUser_id() {
        return User_id;
    }

    public void setUser_id(Integer user_id) {
        User_id = user_id;
    }

    public String getHobbies_hobby() {
        return Hobbies_hobby;
    }

    public void setHobbies_hobby(String hobbies_hobby) {
        Hobbies_hobby = hobbies_hobby;
    }

    public String getHobbies_music() {
        return Hobbies_music;
    }

    public void setHobbies_music(String hobbies_music) {
        Hobbies_music = hobbies_music;
    }

    public String getHobbies_telecast() {
        return Hobbies_telecast;
    }

    public void setHobbies_telecast(String hobbies_telecast) {
        Hobbies_telecast = hobbies_telecast;
    }

    public String getHobbies_book() {
        return Hobbies_book;
    }

    public void setHobbies_book(String hobbies_book) {
        Hobbies_book = hobbies_book;
    }

    public String getHobbies_movie() {
        return Hobbies_movie;
    }

    public void setHobbies_movie(String hobbies_movie) {
        Hobbies_movie = hobbies_movie;
    }

    public String getHobbies_writer() {
        return Hobbies_writer;
    }

    public void setHobbies_writer(String hobbies_writer) {
        Hobbies_writer = hobbies_writer;
    }

    public String getHobbies_game() {
        return Hobbies_game;
    }

    public void setHobbies_game(String hobbies_game) {
        Hobbies_game = hobbies_game;
    }

    public String getHobbies_else() {
        return Hobbies_else;
    }

    public void setHobbies_else(String hobbies_else) {
        Hobbies_else = hobbies_else;
    }

    @Override
    public String toString() {
        return "Hobbies{" +
                "User_id=" + User_id +
                ", Hobbies_hobby='" + Hobbies_hobby + '\'' +
                ", Hobbies_music='" + Hobbies_music + '\'' +
                ", Hobbies_telecast='" + Hobbies_telecast + '\'' +
                ", Hobbies_book='" + Hobbies_book + '\'' +
                ", Hobbies_movie='" + Hobbies_movie + '\'' +
                ", Hobbies_writer='" + Hobbies_writer + '\'' +
                ", Hobbies_game='" + Hobbies_game + '\'' +
                ", Hobbies_else='" + Hobbies_else + '\'' +
                ", user=" + user +
                '}';
    }
}
