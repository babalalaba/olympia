package com.newer.olympia.service;/*
 *@author  yangdu
 *@date 2019/8/26 - 10:30
 * */

import com.newer.olympia.domain.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {
    //根据ID查询用户，并显示头像
    public List<User> FindUser(Integer User_id);
    //查询留言板
    public List<Messages> FindMessages(Integer User_id);
    //修改留言板
    public int updMessagesAll(Messages m);
    //删除留言板已读信息
    public int delMessagesAll(Integer Messages_id);
    //查询博客未读消息
    public List<Inform> FindBlogs(Integer User_id);
    //将博客已读删除
    public int deleteBlog(Integer Inform_id);
    //将未读博客信息改成已读
    public int updateBlog(Inform b);
    //Picture照片表上传
    public int allPicture(Picture p);
    //查询上传照片
    public List<Picture> PictureAllBy(Integer User_id);
    //修改头像
    public int updUsering(String User_img,String User_name);
    //查询加好友时用户更新后的信息
    public List<User> findUserImg(String User_name);

}
