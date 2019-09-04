package com.newer.olympia.service;

import com.newer.olympia.domain.*;
import com.newer.olympia.mapper.ProfilePageMapper;
import com.newer.olympia.util.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class ProfilePageServiceImpl implements ProfilePageService{
    @Autowired
    private ProfilePageMapper profilePageMapper;

    @Override
    public List<SyjBlgos> selectBlogsAllByid(int User_id) {
        return profilePageMapper.selectBlogsAllByid(User_id);
    }

    @Override
    public List<FriendComment>  selectCommentAllByid(int User_id, int Blogs_id, int pageNo) {
        return profilePageMapper.selectCommentAllByid(User_id,Blogs_id,pageNo);
    }

    @Override
    public int selectTotlaPage(int Blogs_id) {
        return profilePageMapper.selectTotlaPage( Blogs_id);
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

    @Override
    public List<User_table> selectLike(int Blogs_id) {
        return profilePageMapper.selectLike(Blogs_id);
    }

    @Override
    public int insertComment(int Comment_user_id, int Blogs_id, String Comment_content, int User_id) {
        return profilePageMapper.insertComment(Comment_user_id,Blogs_id,Comment_content,User_id);
    }

    @Override
    public int insertUser_table(int User_id, int Blogs_id) {
        return profilePageMapper.insertUser_table(User_id,Blogs_id);
    }

    @Override
    public List<Education> selectEducation(int User_id) {
        return profilePageMapper.selectEducation(User_id);
    }

    @Override
    public List<Job> selectJob(int User_id) {
        return profilePageMapper.selectJob(User_id);
    }

    @Override
    public List<Friend> selectFriend(int User_id) {
        return profilePageMapper.selectFriend(User_id);
    }

    @Override
    public int selectFriendCount(int User_id) {
        return profilePageMapper.selectFriendCount(User_id);
    }

    @Override
    public int selectPictureAmount(int User_id) {
        return profilePageMapper.selectPictureAmount(User_id);
    }

    @Override
    public int selectBlogsAmount(int User_id) {
        return profilePageMapper.selectBlogsAmount(User_id);
    }

    @Override
    public Date selectBecomeTime(int User_id, int Friend_user_id) {
        return profilePageMapper.selectBecomeTime(User_id,Friend_user_id);
    }


}
