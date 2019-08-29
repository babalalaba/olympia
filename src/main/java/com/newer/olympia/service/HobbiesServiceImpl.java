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

    @Override
    public List<Medal_user> MedalAll(Integer User_id) {
        return hobbiesMapper.MedalAll(User_id);
    }
}
