package com.newer.olympia.domain;

import java.io.Serializable;

public class Friend implements Serializable {
    private static final long serialVersionUID = -7878932581150814285L;
    private Integer Friend_user_id;//好友的用户id
    private Integer User_id;//自身的id
    private  Integer Friend;//id

    public Friend() {
    }

    public Friend(Integer friend_user_id, Integer user_id, Integer friend) {
        Friend_user_id = friend_user_id;
        User_id = user_id;
        Friend = friend;
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

    public Integer getFriend() {
        return Friend;
    }

    public void setFriend(Integer friend) {
        Friend = friend;
    }
}
