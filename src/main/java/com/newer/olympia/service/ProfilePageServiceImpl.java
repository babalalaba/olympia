package com.newer.olympia.service;

import com.newer.olympia.domain.*;
import com.newer.olympia.mapper.ProfilePageMapper;
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

    @Override
    public List<Friend> selectUserByName(int User_id,String User_name) {
        return profilePageMapper.selectUserByName(User_id,User_name);
    }

    @Override
    public int selectFriendCountByName(int User_id, String User_name) {
        return profilePageMapper.selectFriendCountByName(User_id,User_name);
    }

    @Override
    public int deleteFriend(int User_id, int Friend_user_id) {
        return profilePageMapper.deleteFriend(User_id,Friend_user_id);
    }

    @Override
    public Album selectAlbum(String Album_name,int User_id) {
        return profilePageMapper.selectAlbum(Album_name,User_id);
    }

    @Override
    public int insertAlbum(String Album_name, int Picture_id, int User_id, String Album_describe) {
        return profilePageMapper.insertAlbum(Album_name,Picture_id,User_id,Album_describe);
    }

    @Override
    public Picture selectPictureByPath(String Picture_path, int User_id) {
        return profilePageMapper.selectPictureByPath(Picture_path,User_id);
    }

    @Override
    public int insertpicture(String Picture_path, int User_id,String Album_name) {
        return profilePageMapper.insertpicture(Picture_path,User_id,Album_name);
    }

    @Override
    public int selectPictureCount(String Album_name) {
        return profilePageMapper.selectPictureCount(Album_name);
    }

    @Override
    public int selectAlbum_commentCount(int Album_id) {
        return profilePageMapper.selectAlbum_commentCount(Album_id);
    }


    @Override
    public List<Album> selectAlbumAll(int User_id) {
        return profilePageMapper.selectAlbumAll(User_id);
    }

    @Override
    public int selectAlbumCount(int User_id) {
        return profilePageMapper.selectAlbumCount(User_id);
    }

    @Override
    public String selectPicture_pathById(int Picture_id) {
        return profilePageMapper.selectPicture_pathById(Picture_id);
    }

    @Override
    public List<Picture>  selectPicture(String Album_name, int User_id) {
        return profilePageMapper.selectPicture(Album_name,User_id);
    }

    @Override
    public Picture selectPictureById(int Picture_id) {
        return profilePageMapper.selectPictureById(Picture_id);
    }


}
