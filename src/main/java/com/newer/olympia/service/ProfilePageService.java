package com.newer.olympia.service;

import com.newer.olympia.domain.*;

import java.util.List;

public interface ProfilePageService {
    //根据用户ID查询用户所有的动态
    public List<Blogs> selectBlogsAllByid(int User_id);

    //根据用户ID和动态ID 查询该动态下的所有评论
    public List<FriendComment> selectCommentAllByid(int User_id,int Blogs_id);

    //根据用户ID和动态ID 查询该动态下的所有评论的评论数
    public int selectCommentCount(int User_id,int Blogs_id);

    //根据用户ID  查询个人描述
    public String selectDescribe(int User_id);

    //根据用户ID 查询兴趣爱好
    public Hobbies selectHobbies(int User_id);

    //根据用户ID 查询申请表中的所有申请添加好友的陌生人
    public List<Apply> selectApply(int User_id);

    //根据用户ID 查询用户信息
    public User selectUser(int User_id);


}
