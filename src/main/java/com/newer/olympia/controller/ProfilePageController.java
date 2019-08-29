package com.newer.olympia.controller;


import com.newer.olympia.domain.*;
import com.newer.olympia.service.ProfilePageService;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;
import java.util.*;

/*
/Controller作用模块 个人主页
负责人：佘亚杰
 */
@RestController
public class ProfilePageController {
    @Autowired
    ProfilePageService profilePageService;

    //根据用户ID 查询所有发布的动态
    @PostMapping("selectBlogsAll")
    public ResponseEntity<?> selectBlogsAll(int User_id){
        List<Blogs> blogs = profilePageService.selectBlogsAllByid(User_id);
        Map<String,Blogs> map =  new HashMap<>();
        long time = new Date().getTime();
        blogs.forEach(blogs1 -> {
          long a =   time-blogs1.getBlogs_time().getTime();
          if(a/(1000*60*60*24)>=30){
             Double a1 = Double.valueOf(((a/(1000*60*60*24))/30));
              int a2 =(int)Math.floor(a1);
              String a3 = a2+"月天前";
              map.put(a3,blogs1);
          }else if(a/(1000*60*60)>=24){
              Double a1 = Double.valueOf(((a/(1000*60*60))/24));
              int a2 =(int)Math.floor(a1);
              String a3 = a2+"天前";
              map.put(a3,blogs1);
          }else if(a/(1000*60)>=60){
              Double a1 = Double.valueOf(((a/(1000*60))/60));
              int a2 =(int)Math.floor(a1);
              String a3 = a2+"分钟前";
              map.put(a3,blogs1);
          }else if(a/(1000)>=60){
              Double a1 = Double.valueOf(((a/(1000))/60));
              int a2 =(int)Math.floor(a1);
              String a3 = a2+"秒前";
              map.put(a3,blogs1);
          }
        });
        return new ResponseEntity<>(map, HttpStatus.OK);

    }

    //根据发布的动态ID 查询该用户发布的动态下所有的评论
    @PostMapping("selectCommentAllByid")
    public ResponseEntity<?> selectCommentAllByid(int User_id,int Blogs_id){
        System.out.println(Blogs_id);
        List<FriendComment> friendComments = profilePageService.selectCommentAllByid(User_id,Blogs_id);
        Map<String,FriendComment> map =  new HashMap<>();
        long time = new Date().getTime();
        friendComments.forEach(friendComment -> {
            long a =   time-friendComment.getComment_time().getTime();
            if(a/(1000*60*60*24)>=30){
                Double a1 = Double.valueOf(((a/(1000*60*60*24))/30));
                int a2 =(int)Math.floor(a1);
                String a3 = a2+"月天前";
                map.put(a3,friendComment);
            }else if(a/(1000*60*60)>=24){
                Double a1 = Double.valueOf(((a/(1000*60*60))/24));
                int a2 =(int)Math.floor(a1);
                String a3 = a2+"天前";
                map.put(a3,friendComment);
            }else if(a/(1000*60)>=60){
                Double a1 = Double.valueOf(((a/(1000*60))/60));
                int a2 =(int)Math.floor(a1);
                String a3 = a2+"分钟前";
                map.put(a3,friendComment);
            }else if(a/(1000)>=60){
                Double a1 = Double.valueOf(((a/(1000))/60));
                int a2 =(int)Math.floor(a1);
                String a3 = a2+"秒前";
                map.put(a3,friendComment);
            }
        });
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    //根据用户ID和动态ID 查询该动态下的所有评论的评论数
    @PostMapping("selectCommentCount")
    public ResponseEntity<?> selectCommentCount(int User_id,int Blogs_id){
      int count = profilePageService.selectCommentCount(User_id,Blogs_id);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    //根据用户ID 查询申请表中的所有申请添加好友的陌生人
    @PostMapping("selectApply")
    public ResponseEntity<?> selectCommentCount(int User_id){
        List<Apply> applies = profilePageService.selectApply(User_id);
        return new ResponseEntity<>(applies, HttpStatus.OK);
    }

    //根据用户ID  查询个人描述
    @PostMapping("selectDescribe")
    public ResponseEntity<?> selectDescribe(int User_id){
        String describe = profilePageService.selectDescribe(User_id);
        return new ResponseEntity<>(describe, HttpStatus.OK);
    }

    //根据用户ID 查询兴趣爱好
    @PostMapping("selectHobbies")
    public ResponseEntity<?> selectHobbies(int User_id){
        Hobbies hobbies = profilePageService.selectHobbies(User_id);
        return new ResponseEntity<>(hobbies, HttpStatus.OK);
    }
    //模糊查询 根据
  /*  @PostMapping*/


    //根据用户ID 查询用户信息
    @PostMapping("selectUser")
    public ResponseEntity<?> selectUser(int User_id){
        User user = profilePageService.selectUser(User_id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


}
