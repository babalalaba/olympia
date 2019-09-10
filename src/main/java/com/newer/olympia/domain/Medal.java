package com.newer.olympia.domain;

import java.io.Serializable;
//勋章对象
public class Medal implements Serializable {
    private static final long serialVersionUID = 1504186841842099305L;

    private Integer Medal_id;
    private String  Medal_name;
    private String  Medal_img;

    public Medal() {
    }

    public Medal(Integer medal_id, String medal_name, String medal_img) {
        Medal_id = medal_id;
        Medal_name = medal_name;
        Medal_img = medal_img;
    }

    public Integer getMedal_id() {
        return Medal_id;
    }

    public void setMedal_id(Integer medal_id) {
        Medal_id = medal_id;
    }

    public String getMedal_name() {
        return Medal_name;
    }

    public void setMedal_name(String medal_name) {
        Medal_name = medal_name;
    }

    public String getMedal_img() {
        return Medal_img;
    }

    public void setMedal_img(String medal_img) {
        Medal_img = medal_img;
    }

    @Override
    public String toString() {
        return "Medal{" +
                "Medal_id=" + Medal_id +
                ", Medal_name='" + Medal_name + '\'' +
                ", Medal_img='" + Medal_img + '\'' +
                '}';
    }
}

