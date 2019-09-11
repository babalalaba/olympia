package com.newer.olympia.service;

import com.newer.olympia.domain.*;

import java.util.Date;
import java.util.List;

public interface ProfilePageService {
    //根据用户ID查询用户所有的动态
    public List<SyjBlgos> selectBlogsAllByid(int User_id);

    //根据发布的动态ID查询该用户发布的动态下所有的评论
    public List<Comment> selectCommentAllByid(int Blogs_id);

    //根据动态ID 查询该动态下的所有评论的评论数
    public int selectCommentCount(int Blogs_id);

    //根据用户ID  查询个人描述
    public String selectDescribe(int User_id);

    //根据用户ID 查询兴趣爱好
    public Hobbies selectHobbies(int User_id);

    //根据用户ID 查询申请表中的所有申请添加好友的陌生人
    public List<Apply> selectApply(int User_id);

    //根据用户ID 查询用户信息
    public User selectUser(int User_id);

    //查询点赞数
    public List<Integer> selectLike(int Blogs_id);

    //新增评论
    public int insertComment(int Comment_user_id,int Blogs_id,String Comment_content);

    //新增点赞
    public int insertUser_table(int User_id,int Blogs_id);

    //查询用户教育历史
    public List<Education> selectEducation(int User_id);

    //查询用户工作史
    public List<Job> selectJob(int User_id);

    //根据用户ID 查询用户好友
    public List<Friend> selectFriend(int User_id);

    //查询好友数
    public int selectFriendCount(int User_id);

    //计算上传的相片数量
    public int selectPictureAmount (int User_id);

    //查询用户博客发布数量
    public int selectBlogsAmount (int User_id);

    //查询用户成为自己好友的时间
    public Date selectBecomeTime (int User_id , int Friend_user_id);

    //根据用户名查询用户
    public List<Friend> selectUserByName(int User_id ,String User_name);

    //查询好友数
    public int selectFriendCountByName(int User_id,String User_name);

    //删除好友
    public int deleteFriend(int User_id,int Friend_user_id);

    //查询相册名为否存在
    public Album selectAlbum(String Album_name,int User_id);

    //新增相册
    public int insertAlbum(String Album_name,int Picture_id,int User_id,String Album_describe);

    //根据ID查询照片
    public Picture selectPictureByPath(String Picture_path,int User_id);

    //新增照片
    public int insertpicture(String Picture_path,int User_id,String Album_name);

    //根据相册里面查询有多少张相片
    public int selectPictureCount(String Album_name);

    //查询相册评论数量
    public int selectAlbum_commentCount(int Album_id);

    //根据用户ID查询所有相册
    public List<Album> selectAlbumAll(int User_id);

    //查询相册数量
    public int selectAlbumCount(int User_id);

    //根据照片ID查询照片路径
    public String selectPicture_pathById(int Picture_id);

    //根据相册名以及用户ID 查询所有照片
    public List<Picture>  selectPicture(String Album_name,int User_id);

    //根据ID查询  封面照片
    public Picture selectPictureById(int Picture_id);

    //根据相册ID 查询所有评论
    public List<Album_comment> selectAlbum_comment(int Album_id);

    //根据相册ID 查询评论数量
    public int selectAlbum_comment_count(int Album_id);

    //新增相册点赞
    public int insertAlbum_dianzan(int User_id,int Album_id);

    //查询用户是否已经点赞
    public User_table shifoudianzan(int User_id,int Album_id);

    //删除用户点赞
    public int shanchudianzan(int User_id,int Album_id);

    //查询相册点赞数
    public List<Integer> xiangcedianzanshu(int Album_id);

    //查询点赞人ID 来查询到点赞人头像
    public List<Integer> dianzanrentuo(int Album_id);

    //删除 相册
    public int deleteAlbum(String Album_name,int User_id);

    //删除 照片表数据
    public int deletePicture(String Album_name,int User_id);

    //删除 照片评论表
    public int deleteAlbum_comment(int Album_id,int User_id);

    //添加相册评论
    public int insertAlbum_comment(int Comment_user_id,int Album_id,String Comment_content);

    //根据照片ID 删除单个照片
    public int deletePictureById(int Picture_id);

    //查询所有博客文章
    public List<Blogs> selectBoKe(int User_id);

    //查询所有博客文章数量
    public int selectBoKeCount(int User_id);

    //查询 点赞人ID来查询到点赞人头像
    public List<Integer> dianzanrentuo2(int Blogs_id);

    //查询用户是否已经点赞博客（）
    public User_table shifoudianzan2(int User_id, int Blogs_id);

    //删除用户博客点赞
    public int shanchudianzan2(int User_id,int Blogs_id);

    //删除博客文章
    public int deleteBoKe(int Blogs_id);

    //删除博客时删除博客评论
    public int deleteBoKe1(int Blogs_id);

    //删除博客时删除博客点赞
    public int deleteBoKe2(int Blogs_id);

    //博客点赞新增通知
    public int insertInform(int Inform_user_id,int User_id,String Inform_board);

    //查询隐私权限
    public List<Privacy> selectPrivacy(int User_id);

    //查询我的所有好友
    public List<Integer> selectFriendAll(int User_id);

    //查询单个博客
    public Blogs selectBlog(int Blogs_id);

    //删除通知
    public int deleteInform(String Inform_board);

    //修改博客状态
    public int updJubao(String Blogs_season,int Blogs_id);

    //好友查看的动态
    public List<SyjBlgos> selectBlogsAllByid1(int User_id);

    //修改博客状态 (反馈)
    public int fankui(String Blogs_season,int Blogs_id);
}
