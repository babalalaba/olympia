package com.newer.olympia.service;

import com.newer.olympia.domain.Blogs;
import com.newer.olympia.domain.ReMap;
import com.newer.olympia.domain.User;
import com.newer.olympia.mapper.DynamicMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
@Resource
public class DynamicServiceImpl implements DynamicService {
    @Autowired
    private DynamicMapper dynamicMapper;
    @Override
    public List<User> FindBirthday(Integer User_id) {

        return dynamicMapper.FindBirthday(User_id);
    }

    @Override
    public User FindUser(Integer User_id) {
        return dynamicMapper.FindUser(User_id);
    }

    @Override
    public int addDongtai(Blogs blogs) {
        return dynamicMapper.addDongtai(blogs);
    }

    @Override
    public List<ReMap> findContent(Integer User_id) {
        return dynamicMapper.findContent(User_id);
    }

    @Override
    public List<ReMap> findComment(Integer Blogs_id) {
        return dynamicMapper.findComment(Blogs_id);
    }
}
