package com.newer.olympia.service;

import com.newer.olympia.domain.Privacy;
import com.newer.olympia.domain.User;

import java.util.List;

//Service接口作用模块：个人中心
//创建人：易霖
public interface PersonalCenterServiceImpl {
    public User selUserByUserId(int User_id);
    public int subProByUserId(User user);
    public List<Privacy> SelPri(int User_id);
    public int UpdPri(Privacy privacy);
}
