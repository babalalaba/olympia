package com.newer.olympia.mapper;


import com.newer.olympia.domain.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
/持久层
业务相关个人主页
负责人：佘亚杰
 */

@Mapper
@Repository
public interface ProfilePageMapper {
    //根据用户ID查询所有发布的动态
    @Select("select * from  Blogs where User_id=#{User_id}")
    public List<Blogs> selectBlogsAllByid(@Param("User_id") int User_id);

    //根据发布的动态ID查询该用户发布的动态下所有的评论
    @Select("select c.*,u.User_name Comment_user_name,u.User_img Comment_user_img from  Comment c,User u where c.User_id=#{User_id} and c.Blogs_id= #{Blogs_id} and u.User_id = c.Comment_user_id")
    public List<FriendComment> selectCommentAllByid(@Param("User_id") int User_id,@Param("Blogs_id") int Blogs_id);

    //根据用户ID和动态ID 查询该动态下的所有评论的评论数
    @Select("SELECT COUNT(Comment_id) FROM COMMENT WHERE User_id=#{User_id} and Blogs_id= #{Blogs_id}")
    public int selectCommentCount(@Param("User_id") int User_id,@Param("Blogs_id") int Blogs_id);

    //根据用户ID  查询个人描述
    @Select("select User_describe from User where User_id = #{User_id}")
    public String selectDescribe(int User_id);

    //根据用户ID 查询兴趣爱好
    @Select("select * from hobbies where User_id = #{User_id}")
    public Hobbies selectHobbies(int User_id);

    //根据用户ID 查询申请表中的所有申请添加好友的陌生人
    @Select("select * from Apply where User_id = #{User_id}")
    public List<Apply> selectApply(int User_id);

    //根据用户ID 查询用户信息
    @Select("select * from User where User_id = #{User_id}")
    public User selectUser(int User_id);



}
