package com.newer.olympia.mapper;


import com.newer.olympia.domain.*;
import org.apache.ibatis.annotations.*;
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
    @Select("select * from  Blogs where User_id=#{User_id} and Blogs_type=1 ")
    public List<SyjBlgos> selectBlogsAllByid(@Param("User_id") int User_id);

    //好友查看的动态
    @Select("select * from  Blogs where User_id=#{User_id} and Blogs_type=1 and Blogs_state = 1 or Blogs_state = 2")
    public List<SyjBlgos> selectBlogsAllByid1(@Param("User_id") int User_id);


    //根据发布的动态ID查询该用户发布的动态下所有的评论
    @Select("select * from Comment where Blogs_id= #{Blogs_id}")
    public List<Comment> selectCommentAllByid(int Blogs_id);

    //根据动态ID 查询该动态下的所有评论的评论数
    @Select("SELECT COUNT(Comment_id) FROM COMMENT WHERE Blogs_id= #{Blogs_id}")
    public int selectCommentCount(@Param("Blogs_id") int Blogs_id);

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

    //查询点赞数
    @Select("select Status from User_table where Blogs_id=#{Blogs_id}")
    public List<Integer> selectLike(int Blogs_id);

    //新增评论
    @Insert("insert into Comment value(null,#{Comment_user_id},#{Blogs_id},#{Comment_content},now(),null)")
    public int insertComment(int Comment_user_id,int Blogs_id,String Comment_content);

    //新增点赞
    @Insert("insert into User_table value(null,#{User_id},#{Blogs_id},1,now(),null)")
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

    //根据用户名查询用户
    @Select("select f.* from friend f,User u where  f.User_id = #{User_id} and Friend_user_id = u.User_id and u.User_name like '${User_name}%'")
    public List<Friend> selectUserByName(int User_id ,String User_name);

    //查询好友数
    @Select("SELECT COUNT(f.`Friend_id`) FROM friend f,USER u WHERE f.`User_id` = ${User_id} AND f.`Friend_user_id` = u.`User_id` AND u.`User_name` LIKE '${User_name}%';")
    public int selectFriendCountByName(int User_id,String User_name);

    //删除好友
    @Delete("delete from Friend where User_id = #{User_id} and Friend_user_id = #{Friend_user_id}")
    public int deleteFriend(int User_id,int Friend_user_id);

    //查询相册名为否存在
    @Select("select * from album where Album_name = #{Album_name} and User_id = #{User_id}")
    public Album selectAlbum(String Album_name,int User_id);

    //新增相册
    @Insert("insert into album value (null,#{Album_name},#{Picture_id},#{User_id},#{Album_describe},0,now())")
    public int insertAlbum(String Album_name,int Picture_id,int User_id,String Album_describe);

    //新增照片
    @Insert("insert into picture value(null,#{Picture_path},#{User_id},#{Album_name})")
    public int insertpicture(String Picture_path,int User_id,String Album_name);

    //根据路径查询照片
    @Select("select * from picture where Picture_path = #{Picture_path} and User_id = #{User_id}")
    public Picture selectPictureByPath(String Picture_path,int User_id);

    //根据用户ID查询所有相册
    @Select("select * from album where User_id = #{User_id}")
    public List<Album> selectAlbumAll(int User_id);

    //根据相册里面查询有多少张相片
    @Select("select count(*) from picture where Album_name = #{Album_name}")
    public int selectPictureCount(String Album_name);

    //查询相册评论数量
    @Select("select count(Comment_id) from album_comment where Album_id = #{Album_id}")
    public int selectAlbum_commentCount(int Album_id);

    //查询相册数量
    @Select("select count(Album_id) from album where User_id = #{User_id}")
    public int selectAlbumCount(int User_id);

    //根据照片ID查询照片路径
    @Select("select Picture_path from picture where  Picture_id = #{Picture_id}")
    public String selectPicture_pathById(int Picture_id);

    //根据相册名以及用户ID 查询所有照片
    @Select("select * from picture where  Album_name = #{Album_name} and User_id = #{User_id}")
    public List<Picture> selectPicture(String Album_name,int User_id);

    //根据ID查询  封面照片
    @Select("select * from picture where Picture_id = #{Picture_id}")
    public Picture selectPictureById(int Picture_id);

    //根据相册ID 查询所有评论
    @Select("select * from album_comment where Album_id = #{Album_id}")
    public List<Album_comment> selectAlbum_comment(int Album_id);

    //根据相册ID 查询评论数量
    @Select("select count(Comment_id) from album_comment where Album_id = #{Album_id}")
    public int selectAlbum_comment_count(int Album_id);

    //新增相册点赞
    @Insert("insert into user_table value(null,#{User_id},null,1,now(),#{Album_id})")
    public int insertAlbum_dianzan(int User_id,int Album_id);

    //查询用户是否已经点赞相册
    @Select("select * from user_table where User_id = #{User_id} and Album_id = #{Album_id}")
    public User_table shifoudianzan(int User_id,int Album_id);

    //删除用户相册点赞
    @Delete("delete from user_table where User_id = #{User_id} and Album_id = #{Album_id}")
    public int shanchudianzan(int User_id,int Album_id);

    //查询相册点赞数
    @Select("select Status from user_table where Album_id = #{Album_id}")
    public List<Integer> xiangcedianzanshu(int Album_id);

    //查询 点赞人ID来查询到点赞人头像（相册）
    @Select("select User_id from user_table where Album_id = #{Album_id}")
    public List<Integer> dianzanrentuo(int Album_id);

    //删除 相册
    @Delete("delete from album where Album_name = #{Album_name} and User_id = #{User_id}")
    public int deleteAlbum(String Album_name,int User_id);

    //删除 照片表数据
    @Delete("delete from Picture where Album_name = #{Album_name} and User_id = #{User_id}")
    public int deletePicture(String Album_name,int User_id);

    //删除 照片评论表
    @Delete("delete from album_comment where Album_id=#{Album_id} and User_id = #{User_id}")
    public int deleteAlbum_comment(int Album_id,int User_id);

    //添加相册评论
    @Insert("insert into album_comment value (null,#{Comment_user_id},#{Album_id},#{Comment_content},now(),null)")
    public int insertAlbum_comment(int Comment_user_id,int Album_id,String Comment_content);

    //根据照片ID 删除单个照片
    @Delete("delete from Picture where Picture_id = #{Picture_id}")
    public int deletePictureById(int Picture_id);

    //查询所有博客文章
    @Select("select *  from blogs where User_id = #{User_id} and Blogs_type = 2")
    public List<Blogs> selectBoKe(int User_id);

    //查询所有博客文章数量
    @Select("select count(Blogs_id) from blogs where User_id = #{User_id} and Blogs_type = 2")
    public int selectBoKeCount(int User_id);

    //查询 点赞人ID来查询到点赞人头像(博客)
    @Select("select User_id from user_table where Blogs_id = #{Blogs_id}")
    public List<Integer> dianzanrentuo2(int Blogs_id);

    //查询用户是否已经点赞博客（）
    @Select("select * from user_table where User_id = #{User_id} and Blogs_id = #{Blogs_id}")
    public User_table shifoudianzan2(int User_id,int Blogs_id);

    //删除用户博客点赞
    @Delete("delete from user_table where User_id = #{User_id} and Blogs_id = #{Blogs_id}")
    public int shanchudianzan2(int User_id,int Blogs_id);

    //删除博客文章
    @Delete("delete from blogs where Blogs_id = #{Blogs_id}")
    public int deleteBoKe(int Blogs_id);

    //删除博客时删除博客评论
    @Delete("delete from COMMENT where Blogs_id = #{Blogs_id}")
    public int deleteBoKe1(int Blogs_id);

    //删除博客时删除博客点赞
    @Delete("delete from user_table where Blogs_id = #{Blogs_id}")
    public int deleteBoKe2(int Blogs_id);

    //博客点赞新增通知
    @Insert("insert into inform value(null,#{Inform_user_id},#{User_id},now(),#{Inform_board},0)")
    public int insertInform(int Inform_user_id,int User_id,String Inform_board);

    //查询隐私权限
    @Select("select * from Privacy where User_id = #{User_id}")
    public List<Privacy> selectPrivacy(int User_id);

    //查询我的所有好友
    @Select("select Friend_user_id from friend where User_id = #{User_id}")
    public List<Integer> selectFriendAll(int User_id);

    //查询单个博客
    @Select("select * from Blogs where Blogs_id = #{Blogs_id}")
    public Blogs selectBlog(int Blogs_id);

    //删除通知
    @Delete("delete from inform where Inform_board = #{Inform_board}")
    public int deleteInform(String Inform_board);

    //修改博客状态 (举报)
    @Update("update Blogs set Blogs_state = 2 , Blogs_season = #{Blogs_season} where Blogs_id = #{Blogs_id}")
    public int updJubao(String Blogs_season,int Blogs_id);

    //修改博客状态 (反馈)
    @Update("update Blogs set Blogs_state = 4 , Blogs_season = #{Blogs_season} where Blogs_id = #{Blogs_id}")
    public int fankui(String Blogs_season,int Blogs_id);


}
