package com.newer.olympia.mapper;
import com.newer.olympia.domain.Inform;
import com.newer.olympia.domain.Messages;
import com.newer.olympia.domain.Picture;
import com.newer.olympia.domain.User;
import org.apache.ibatis.annotations.*;

import com.newer.olympia.domain.Inform;
import com.newer.olympia.domain.Messages;
import com.newer.olympia.domain.Picture;
import com.newer.olympia.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    //根据ID查询用户，并显示头像
    @Select("select * from User where user_id=#{User_id}")
    public List<User> FindUser(@Param("User_id")Integer User_id);
    //查询留言板
    public List<Messages> FindMessages(@Param("User_id")Integer User_id);
    //将未读留言信息改成已读
    @Update("update Messages set Message_state=#{Message_state} where Messages_id=#{Messages_id}")
    public int updMessagesAll(Messages m);
    //删除留言板已读信息
    @Delete("delete from Messages where Messages_id=#{Messages_id}")
    public int delMessagesAll(@Param("Messages_id")Integer Messages_id);

    //查询通知表评论
    public List<Inform> FindBlogs(@Param("User_id")Integer User_id);
    //将博客已读删除
    @Delete("delete from Inform where Inform_id=#{Inform_id}")
    public int deleteBlog(@Param("Inform_id")Integer Inform_id);
    //将未读博客信息改成已读
    @Update("update Inform set Inform_state=#{Inform_state} where Inform_id=#{Inform_id}")
    public int updateBlog(Inform b);
    //Picture照片表上传
    @Insert("insert into Picture(Picture_path,User_id) values(#{Picture_path},#{User_id})")
    @SelectKey(statement = "select last_insert_id()" ,keyProperty = "Picture_id",resultType = Integer.class,before = false)
    public int allPicture(Picture p);
    //查询上传照片
    public List<Picture> PictureAllBy(@Param("User_id")Integer User_id);
    //修改头像
    @Update("update user set User_img=#{User_img} where User_name=#{User_name}")
    public int updUsering(@Param("User_img")String User_img,@Param("User_name")String User_name);

    /**
     *  查询 用户更新后的信息
     * @param User_id  用户id
     * @return 根据用户中的User_img    id 关联的 图片库中的id字段匹配的图片
     */
    //@Select("select t.Picture_path  User_img,u.User_id,u.User_authentication ,u.User_birthday ,u.User_birthplace ,u.User_city ,u.User_count ,u.User_describe ,u.User_email ,u.User_faith ,u.User_id_card ,u.User_job ,u. User_last_name ,u. User_login_time ,u. User_marriage ,u. User_mobile ,u. User_name ,u. User_politics , u. User_province ,u. User_safety , u. User_sex , u. User_state , u. User_time,u.User_title_img  from user u left join picture t on u.User_img = t.picture_id where u.User_name = #{User_name}")
    @Select("select * from User where User_name=#{User_name}")
    public List<User> findUserImg(@Param("User_name")String User_name);

}
