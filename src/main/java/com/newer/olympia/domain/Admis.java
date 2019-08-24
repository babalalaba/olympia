package com.newer.olympia.domain;

import java.io.Serializable;

//管理员表
public class Admis implements Serializable {
    private static final long serialVersionUID = 2333778509323148955L;
    private Integer Admis_id;//
    private String Admis_name;//姓名
    private String Admis_username;//账号
    private String Admis_sex;//性别
    private String Admis_pwd;//密码
    private String Admis_mobile;//手机号码

    public Admis() {
    }

    public Admis(Integer admis_id, String admis_name, String admis_username, String admis_sex, String admis_pwd, String admis_mobile) {
        Admis_id = admis_id;
        Admis_name = admis_name;
        Admis_username = admis_username;
        Admis_sex = admis_sex;
        Admis_pwd = admis_pwd;
        Admis_mobile = admis_mobile;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getAdmis_id() {
        return Admis_id;
    }

    public void setAdmis_id(Integer admis_id) {
        Admis_id = admis_id;
    }

    public String getAdmis_name() {
        return Admis_name;
    }

    public void setAdmis_name(String admis_name) {
        Admis_name = admis_name;
    }

    public String getAdmis_username() {
        return Admis_username;
    }

    public void setAdmis_username(String admis_username) {
        Admis_username = admis_username;
    }

    public String getAdmis_sex() {
        return Admis_sex;
    }

    public void setAdmis_sex(String admis_sex) {
        Admis_sex = admis_sex;
    }

    public String getAdmis_pwd() {
        return Admis_pwd;
    }

    public void setAdmis_pwd(String admis_pwd) {
        Admis_pwd = admis_pwd;
    }

    public String getAdmis_mobile() {
        return Admis_mobile;
    }

    public void setAdmis_mobile(String admis_mobile) {
        Admis_mobile = admis_mobile;
    }
}
