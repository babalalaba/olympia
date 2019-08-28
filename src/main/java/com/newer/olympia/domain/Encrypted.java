package com.newer.olympia.domain;

import java.io.Serializable;

//密保问题表
public class Encrypted implements Serializable {
    private static final long serialVersionUID = -4053767230372168186L;
    private Integer Encrypted_id;//id
    private String Encrypted_question;//密保问题
    private String Encrypted_answer;//答案
    private Integer User_id;//用户id

    public Encrypted() {
    }

    public Encrypted(Integer encrypted_id, String encrypted_question, String encrypted_answer, Integer user_id) {
        Encrypted_id = encrypted_id;
        Encrypted_question = encrypted_question;
        Encrypted_answer = encrypted_answer;
        User_id = user_id;
    }

    public Integer getEncrypted_id() {
        return Encrypted_id;
    }

    public void setEncrypted_id(Integer encrypted_id) {
        Encrypted_id = encrypted_id;
    }

    public String getEncrypted_question() {
        return Encrypted_question;
    }

    public void setEncrypted_question(String encrypted_question) {
        Encrypted_question = encrypted_question;
    }

    public String getEncrypted_answer() {
        return Encrypted_answer;
    }

    public void setEncrypted_answer(String encrypted_answer) {
        Encrypted_answer = encrypted_answer;
    }

    public Integer getUser_id() {
        return User_id;
    }

    public void setUser_id(Integer user_id) {
        User_id = user_id;
    }
}
