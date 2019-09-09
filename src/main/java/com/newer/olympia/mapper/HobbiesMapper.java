package com.newer.olympia.mapper;/*
 *@author  yangdu
 *@date 2019/8/28 - 14:00
 * */


import com.newer.olympia.domain.*;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface HobbiesMapper {
    //查询兴趣爱好表
    public List<Hobbies> hobbiesAll(@Param("User_id")Integer User_id);
    //查询主页博客
    public List<Blogs> BlogsAll(@Param("User_id")Integer User_id);
    // 主页相册表展示
    public List<Album> AlbumAll(@Param("User_id")Integer User_id);
    //主页好友头像显示
    public List<Friend> FriendAll(@Param("User_id")Integer User_id);
    //主页勋章显示
    public List<Medal_user> MedalAll(@Param("User_id")Integer User_id);

    //查询 操作对象
    @Select("select * from apply where apply_id = #{Apply_id}")
    public Apply findApply(Integer Apply_id);

    //不论同意或拒绝好友请求 都进行删除操作
    @Delete("delete from apply where apply_id = #{Apply_id}")
    public int deleteApply(Integer Apply_id);

    //同意添加好友时调用sql
    @Insert("insert into friend (User_id,Friend_user_id,Friend_time) values(#{User_id},#{Friend_user_id},now()) ")
    public int insertFriend(Friend friend);

    //查找 根据用户id查询所有好友请求
    public List<Apply> findAllByUser(@Param("User_id")Integer User_id);
    //查找有这个用户。就往申请表添加数据
    @Insert("insert into apply(User_id,Apply_user_id) values(#{User_id},#{Apply_user_id})")
    public int insertApplys(Apply apply);
    //查询主页博客好友点赞
    public List<User_table> FindUtableall(@Param("User_id")Integer User_id,@Param("Blogs_id")Integer Blogs_id);
    //点赞一次
    @Insert("insert into User_table(User_id,Blogs_id,Status,User_table_time) values(#{User_id},#{Blogs_id},#{Status},#{User_table_time})")
    public int inserUtable(User_table u);
    //取消点赞
    @Delete("delete from User_table where User_table_id=#{User_table_id}")
    public int delUtable(@Param("User_table_id") Integer User_table_id);
    //修改点赞状态
    @Update("update User_table set Status=#{Status} where User_table_id=#{User_table_id}")
    public int updateUtable(User_table u);
    //根据点赞查询好友头像显示
    public List<User_table> AllUtable(@Param("User_id")Integer User_id);
    //增加一条评论
    @Insert("insert into Comment(Comment_user_id,Blogs_id,Comment_content,Comment_time,User_id)" +
            "values(#{Comment_user_id},#{Blogs_id},#{Comment_content},#{Comment_time},#{User_id})")
    public  int insertComment(Comment c);
    //根据发布的动态ID查询该用户发布的动态下所有的评论
    public List<FriendComment> selectCommentAllByid(@Param("User_id") int User_id, @Param("Blogs_id") int Blogs_id, @Param("pageNo")int pageNo,@Param("pageNoSize")Integer pageNoSize);
    //查询总页数
    @Select("select count(*) from comment where Blogs_id = #{Blogs_id}")
    public int  selectTotlaPage(int Blogs_id);
    //根据用户ID查询所有发布的动态
    public List<SyjBlgos> selectBlogsAllByid();
    //查询点赞数
    @Select("select Status from User_table where Blogs_id=#{Blogs_id}")
    public List<User_table> selectLike(int Blogs_id);
    //根据用户ID和动态ID 查询该动态下的所有评论的评论数
    @Select("SELECT COUNT(Comment_id) FROM COMMENT WHERE User_id=#{User_id} and Blogs_id= #{Blogs_id}")
    public int selectCommentCount(@Param("User_id") int User_id,@Param("Blogs_id") int Blogs_id);
    //点赞时加一，取消点赞减一
    @Select("select * from User_table where  User_id=#{User_id} and Blogs_id=#{Blogs_id}")
    public User_table Utablealling(@Param("User_id")Integer User_id,@Param("Blogs_id")Integer Blogs_id);
    public List<User_table> Utablealltupian();
    //删除主页博客
    @Delete("delete from blogs where Blogs_id=#{Blogs_id}")
    public int delBlogsing(@Param("Blogs_id")Integer Blogs_id);
    //点赞时显示好友头像，取消点赞不显示好友头像
    public List<User_table> User_tableing(@Param("User_id")Integer User_id,@Param("Blogs_id")Integer Blogs_id);
    //分页发布的动态
    public List<SyjBlgos> selectBlogsAllByiding(@Param("pageNo")Integer pageNo,@Param("pageNoSize")Integer pageNoSize);
    //查询博客总页数
    @Select("select count(*) from blogs")
    public int  TotlaPage();
    //上传背景图
    @Update("update user set User_title_img=#{User_title_img} where User_name=#{User_name}")
    public int updataUsertitle_img(@Param("User_title_img")String User_title_img,@Param("User_name")String User_name);
}
