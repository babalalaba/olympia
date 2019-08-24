package com.newer.olympia.domain;

import java.io.Serializable;

public class Inform implements Serializable {

    private static final long serialVersionUID = -6259630284807445311L;
    private Integer Inform_id;//id
    private  Integer Inform_user_id;//好友id
    private Integer User_id;//用户id
    private String Inform_board;//通知的内容
    private Integer Inform_state;//状态 读、未读

    public Inform() {
    }

    public Inform(Integer inform_id, Integer inform_user_id, Integer user_id, String inform_board, Integer inform_state) {
        Inform_id = inform_id;
        Inform_user_id = inform_user_id;
        User_id = user_id;
        Inform_board = inform_board;
        Inform_state = inform_state;
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
}
