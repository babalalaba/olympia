package com.newer.olympia.domain;



import java.io.Serializable;
import java.util.Date;

//员工历史表
public class Job implements Serializable {
    private static final long serialVersionUID = -291095327515335018L;
    private Integer Job_id;//id
    private String Job_site;//地点
    private String Job_time;//一段时间
    private String Job_describe;//描述
    private Integer User_id;//用户id

    public Job() {
    }

    public Job(Integer job_id, String job_site, String job_time, String job_describe, Integer user_id) {
        Job_id = job_id;
        Job_site = job_site;
        Job_time = job_time;
        Job_describe = job_describe;
        User_id = user_id;
    }

    public Integer getJob_id() {
        return Job_id;
    }

    public void setJob_id(Integer job_id) {
        Job_id = job_id;
    }

    public String getJob_site() {
        return Job_site;
    }

    public void setJob_site(String job_site) {
        Job_site = job_site;
    }

    public String getJob_time() {
        return Job_time;
    }

    public void setJob_time(String job_time) {
        Job_time = job_time;
    }

    public String getJob_describe() {
        return Job_describe;
    }

    public void setJob_describe(String job_describe) {
        Job_describe = job_describe;
    }

    public Integer getUser_id() {
        return User_id;
    }

    public void setUser_id(Integer user_id) {
        User_id = user_id;
    }
}
