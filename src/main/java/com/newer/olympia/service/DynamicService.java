package com.newer.olympia.service;

import com.newer.olympia.domain.Blogs;
import com.newer.olympia.domain.ReMap;
import com.newer.olympia.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
//动态发布页面  负责人戴业员

public interface DynamicService {
    public List<User> FindBirthday(@Param("User_id") Integer User_id);
    public  User FindUser(@Param("User_id") Integer User_id);
    public int addDongtai(Blogs blogs);
    public List<ReMap> findContent(@Param("User_id")Integer User_id);

    public List<ReMap> findComment(@Param("Blogs_id")Integer Blogs_id);
}
