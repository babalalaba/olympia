package com.newer.olympia.service;

import com.newer.olympia.domain.*;

import java.util.Date;
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
}
