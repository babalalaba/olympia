package com.newer.olympia.mapper;

import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    //查询用户，并显示头像
    @Select("select * from User")
    public List<User> FindUser();
    //查询留言板
    public List<Messages> FindMessages(@Param("User_id")Integer User_id);
    //将未读留言信息改成已读
    @Update("update Messages set Message_state=#{Message_state} where Messages_id=#{Messages_id}")
    public int updMessagesAll(Messages m);
    //删除留言板已读信息
    @Delete("delete from Messages where Messages_id=#{Messages_id}")
    public int delMessagesAll(@Param("Messages_id")Integer Messages_id);

    //查询通知表评论
    //public List<Blogs> FindBlogs(@Param("User_id")Integer User_id);
    public List<Inform> FindBlogs(@Param("User_id")Integer User_id);
    //将博客已读删除
    @Delete("delete from Inform where Inform_id=#{Inform_id}")
    public int deleteBlog(@Param("Inform_id")Integer Inform_id);
    //将未读博客信息改成已读
    @Update("update Inform set Inform_state=#{Inform_state} where Inform_id=#{Inform_id}")
    public int updateBlog(Inform b);
    //Picture照片表上传
    public List<Picture> allPicture(@Param("User_id")Integer User_id);
}
