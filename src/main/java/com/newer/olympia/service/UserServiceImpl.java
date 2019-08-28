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
    public List<User> FindUser() {
        return userMapper.FindUser();
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
    public List<Picture> allPicture(Integer User_id) {
        return userMapper.allPicture(User_id);
    }
}
