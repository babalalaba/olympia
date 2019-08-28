package com.newer.olympia.service;

import com.newer.olympia.domain.Encrypted;
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
    //查询密保问题
    public List<Encrypted> selEncQueByUserId(int User_id);
    //查询密保答案
    public List<Encrypted> selEncAnsByUserId(int User_id);
    //更新密保
    public int updEncrypted(Encrypted encrypted);
}
