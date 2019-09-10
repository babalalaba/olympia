package com.newer.olympia.domain;

import java.io.Serializable;
import java.util.List;

//用户勋章  对象
public class Medal_user implements Serializable {
    private static final long serialVersionUID = -1927375953095853142L;

    private  Integer Medal_user_id;
    private  Integer User_id;
    private  Integer Medal_id;
    private List<User> user;
    private List<Medal> medal;
    public Medal_user() {
    }

    public Medal_user(Integer medal_user_id, Integer user_id, Integer medal_id, List<User> user, List<Medal> medal) {
        Medal_user_id = medal_user_id;
        User_id = user_id;
        Medal_id = medal_id;
        this.user = user;
        this.medal = medal;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    public List<Medal> getMedal() {
        return medal;
    }

    public void setMedal(List<Medal> medal) {
        this.medal = medal;
    }

    public Integer getMedal_user_id() {
        return Medal_user_id;
    }

    public void setMedal_user_id(Integer medal_user_id) {
        Medal_user_id = medal_user_id;
    }

    public Integer getUser_id() {
        return User_id;
    }

    public void setUser_id(Integer user_id) {
        User_id = user_id;
    }

    public Integer getMedal_id() {
        return Medal_id;
    }

    public void setMedal_id(Integer medal_id) {
        Medal_id = medal_id;
    }

    @Override
    public String toString() {
        return "Medal_user{" +
                "Medal_user_id=" + Medal_user_id +
                ", User_id=" + User_id +
                ", Medal_id=" + Medal_id +
                ", user=" + user +
                ", medal=" + medal +
                '}';
    }
}

