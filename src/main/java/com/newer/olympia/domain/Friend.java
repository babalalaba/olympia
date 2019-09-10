package com.newer.olympia.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Friend implements Serializable {
    private static final long serialVersionUID = -7878932581150814285L;
    private Integer Friend_user_id;//好友的用户id
    private Integer User_id;//自身的id
    private  Integer Friend_id;//id
    private Date Friend_time;

    public Date getFriend_time() {
        return Friend_time;
    }

    public void setFriend_time(Date friend_time) {
        Friend_time = friend_time;
    }

    public Friend(Integer friend_user_id, Integer user_id, Integer friend_id, Date friend_time, List<User> user) {
        Friend_user_id = friend_user_id;
        User_id = user_id;
        Friend_id = friend_id;
        Friend_time = friend_time;
        this.user = user;
    }

    private List<User> user;
    public Friend() {
    }

    public Friend(Integer friend_user_id, Integer user_id, Integer friend_id, List<User> user) {
        Friend_user_id = friend_user_id;
        User_id = user_id;
        Friend_id = friend_id;
        this.user = user;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    public Integer getFriend_user_id() {
        return Friend_user_id;
    }

    public void setFriend_user_id(Integer friend_user_id) {
        Friend_user_id = friend_user_id;
    }

    public Integer getUser_id() {
        return User_id;
    }

    public void setUser_id(Integer user_id) {
        User_id = user_id;
    }

    public Integer getFriend_id() {
        return Friend_id;
    }

    public void setFriend_id(Integer friend_id) {
        Friend_id = friend_id;
    }

    @Override
    public String toString() {
        return "Friend{" +
                "Friend_user_id=" + Friend_user_id +
                ", User_id=" + User_id +
                ", Friend_id=" + Friend_id +
                ", Friend_time=" + Friend_time +
                ", user=" + user +
                '}';
    }
}
