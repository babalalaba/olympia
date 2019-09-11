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
    public List<Comment>  selectCommentAllByid(int Blogs_id) {
        return profilePageMapper.selectCommentAllByid(Blogs_id);
    }

    @Override
    public int selectCommentCount(int Blogs_id) {
        return profilePageMapper.selectCommentCount(Blogs_id);
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
    public List<Integer> selectLike(int Blogs_id) {
        return profilePageMapper.selectLike(Blogs_id);
    }

    @Override
    public int insertComment(int Comment_user_id, int Blogs_id, String Comment_content) {
        return profilePageMapper.insertComment(Comment_user_id,Blogs_id,Comment_content);
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

    @Override
    public List<Album_comment> selectAlbum_comment(int Album_id) {
        return profilePageMapper.selectAlbum_comment(Album_id);
    }

    @Override
    public int selectAlbum_comment_count(int Album_id) {
        return profilePageMapper.selectAlbum_comment_count(Album_id);
    }

    @Override
    public int insertAlbum_dianzan(int User_id,int Album_id) {
        return profilePageMapper.insertAlbum_dianzan(User_id,Album_id);
    }

    @Override
    public User_table shifoudianzan(int User_id,int Album_id) {
        return profilePageMapper.shifoudianzan(User_id,Album_id);
    }

    @Override
    public int shanchudianzan(int User_id,int Album_id) {
        return profilePageMapper.shanchudianzan(User_id,Album_id);
    }

    @Override
    public List<Integer> xiangcedianzanshu(int Album_id) {
        return profilePageMapper.xiangcedianzanshu(Album_id);
    }

    @Override
    public List<Integer> dianzanrentuo(int Album_id) {
        return profilePageMapper.dianzanrentuo(Album_id);
    }

    @Override
    public int deleteAlbum(String Album_name, int User_id) {
        return profilePageMapper.deleteAlbum(Album_name,User_id);
    }

    @Override
    public int deletePicture(String Album_name, int User_id) {
        return profilePageMapper.deletePicture(Album_name,User_id);
    }

    @Override
    public int deleteAlbum_comment(int Album_id, int User_id) {
        return profilePageMapper.deleteAlbum_comment(Album_id,User_id);
    }

    @Override
    public int insertAlbum_comment(int Comment_user_id, int Album_id, String Comment_content) {
        return profilePageMapper.insertAlbum_comment(Comment_user_id,Album_id,Comment_content);
    }

    @Override
    public int deletePictureById(int Picture_id) {
        return profilePageMapper.deletePictureById(Picture_id);
    }

    @Override
    public List<Blogs> selectBoKe(int User_id) {
        return profilePageMapper.selectBoKe(User_id);
    }

    @Override
    public int selectBoKeCount(int User_id) {
        return profilePageMapper.selectBoKeCount(User_id);
    }

    @Override
    public List<Integer> dianzanrentuo2(int Blogs_id) {
        return profilePageMapper.dianzanrentuo2(Blogs_id);
    }

    @Override
    public User_table shifoudianzan2(int User_id, int Blogs_id) {

        return profilePageMapper.shifoudianzan2(User_id,Blogs_id);
    }

    @Override
    public int shanchudianzan2(int User_id, int Blogs_id) {
        return profilePageMapper.shanchudianzan2(User_id,Blogs_id);
    }

    @Override
    public int deleteBoKe(int Blogs_id) {
        return profilePageMapper.deleteBoKe(Blogs_id);
    }

    @Override
    public int deleteBoKe1(int Blogs_id) {
        return profilePageMapper.deleteBoKe1(Blogs_id);
    }

    @Override
    public int deleteBoKe2(int Blogs_id) {
        return profilePageMapper.deleteBoKe1(Blogs_id);
    }

    @Override
    public int insertInform(int Inform_user_id, int User_id, String Inform_board) {
        return profilePageMapper.insertInform(Inform_user_id,User_id,Inform_board);
    }

    @Override
    public List<Privacy> selectPrivacy(int User_id) {
        return profilePageMapper.selectPrivacy(User_id);
    }

    @Override
    public List<Integer> selectFriendAll(int User_id) {
        return profilePageMapper.selectFriendAll(User_id);
    }

    @Override
    public Blogs selectBlog(int Blogs_id) {
        return profilePageMapper.selectBlog(Blogs_id);
    }

    @Override
    public int deleteInform(String Inform_board) {
        return profilePageMapper.deleteInform(Inform_board);
    }

    @Override
    public int updJubao(String Blogs_season,int Blogs_id) {
        return profilePageMapper.updJubao(Blogs_season,Blogs_id);
    }

    @Override
    public List<SyjBlgos> selectBlogsAllByid1(int User_id) {
        return profilePageMapper.selectBlogsAllByid1(User_id);
    }

    @Override
    public int fankui(String Blogs_season, int Blogs_id) {
        return profilePageMapper.fankui(Blogs_season,Blogs_id);
    }


}
