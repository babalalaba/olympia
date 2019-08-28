package com.newer.olympia.service;/*
 *@author  yangdu
 *@date 2019/8/28 - 14:04
 * */

import com.newer.olympia.domain.Blogs;
import com.newer.olympia.domain.Hobbies;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HobbiesService {
    //查询兴趣爱好表
    public List<Hobbies> hobbiesAll(Integer User_id);
    //查询主页博客
    public List<Blogs> BlogsAll(Integer User_id);
}
