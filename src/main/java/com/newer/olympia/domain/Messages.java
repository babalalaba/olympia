package com.newer.olympia.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Messages implements Serializable {
    private static final long serialVersionUID = 4747015961361625261L;
    private Integer Messages_id;//id
    private Integer Messages_user_id;//好友id
    private Integer User_id;//用户id
    private String Message_board;//留言内容
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date Message_time;//留言时间
    private Integer Message_state;//状态

    public Messages() {
    }

    public Messages(Integer messages_id, Integer messages_user_id, Integer user_id, String message_board, Date message_time, Integer message_state) {
        Messages_id = messages_id;
        Messages_user_id = messages_user_id;
        User_id = user_id;
        Message_board = message_board;
        Message_time = message_time;
        Message_state = message_state;
    }

    public Integer getMessages_id() {
        return Messages_id;
    }

    public void setMessages_id(Integer messages_id) {
        Messages_id = messages_id;
    }

    public Integer getMessages_user_id() {
        return Messages_user_id;
    }

    public void setMessages_user_id(Integer messages_user_id) {
        Messages_user_id = messages_user_id;
    }

    public Integer getUser_id() {
        return User_id;
    }

    public void setUser_id(Integer user_id) {
        User_id = user_id;
    }

    public String getMessage_board() {
        return Message_board;
    }

    public void setMessage_board(String message_board) {
        Message_board = message_board;
    }

    public Date getMessage_time() {
        return Message_time;
    }

    public void setMessage_time(Date message_time) {
        Message_time = message_time;
    }

    public Integer getMessage_state() {
        return Message_state;
    }

    public void setMessage_state(Integer message_state) {
        Message_state = message_state;
    }
}
