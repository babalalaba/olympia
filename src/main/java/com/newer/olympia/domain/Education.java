package com.newer.olympia.domain;


import java.io.Serializable;
import java.util.Date;

//教育历史表
public class Education implements Serializable {
    private static final long serialVersionUID = -8386820846076412162L;
    private Integer Education_id;//id
    private String Education_site;//地点
    private String Education__time;//一段时间
    private String Education_describe;//描述
    private Integer User_id;//用户id


    public Education() {
    }

    public Education(Integer education_id, String education_site, String education__time, String education_describe, Integer user_id) {
        Education_id = education_id;
        Education_site = education_site;
        Education__time = education__time;
        Education_describe = education_describe;
        User_id = user_id;
    }

    public Integer getEducation_id() {
        return Education_id;
    }

    public void setEducation_id(Integer education_id) {
        Education_id = education_id;
    }

    public String getEducation_site() {
        return Education_site;
    }

    public void setEducation_site(String education_site) {
        Education_site = education_site;
    }

    public String getEducation__time() {
        return Education__time;
    }

    public void setEducation__time(String education__time) {
        Education__time = education__time;
    }

    public String getEducation_describe() {
        return Education_describe;
    }

    public void setEducation_describe(String education_describe) {
        Education_describe = education_describe;
    }

    public Integer getUser_id() {
        return User_id;
    }

    public void setUser_id(Integer user_id) {
        User_id = user_id;
    }
}
