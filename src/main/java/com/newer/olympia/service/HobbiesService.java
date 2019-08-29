package com.newer.olympia.service;/*
 *@author  yangdu
 *@date 2019/8/28 - 14:04
 * */

import com.newer.olympia.domain.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HobbiesService {
    //查询兴趣爱好表
    public List<Hobbies> hobbiesAll(Integer User_id);
    //查询主页博客
    public List<Blogs> BlogsAll(Integer User_id);
    // 主页相册表展示
    public List<Album> AlbumAll(Integer User_id);
    //主页好友头像显示
    public List<Friend> FriendAll(Integer User_id);
    //主页勋章显示
    public List<Medal_user> MedalAll(Integer User_id);
}
