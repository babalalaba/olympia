package com.newer.olympia.service;/*
 *@author  yangdu
 *@date 2019/8/28 - 14:05
 * */

import com.newer.olympia.domain.*;
import com.newer.olympia.mapper.HobbiesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HobbiesServiceImpl implements  HobbiesService {
    @Autowired
    private HobbiesMapper hobbiesMapper;
    @Override
    public List<Hobbies> hobbiesAll(Integer User_id) {
        return hobbiesMapper.hobbiesAll(User_id);
    }

    @Override
    public List<Blogs> BlogsAll(Integer User_id) {
        return hobbiesMapper.BlogsAll(User_id);
    }

    @Override
    public List<Album> AlbumAll(Integer User_id) {
        return hobbiesMapper.AlbumAll(User_id);
    }

    @Override
    public List<Friend> FriendAll(Integer User_id) {
        return hobbiesMapper.FriendAll(User_id);
    }

    /**
     *     好友请求方法
     * @param  friend
     *      1 . 同意好友申请
     *      2. 拒绝好友申请
     *
     * @param  Apply_id
     *
     *      请求Apply_id
     *
     */

    public  Integer friend(Integer friend , Integer Apply_id){
        Apply app = hobbiesMapper.findApply(Apply_id);
        if (friend == 1){ //同意好友申请
            System.out.println(friend+"同意好友申请");
            Friend friend1 = new Friend();
            friend1.setFriend_user_id(app.getApply_user_id()); //申请人id
            friend1.setUser_id(app.getUser_id()); //用户本身
            hobbiesMapper.insertFriend(friend1);
        }else if(friend == 2){ //拒绝好友申请
            hobbiesMapper.deleteApply(Apply_id);  //删除申请数据
            System.out.println(friend+"拒绝申请");
            return 200;
        }
        hobbiesMapper.deleteApply(Apply_id);  //删除申请数据
        return 200;
    }


    /**
     * 查询 所有待添加的好友
     * @param User_id
     * @return
     */
    public List<Apply> findAllByUser(Integer User_id){
        return hobbiesMapper.findAllByUser(User_id);
    }
    //查找有这个用户。就往申请表添加数据
    @Override
    public int insertApplys(Apply apply) {
        return hobbiesMapper.insertApplys(apply);
    }
    @Override
    public List<Medal_user> MedalAll(Integer User_id) {
        return hobbiesMapper.MedalAll(User_id);
    }
    @Override
    public List<User_table> FindUtableall(Integer User_id,Integer Blogs_id) {
        return hobbiesMapper.FindUtableall(User_id,Blogs_id);
    }

    @Override
    public int inserUtable(User_table u) {
        return hobbiesMapper.inserUtable(u);
    }

    @Override
    public int delUtable(Integer User_table_id) {
        return hobbiesMapper.delUtable(User_table_id);
    }

    @Override
    public int updateUtable(User_table u) {
        return hobbiesMapper.updateUtable(u);
    }

    @Override
    public int insertComment(Comment c) {
        return hobbiesMapper.insertComment(c);
    }

    @Override
    public List<FriendComment> selectCommentAllByid(int User_id, int Blogs_id, int pageNo,int pageNoSize) {
        return hobbiesMapper.selectCommentAllByid(User_id,Blogs_id,pageNo,pageNoSize);
    }

    @Override
    public int selectTotlaPage(int Blogs_id) {
        return hobbiesMapper.selectTotlaPage(Blogs_id);
    }

    @Override
    public List<SyjBlgos> selectBlogsAllByid() {
        return hobbiesMapper.selectBlogsAllByid();
    }

    @Override
    public List<User_table> selectLike(int Blogs_id) {
        return hobbiesMapper.selectLike(Blogs_id);
    }

    @Override
    public int selectCommentCount(int User_id, int Blogs_id) {
        return hobbiesMapper.selectCommentCount(User_id,Blogs_id);
    }

    @Override
    public User_table Utablealling(Integer User_id, Integer Blogs_id) {
        return hobbiesMapper.Utablealling(User_id,Blogs_id);
    }

    @Override
    public List<User_table> Utablealltupian() {
        return hobbiesMapper.Utablealltupian();
    }

    @Override
    public int delBlogsing(Integer Blogs_id) {
        return hobbiesMapper.delBlogsing(Blogs_id);
    }

    @Override
    public List<User_table> User_tableing(Integer User_id, Integer Blogs_id) {
        return hobbiesMapper.User_tableing(User_id,Blogs_id);
    }

    @Override
    public List<SyjBlgos> selectBlogsAllByiding(Integer pageNo,Integer pageNoSize) {
        return hobbiesMapper.selectBlogsAllByiding(pageNo,pageNoSize);
    }

    @Override
    public int TotlaPage() {
        return hobbiesMapper.TotlaPage();
    }

    @Override
    public int updataUsertitle_img(String User_title_img,String User_name) {
        return hobbiesMapper.updataUsertitle_img(User_title_img,User_name);
    }


}
