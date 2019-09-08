package com.newer.olympia.domain;

import java.io.Serializable;
import java.util.List;

public class Apply implements Serializable {
    private static final long serialVersionUID = -8782680920151300260L;
    private Integer Apply_id;
    private Integer User_id;
    private Integer Apply_user_id;
    private List<User> user;
    public Apply() {
    }

    public Apply(Integer apply_id, Integer user_id, Integer apply_user_id, List<User> user) {
        Apply_id = apply_id;
        User_id = user_id;
        Apply_user_id = apply_user_id;
        this.user = user;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    public Integer getApply_id() {
        return Apply_id;
    }

    public void setApply_id(Integer apply_id) {
        Apply_id = apply_id;
    }

    public Integer getUser_id() {
        return User_id;
    }

    public void setUser_id(Integer user_id) {
        User_id = user_id;
    }

    public Integer getApply_user_id() {
        return Apply_user_id;
    }

    public void setApply_user_id(Integer apply_user_id) {
        Apply_user_id = apply_user_id;
    }

    @Override
    public String toString() {
        return "Apply{" +
                "Apply_id=" + Apply_id +
                ", User_id=" + User_id +
                ", Apply_user_id=" + Apply_user_id +
                ", user=" + user +
                '}';
    }
}
