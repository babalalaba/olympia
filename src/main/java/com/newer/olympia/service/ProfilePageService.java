package com.newer.olympia.service;

import com.newer.olympia.domain.*;
import com.newer.olympia.util.Pager;

import java.util.List;

public interface ProfilePageService {
    //根据用户ID查询用户所有的动态
    public List<SyjBlgos> selectBlogsAllByid(int User_id);

    //根据用户ID和动态ID 查询该动态下的所有评论
    public List<FriendComment>  selectCommentAllByid(int User_id, int Blogs_id, int pageNo);

    //查询总页数
    public int  selectTotlaPage(int Blogs_id);

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

    //查询点赞数
    public List<User_table> selectLike(int Blogs_id);

    //新增评论
    public int insertComment(int Comment_user_id,int Blogs_id,String Comment_content,int User_id);

    //新增点赞
    public int insertUser_table(int User_id,int Blogs_id);
}
