package com.newer.olympia.service;

import com.newer.olympia.domain.*;
import com.newer.olympia.mapper.ProfilePageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProfilePageServiceImpl implements ProfilePageService{
    @Autowired
    private ProfilePageMapper profilePageMapper;

    @Override
    public List<Blogs> selectBlogsAllByid(int User_id) {
        return profilePageMapper.selectBlogsAllByid(User_id);
    }

    @Override
    public List<Comment> selectCommentAllByid(int User_id,int Blogs_id) {
        return profilePageMapper.selectCommentAllByid(User_id,Blogs_id);
    }

    @Override
    public int selectCommentCount(int User_id, int Blogs_id) {
        return profilePageMapper.selectCommentCount(User_id,Blogs_id);
    }

    @Override
    public String selectDescribe(int User_id) {
        return profilePageMapper.selectDescribe(User_id);
    }

    @Override
    public Hobbies selectHobbies(int User_id) {
        return profilePageMapper.selectHobbies(User_id);
    }

    @Override
    public List<Apply> selectApply(int User_id) {
        return profilePageMapper.selectApply(User_id);
    }

    @Override
    public User selectUser(int User_id) {
        return profilePageMapper.selectUser(User_id);
    }
}
