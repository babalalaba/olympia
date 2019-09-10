package com.newer.olympia.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Inform implements Serializable {

    private static final long serialVersionUID = -6259630284807445311L;
    private Integer Inform_id;//id
    private  Integer Inform_user_id;//好友id
    private Integer User_id;//用户id
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date Inform_time;//通知时间
    private String Inform_board;//通知的内容
    private Integer Inform_state;//状态 读、未读
    private List<User> user;
    public Inform() {
    }

    public Inform(Integer inform_id, Integer inform_user_id, Integer user_id, Date inform_time, String inform_board, Integer inform_state, List<User> user) {
        Inform_id = inform_id;
        Inform_user_id = inform_user_id;
        User_id = user_id;
        Inform_time = inform_time;
        Inform_board = inform_board;
        Inform_state = inform_state;
        this.user = user;
    }

    public Date getInform_time() {
        return Inform_time;
    }

    public void setInform_time(Date inform_time) {
        Inform_time = inform_time;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }

    public Integer getInform_id() {
        return Inform_id;
    }

    public void setInform_id(Integer inform_id) {
        Inform_id = inform_id;
    }

    public Integer getInform_user_id() {
        return Inform_user_id;
    }

    public void setInform_user_id(Integer inform_user_id) {
        Inform_user_id = inform_user_id;
    }

    public Integer getUser_id() {
        return User_id;
    }

    public void setUser_id(Integer user_id) {
        User_id = user_id;
    }

    public String getInform_board() {
        return Inform_board;
    }

    public void setInform_board(String inform_board) {
        Inform_board = inform_board;
    }

    public Integer getInform_state() {
        return Inform_state;
    }

    public void setInform_state(Integer inform_state) {
        Inform_state = inform_state;
    }

    @Override
    public String toString() {
        return "Inform{" +
                "Inform_id=" + Inform_id +
                ", Inform_user_id=" + Inform_user_id +
                ", User_id=" + User_id +
                ", Inform_time=" + Inform_time +
                ", Inform_board='" + Inform_board + '\'' +
                ", Inform_state=" + Inform_state +
                ", user=" + user +
                '}';
    }
}
