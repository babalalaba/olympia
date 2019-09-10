package com.newer.olympia.mapper;


import com.newer.olympia.domain.Blogs;
import com.newer.olympia.domain.ReMap;
import com.newer.olympia.domain.User;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

//动态发布页面，负责人 戴业员
@Repository
public interface DynamicMapper {
//查询好友生日
    @Select("select u.User_last_name,u.User_name,u.User_birthday,u.User_img from user u ,friend f where f.User_id=#{User_id} " +
            "and f.Friend_user_id=u.User_id AND DATE_FORMAT(u.User_birthday,'%m-%d')=DATE_FORMAT(NOW(),'%m-%d')")
    public List<User> FindBirthday(@Param("User_id") Integer User_id);
//查询用户头像
    @Select("select User_last_name,User_name,User_img from user where User_id=#{User_id}")
    public  User FindUser(@Param("User_id") Integer User_id);


    //发布动态


    @Insert("insert into blogs(User_id,Blogs_content,Blogs_type,Blogs_img,Blogs_time,Blogs_like,Blogs_state) " +
            "values(#{User_id},#{Blogs_content},#{Blogs_type},#{Blogs_img}," +
            "now(),#{Blogs_like},#{Blogs_state} )")
    public int addDongtai(Blogs blogs);


    // 查询自己和好友的姓名 头像 动态  时间排序 blogs_id
    @Select("SELECT   DISTINCT(u.User_name),u.User_last_name,u.User_name,u.User_img,b.Blogs_id,b.Blogs_content ,b.Blogs_time " +
            "FROM USER u,friend f,blogs b WHERE  ((f.Friend_user_id=u.User_id AND " +
            "f.User_id=#{User_id}) OR u.User_id=1) AND u.User_id=b.User_id ORDER BY b.Blogs_time DESC ")
    public List<ReMap> findContent(@Param("User_id")Integer User_id);



    // 根据 blogs_id 查询所有动态评论人的名字 头像 总记录数
    @Select("SELECT  u.User_name,u.User_img,b.Blogs_like,b.Blogs_id,c.Comment_time FROM USER " +
            "u,blogs b ,COMMENT c WHERE b.Blogs_id=#{Blogs_id} AND u.User_id=c.User_id ORDER BY c.Comment_time DESC")
    public List<ReMap> findComment(@Param("Blogs_id")Integer Blogs_id);

    //查询共同好友
    public List findFriend();

    //查询共同好友的个数
    public int findCommonFriend();

}
