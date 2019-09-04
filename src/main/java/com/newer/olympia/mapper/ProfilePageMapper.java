package com.newer.olympia.mapper;


import com.newer.olympia.domain.*;
import com.newer.olympia.util.Pager;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Date;
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
    @Select("select * from  Blogs where User_id=#{User_id} and Blogs_type=1")
    public List<SyjBlgos> selectBlogsAllByid(@Param("User_id") int User_id);

    //根据发布的动态ID查询该用户发布的动态下所有的评论
    public List<FriendComment> selectCommentAllByid(@Param("User_id") int User_id, @Param("Blogs_id") int Blogs_id, @Param("pageNo")int pageNo);

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


    //查询总页数
    @Select("select count(*) from comment where Blogs_id = #{Blogs_id}")
    public int  selectTotlaPage(int Blogs_id);

    //查询点赞数
    @Select("select Status from User_table where Blogs_id=#{Blogs_id}")
    public List<User_table> selectLike(int Blogs_id);

    //新增评论
    @Insert("insert into Comment value(null,#{Comment_user_id},#{Blogs_id},#{Comment_content},now(),#{User_id})")
    public int insertComment(int Comment_user_id,int Blogs_id,String Comment_content,int User_id);

    //新增点赞
    @Insert("insert into User_table value(null,#{User_id},#{Blogs_id},1,now())")
    public int insertUser_table(int User_id,int Blogs_id);

    //查询用户教育历史
    @Select("select * from Education where User_id = #{User_id}")
    public List<Education> selectEducation(int User_id);

    //查询用户工作史
    @Select("select * from Job where User_id =#{User_id}")
    public List<Job> selectJob(int User_id);

    //根据用户ID 查询用户好友
    @Select("select * from Friend where User_id = #{User_id}")
    public List<Friend> selectFriend(int User_id);

    //查询好友数
    @Select("select count(*) from Friend where User_id=#{User_id}")
    public int selectFriendCount(int User_id);

    //查询上传的相片数量
    @Select("select count(*) from picture where User_id = #{User_id}")
    public int selectPictureAmount (int User_id);

    //查询用户博客发布数量
    @Select("select count(*) from Blogs where User_id = #{User_id} and Blogs_type = 2")
    public int selectBlogsAmount (int User_id);

    //查询用户成为自己好友的时间
    @Select("select Friend_time from Friend where User_id = #{User_id} and Friend_user_id = #{Friend_user_id}")
    public Date selectBecomeTime (int User_id ,int Friend_user_id);
}
