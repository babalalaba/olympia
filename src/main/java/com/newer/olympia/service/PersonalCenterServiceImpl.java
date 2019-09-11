package com.newer.olympia.service;

import com.newer.olympia.domain.*;

import java.util.List;

//Service接口作用模块：个人中心
//创建人：易霖
public interface PersonalCenterServiceImpl {
    public User selUserByUserId(int User_id);
    public int subProByUserId(User user);
    //更新用户密码
    public int upPwdByUserId(int User_id,String pwd);
    public List<Privacy> SelPri(int User_id);
    public int UpdPri(Privacy privacy);
    //查询密保问题
    public List<Encrypted> selEncQueByUserId(int User_id);
    //查询密保答案
    public List<Encrypted> selEncAnsByUserId(int User_id);
    //根据密保id查询密保信息
    public Encrypted selEncQueByENCId(int Encrypted_id);
    //更新密保
    public int updEncrypted(Encrypted encrypted);
    //设置密保
    public int insEncrypted(Encrypted encrypted);
    //更新密保手机
    public int upChecodeByUserId(int User_id,String User_mobile);
    //查询用户兴趣爱好
    public Hobbies selHobbies(int User_id);
    //保存用户爱好
    public int subHobbies(Hobbies hobbies);
    //更新用户爱好
    public int updHobbies(Hobbies hobbies);
    //查询教育经历
    public List<Education> selEdu(int User_id);
    //查询用户工作经历
    public List<Job> selEmp(int User_id);
    //保存教育
    public int subEdu(Education education);
    //更新用户教育信息
    public int updEdu(Education education);
    //保存工作信息
    public int subJob(Job job);
    //更新用户工作信息
    public int updJob(Job job);
}
