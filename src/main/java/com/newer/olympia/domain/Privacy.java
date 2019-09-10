package com.newer.olympia.domain;

import java.io.Serializable;

//隐私权限表
public class Privacy implements Serializable {
    private static final long serialVersionUID = -1273047062530951580L;
    private Integer Privacy_id;//
    private Integer Privacy_describe;//隐私问题类型
    private Integer Privacy_state;//隐私状态
    private Integer User_id;//用户id

    public Privacy() {
    }

    public Privacy(Integer privacy_id, Integer privacy_describe, Integer privacy_state, Integer user_id) {
        Privacy_id = privacy_id;
        Privacy_describe = privacy_describe;
        Privacy_state = privacy_state;
        User_id = user_id;
    }

    public Integer getPrivacy_id() {
        return Privacy_id;
    }

    public void setPrivacy_id(Integer privacy_id) {
        Privacy_id = privacy_id;
    }

    public Integer getPrivacy_describe() {
        return Privacy_describe;
    }

    public void setPrivacy_describe(Integer privacy_describe) {
        Privacy_describe = privacy_describe;
    }

    public Integer getPrivacy_state() {
        return Privacy_state;
    }

    public void setPrivacy_state(Integer privacy_state) {
        Privacy_state = privacy_state;
    }

    public Integer getUser_id() {
        return User_id;
    }

    public void setUser_id(Integer user_id) {
        User_id = user_id;
    }

    @Override
    public String toString() {
        return "Privacy{" +
                "Privacy_id=" + Privacy_id +
                ", Privacy_describe=" + Privacy_describe +
                ", Privacy_state=" + Privacy_state +
                ", User_id=" + User_id +
                '}';
    }
}
