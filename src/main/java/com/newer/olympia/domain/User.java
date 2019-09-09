package com.newer.olympia.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    private static final long serialVersionUID = -751492753941143366L;

    private Integer User_id;//id
    private String User_last_name;//姓氏
    private String User_name;//名
    private String User_email;//邮箱
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date User_birthday;//生日
    private String User_sex;//性别
    private String User_pwd;//密码
    private String User_mobile;//手机号码
    private String User_state;//国家
    private String User_img;//头像
    private String User_province;//省份
    private String User_city;//城市
    private String User_describe;//个人描述
    private String User_birthplace;//出生地
    private String User_job;//职业
    private String User_marriage;//婚姻状况
    private String User_faith;//宗教信仰
    private String User_politics;//政治倾向
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date User_time;//注册时间
    private Integer User_count;//好友访问次数
    private Integer User_authentication;//实名认证状态
    private String User_id_card;//身份证号码
    private Integer User_safety;//用户状态
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date User_login_time;//用户最后一次登录时间
    private String User_title_img;

    public User() {
    }

    public User(Integer user_id, String user_last_name, String user_name, String user_email, Date user_birthday, String user_sex, String user_pwd, String user_mobile, String user_state, String user_img, String user_province, String user_city, String user_describe, String user_birthplace, String user_job, String user_marriage, String user_faith, String user_politics, Date user_time, Integer user_count, Integer user_authentication, String user_id_card, Integer user_safety, Date user_login_time, String user_title_img) {
        User_id = user_id;
        User_last_name = user_last_name;
        User_name = user_name;
        User_email = user_email;
        User_birthday = user_birthday;
        User_sex = user_sex;
        User_pwd = user_pwd;
        User_mobile = user_mobile;
        User_state = user_state;
        User_img = user_img;
        User_province = user_province;
        User_city = user_city;
        User_describe = user_describe;
        User_birthplace = user_birthplace;
        User_job = user_job;
        User_marriage = user_marriage;
        User_faith = user_faith;
        User_politics = user_politics;
        User_time = user_time;
        User_count = user_count;
        User_authentication = user_authentication;
        User_id_card = user_id_card;
        User_safety = user_safety;
        User_login_time = user_login_time;
        User_title_img = user_title_img;
    }

    public String getUser_title_img() {
        return User_title_img;
    }

    public void setUser_title_img(String user_title_img) {
        User_title_img = user_title_img;
    }

    public Integer getUser_id() {
        return User_id;
    }

    public void setUser_id(Integer user_id) {
        User_id = user_id;
    }

    public String getUser_last_name() {
        return User_last_name;
    }

    public void setUser_last_name(String user_last_name) {
        User_last_name = user_last_name;
    }

    public String getUser_name() {
        return User_name;
    }

    public void setUser_name(String user_name) {
        User_name = user_name;
    }

    public String getUser_email() {
        return User_email;
    }

    public void setUser_email(String user_email) {
        User_email = user_email;
    }

    public Date getUser_birthday() {
        return User_birthday;
    }

    public void setUser_birthday(Date user_birthday) {
        User_birthday = user_birthday;
    }

    public String getUser_sex() {
        return User_sex;
    }

    public void setUser_sex(String user_sex) {
        User_sex = user_sex;
    }

    public String getUser_pwd() {
        return User_pwd;
    }

    public void setUser_pwd(String user_pwd) {
        User_pwd = user_pwd;
    }

    public String getUser_mobile() {
        return User_mobile;
    }

    public void setUser_mobile(String user_mobile) {
        User_mobile = user_mobile;
    }

    public String getUser_state() {
        return User_state;
    }

    public void setUser_state(String user_state) {
        User_state = user_state;
    }

    public String getUser_img() {
        return User_img;
    }

    public void setUser_img(String user_img) {
        User_img = user_img;
    }

    public String getUser_province() {
        return User_province;
    }

    public void setUser_province(String user_province) {
        User_province = user_province;
    }

    public String getUser_city() {
        return User_city;
    }

    public void setUser_city(String user_city) {
        User_city = user_city;
    }

    public String getUser_describe() {
        return User_describe;
    }

    public void setUser_describe(String user_describe) {
        User_describe = user_describe;
    }

    public String getUser_birthplace() {
        return User_birthplace;
    }

    public void setUser_birthplace(String user_birthplace) {
        User_birthplace = user_birthplace;
    }

    public String getUser_job() {
        return User_job;
    }

    public void setUser_job(String user_job) {
        User_job = user_job;
    }

    public String getUser_marriage() {
        return User_marriage;
    }

    public void setUser_marriage(String user_marriage) {
        User_marriage = user_marriage;
    }

    public String getUser_faith() {
        return User_faith;
    }

    public void setUser_faith(String user_faith) {
        User_faith = user_faith;
    }

    public String getUser_politics() {
        return User_politics;
    }

    public void setUser_politics(String user_politics) {
        User_politics = user_politics;
    }

    public Date getUser_time() {
        return User_time;
    }

    public void setUser_time(Date user_time) {
        User_time = user_time;
    }

    public Integer getUser_count() {
        return User_count;
    }

    public void setUser_count(Integer user_count) {
        User_count = user_count;
    }

    public Integer getUser_authentication() {
        return User_authentication;
    }

    public void setUser_authentication(Integer user_authentication) {
        User_authentication = user_authentication;
    }

    public String getUser_id_card() {
        return User_id_card;
    }

    public void setUser_id_card(String user_id_card) {
        User_id_card = user_id_card;
    }

    public Integer getUser_safety() {
        return User_safety;
    }

    public void setUser_safety(Integer user_safety) {
        User_safety = user_safety;
    }

    public Date getUser_login_time() {
        return User_login_time;
    }

    public void setUser_login_time(Date user_login_time) {
        User_login_time = user_login_time;
    }

    @Override
    public String toString() {
        return "User{" +
                "User_id=" + User_id +
                ", User_last_name='" + User_last_name + '\'' +
                ", User_name='" + User_name + '\'' +
                ", User_email='" + User_email + '\'' +
                ", User_birthday=" + User_birthday +
                ", User_sex='" + User_sex + '\'' +
                ", User_pwd='" + User_pwd + '\'' +
                ", User_mobile='" + User_mobile + '\'' +
                ", User_state='" + User_state + '\'' +
                ", User_img='" + User_img + '\'' +
                ", User_province='" + User_province + '\'' +
                ", User_city='" + User_city + '\'' +
                ", User_describe='" + User_describe + '\'' +
                ", User_birthplace='" + User_birthplace + '\'' +
                ", User_job='" + User_job + '\'' +
                ", User_marriage='" + User_marriage + '\'' +
                ", User_faith='" + User_faith + '\'' +
                ", User_politics='" + User_politics + '\'' +
                ", User_time=" + User_time +
                ", User_count=" + User_count +
                ", User_authentication=" + User_authentication +
                ", User_id_card='" + User_id_card + '\'' +
                ", User_safety=" + User_safety +
                ", User_login_time=" + User_login_time +
                ", User_title_img='" + User_title_img + '\'' +
                '}';
    }
}
