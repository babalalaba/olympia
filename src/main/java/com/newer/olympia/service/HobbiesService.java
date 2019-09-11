package com.newer.olympia.service;/*
 *@author  yangdu
 *@date 2019/8/28 - 14:04
 * */

import com.newer.olympia.domain.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HobbiesService {
    //查询兴趣爱好表
    public List<Hobbies> hobbiesAll(Integer User_id);
    //查询主页博客
    public List<Blogs> BlogsAll(Integer User_id);
    // 主页相册表展示
    public List<Album> AlbumAll(Integer User_id);
    //主页好友头像显示
    public List<Friend> FriendAll(Integer User_id);
    //主页勋章显示
    public List<Medal_user> MedalAll(Integer User_id);
    //好友添加
    public  Integer friend(Integer friend , Integer Apply_id);
    //查询 待添加的好友
    //查找 根据用户id查询所有好友请求，只有申请添加的id等于用户时，
    // 就显示好友请求，只有被申请的用户才可看到
    public List<Apply> findAllByUser(Integer User_id);
    //查找有这个用户。就往申请表添加数据
    public int insertApplys(Apply apply);
    //查询主页博客好友点赞
    public List<User_table> FindUtableall(Integer User_id,Integer Blogs_id);
    //点赞一次
    public int inserUtable(User_table u);
    //取消点赞
    public int delUtable(Integer User_table_id);
    //修改点赞状态
    public int updateUtable(User_table u);
    //增加一条评论
    public  int insertComment(Comment c);
    //根据用户ID和动态ID 查询该动态下的所有评论
    public List<FriendComment>  selectCommentAllByid(int Blogs_id, int pageNo,int pageNoSize);
    //查询总页数
    public int  selectTotlaPage(int Blogs_id);
    //根据用户ID查询用户所有的动态
    public List<SyjBlgos> selectBlogsAllByid();
    //查询点赞数
    public List<User_table> selectLike(int Blogs_id);
    //根据用户ID和动态ID 查询该动态下的所有评论的评论数
    public int selectCommentCount(int Blogs_id);
    //点赞时显示好友头像，取消点赞不显示好友头像
    public User_table Utablealling(Integer User_id,Integer Blogs_id);
    public List<User_table> Utablealltupian();
    //删除主页博客
    public int delBlogsing(Integer Blogs_id);
    //点赞时显示好友头像，取消点赞不显示好友头像
    public List<User_table> User_tableing(Integer Blogs_id);
    //分页发布的动态
    public List<SyjBlgos> selectBlogsAllByiding(Integer pageNo,Integer pageNoSize);
    //查询博客总页数
    public int  TotlaPage();
    //上传背景图
    public int updataUsertitle_img(String User_title_img,String User_name);
    //博客被举报，将Blogs_state状态改为2
    public int updaBlogsyd(String Blogs_season,Integer Blogs_id);
    //博客用户要驳回，将Blogs_state状态改为4
    public int updaBlogsbohui(String Blogs_season,Integer Blogs_id);
}
