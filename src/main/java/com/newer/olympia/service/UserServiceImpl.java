package com.newer.olympia.service;/*
 *@author  yangdu
 *@date 2019/8/26 - 10:33
 * */

import com.newer.olympia.domain.*;
import com.newer.olympia.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> FindUser(Integer User_id) {
        return userMapper.FindUser(User_id);
    }

    @Override
    public List<Messages> FindMessages(Integer User_id) {
        return userMapper.FindMessages(User_id);
    }

    @Override
    public int updMessagesAll(Messages m) {
        return userMapper.updMessagesAll(m);
    }

    @Override
    public int delMessagesAll(Integer Messages_id) {
        return userMapper.delMessagesAll(Messages_id);
    }

    @Override
    public List<Inform> FindBlogs(Integer User_id) {
        return userMapper.FindBlogs(User_id);
    }

    @Override
    public int deleteBlog(Integer Blogs_id) {
        return userMapper.deleteBlog(Blogs_id);
    }

    @Override
    public int updateBlog(Inform b) {
        return userMapper.updateBlog(b);
    }

    @Override
    public int allPicture(Picture p) {
        return userMapper.allPicture(p);
    }

    @Override
    public List<Picture> PictureAllBy(Integer User_id) {
        return userMapper.PictureAllBy(User_id);
    }

    @Override
    public int updUsering(String User_img, String User_name) {
        return userMapper.updUsering(User_img,User_name);
    }

    @Override
    public List<User> findUserImg(String User_name) {
        return userMapper.findUserImg(User_name);
    }


}
