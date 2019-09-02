package com.newer.olympia.controller;


import com.newer.olympia.domain.*;
import com.newer.olympia.service.ProfilePageService;
import com.newer.olympia.util.Pager;
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
    public ResponseEntity<?> selectBlogsAll(@Param("User_id") int User_id){
        List<SyjBlgos> blogs = profilePageService.selectBlogsAllByid(User_id);
        List<SyjBlgos> syjBlgosList = new ArrayList<>();
        long time = new Date().getTime();
        blogs.forEach(blogs1 -> {
          long a =   time-blogs1.getBlogs_time().getTime();
          if(a/(1000*60*60*24)>=30){
             Double a1 = Double.valueOf(((a/(1000*60*60*24))/30));
              int a2 =(int)Math.floor(a1);
              String a3 = a2+"月天前";
              SyjBlgos syjBlgos = new SyjBlgos();
              syjBlgos.setBlogs_content(blogs1.getBlogs_content());
              syjBlgos.setBlogs_id(blogs1.getBlogs_id());
              syjBlgos.setBlogs_img(blogs1.getBlogs_img());
              syjBlgos.setBlogs_like(blogs1.getBlogs_like());
              syjBlgos.setBlogs_state(blogs1.getBlogs_state());
              syjBlgos.setBlogs_time(blogs1.getBlogs_time());
              syjBlgos.setBlogs_type(blogs1.getBlogs_type());
              syjBlgos.setComment(blogs1.getComment());
              syjBlgos.setFabu_time(a3);
              syjBlgos.setUser(blogs1.getUser());
              syjBlgos.setUser_id(blogs1.getUser_id());
              syjBlgosList.add(syjBlgos);
          }else if(a/(1000*60*60)>=24){
              Double a1 = Double.valueOf(((a/(1000*60*60))/24));
              int a2 =(int)Math.floor(a1);
              String a3 = a2+"天前";
              SyjBlgos syjBlgos = new SyjBlgos();
              syjBlgos.setBlogs_content(blogs1.getBlogs_content());
              syjBlgos.setBlogs_id(blogs1.getBlogs_id());
              syjBlgos.setBlogs_img(blogs1.getBlogs_img());
              syjBlgos.setBlogs_like(blogs1.getBlogs_like());
              syjBlgos.setBlogs_state(blogs1.getBlogs_state());
              syjBlgos.setBlogs_time(blogs1.getBlogs_time());
              syjBlgos.setBlogs_type(blogs1.getBlogs_type());
              syjBlgos.setComment(blogs1.getComment());
              syjBlgos.setFabu_time(a3);
              syjBlgos.setUser(blogs1.getUser());
              syjBlgos.setUser_id(blogs1.getUser_id());
              syjBlgosList.add(syjBlgos);
          }else if(a/(1000*60)>=60){
              Double a1 = Double.valueOf(((a/(1000*60))/60));
              int a2 =(int)Math.floor(a1);
              String a3 = a2+"小时前";
              SyjBlgos syjBlgos = new SyjBlgos();
              syjBlgos.setBlogs_content(blogs1.getBlogs_content());
              syjBlgos.setBlogs_id(blogs1.getBlogs_id());
              syjBlgos.setBlogs_img(blogs1.getBlogs_img());
              syjBlgos.setBlogs_like(blogs1.getBlogs_like());
              syjBlgos.setBlogs_state(blogs1.getBlogs_state());
              syjBlgos.setBlogs_time(blogs1.getBlogs_time());
              syjBlgos.setBlogs_type(blogs1.getBlogs_type());
              syjBlgos.setComment(blogs1.getComment());
              syjBlgos.setFabu_time(a3);
              syjBlgos.setUser(blogs1.getUser());
              syjBlgos.setUser_id(blogs1.getUser_id());
              syjBlgosList.add(syjBlgos);
          }else if(a/(1000)>=60){
              Double a1 = Double.valueOf(((a/(1000))/60));
              int a2 =(int)Math.floor(a1);
              String a3 = a2+"分钟前";
              SyjBlgos syjBlgos = new SyjBlgos();
              syjBlgos.setBlogs_content(blogs1.getBlogs_content());
              syjBlgos.setBlogs_id(blogs1.getBlogs_id());
              syjBlgos.setBlogs_img(blogs1.getBlogs_img());
              syjBlgos.setBlogs_like(blogs1.getBlogs_like());
              syjBlgos.setBlogs_state(blogs1.getBlogs_state());
              syjBlgos.setBlogs_time(blogs1.getBlogs_time());
              syjBlgos.setBlogs_type(blogs1.getBlogs_type());
              syjBlgos.setComment(blogs1.getComment());
              syjBlgos.setFabu_time(a3);
              syjBlgos.setUser(blogs1.getUser());
              syjBlgos.setUser_id(blogs1.getUser_id());
              syjBlgosList.add(syjBlgos);
          }else if(a/(1000)<60){
              Double a1 = Double.valueOf((a/1000));
              int a2 =(int)Math.floor(a1);
              String a3 = a2+"秒前";
              SyjBlgos syjBlgos = new SyjBlgos();
              syjBlgos.setBlogs_content(blogs1.getBlogs_content());
              syjBlgos.setBlogs_id(blogs1.getBlogs_id());
              syjBlgos.setBlogs_img(blogs1.getBlogs_img());
              syjBlgos.setBlogs_like(blogs1.getBlogs_like());
              syjBlgos.setBlogs_state(blogs1.getBlogs_state());
              syjBlgos.setBlogs_time(blogs1.getBlogs_time());
              syjBlgos.setBlogs_type(blogs1.getBlogs_type());
              syjBlgos.setComment(blogs1.getComment());
              syjBlgos.setFabu_time(a3);
              syjBlgos.setUser(blogs1.getUser());
              syjBlgos.setUser_id(blogs1.getUser_id());
              syjBlgosList.add(syjBlgos);
          }

        });
        return new ResponseEntity<>(syjBlgosList, HttpStatus.OK);

    }

    //根据发布的动态ID 查询该用户发布的动态下所有的评论
    @PostMapping("selectCommentAllByid")
    public ResponseEntity<?> selectCommentAllByid(@Param("User_id")int User_id,@Param("Blogs_id")int Blogs_id,@Param("pageNo")int pageNo){
        if(pageNo==0){
            pageNo=1;
        }
        int pageNo1 = (pageNo-1)*2;
        System.out.println(pageNo1);
       int totlaPage =  profilePageService.selectTotlaPage(Blogs_id);
        List<FriendComment> friendComments = profilePageService.selectCommentAllByid(User_id,Blogs_id,pageNo1);
        List<FriendComment> commentList = new ArrayList<>();
        Pager pager = new Pager();
        long time = new Date().getTime();
        int finalPageNo = pageNo;
        friendComments.forEach(friendComment -> {
            long a =   time-friendComment.getComment_time().getTime();
            if(a/(1000*60*60*24)>=30){
                Double a1 = Double.valueOf(((a/(1000*60*60*24))/30));
                int a2 =(int)Math.floor(a1);
                String a3 = a2+"月天前";
                FriendComment friendComment1 = new FriendComment();
                friendComment1.setBlogs_id(friendComment.getBlogs_id());//文章ID
                friendComment1.setComment_content(friendComment.getComment_content());//文章ID对应的评论
                friendComment1.setComment_id(friendComment.getComment_id());//评论表主键ID
                friendComment1.setComment_time(friendComment.getComment_time());//评论时间
                friendComment1.setPinglun_time(a3);
                friendComment1.setComment_user_id(friendComment.getUser_id());//发布人的ID
                friendComment1.setComment_user_img(friendComment.getComment_user_img());//评论人头像路径
                friendComment1.setComment_user_name(friendComment.getComment_user_name());//评论人
                friendComment1.setUser_id(friendComment.getUser_id());//评论人ID
                commentList.add(friendComment1);
                pager.setResult(commentList);
                pager.setPageNo(finalPageNo);
                pager.setTotlaPage(totlaPage);
            }else if(a/(1000*60*60)>=24){
                Double a1 = Double.valueOf(((a/(1000*60*60))/24));
                int a2 =(int)Math.floor(a1);
                String a3 = a2+"天前";
                FriendComment friendComment1 = new FriendComment();
                friendComment1.setBlogs_id(friendComment.getBlogs_id());//文章ID
                friendComment1.setComment_content(friendComment.getComment_content());//文章ID对应的评论
                friendComment1.setComment_id(friendComment.getComment_id());//评论表主键ID
                friendComment1.setComment_time(friendComment.getComment_time());//评论时间
                friendComment1.setPinglun_time(a3);
                friendComment1.setComment_user_id(friendComment.getUser_id());//发布人的ID
                friendComment1.setComment_user_img(friendComment.getComment_user_img());//评论人头像路径
                friendComment1.setComment_user_name(friendComment.getComment_user_name());//评论人
                friendComment1.setUser_id(friendComment.getUser_id());//评论人ID
                commentList.add(friendComment1);
                pager.setResult(commentList);
                pager.setPageNo(finalPageNo);
                pager.setTotlaPage(totlaPage);
            }else if(a/(1000*60)>=60){
                Double a1 = Double.valueOf(((a/(1000*60))/60));
                int a2 =(int)Math.floor(a1);
                String a3 = a2+"小时前";
                FriendComment friendComment1 = new FriendComment();
                friendComment1.setBlogs_id(friendComment.getBlogs_id());//文章ID
                friendComment1.setComment_content(friendComment.getComment_content());//文章ID对应的评论
                friendComment1.setComment_id(friendComment.getComment_id());//评论表主键ID
                friendComment1.setComment_time(friendComment.getComment_time());//评论时间
                friendComment1.setPinglun_time(a3);
                friendComment1.setComment_user_id(friendComment.getUser_id());//发布人的ID
                friendComment1.setComment_user_img(friendComment.getComment_user_img());//评论人头像路径
                friendComment1.setComment_user_name(friendComment.getComment_user_name());//评论人
                friendComment1.setUser_id(friendComment.getUser_id());//评论人ID
                commentList.add(friendComment1);
                pager.setResult(commentList);
                pager.setPageNo(finalPageNo);
                pager.setTotlaPage(totlaPage);
            }else if(a/(1000)>=60){
                Double a1 = Double.valueOf(((a/(1000))/60));
                int a2 =(int)Math.floor(a1);
                String a3 = a2+"分钟前";
                FriendComment friendComment1 = new FriendComment();
                friendComment1.setBlogs_id(friendComment.getBlogs_id());//文章ID
                friendComment1.setComment_content(friendComment.getComment_content());//文章ID对应的评论
                friendComment1.setComment_id(friendComment.getComment_id());//评论表主键ID
                friendComment1.setComment_time(friendComment.getComment_time());//评论时间
                friendComment1.setPinglun_time(a3);
                friendComment1.setComment_user_id(friendComment.getUser_id());//发布人的ID
                friendComment1.setComment_user_img(friendComment.getComment_user_img());//评论人头像路径
                friendComment1.setComment_user_name(friendComment.getComment_user_name());//评论人
                friendComment1.setUser_id(friendComment.getUser_id());//评论人ID
                commentList.add(friendComment1);
                pager.setResult(commentList);
                pager.setPageNo(finalPageNo);
                pager.setTotlaPage(totlaPage);
            }else if(a/(1000)<60){
                Double a1 = Double.valueOf((a/1000));
                int a2 =(int)Math.floor(a1);
                String a3 = a2+"秒前";
                FriendComment friendComment1 = new FriendComment();
                friendComment1.setBlogs_id(friendComment.getBlogs_id());//文章ID
                friendComment1.setComment_content(friendComment.getComment_content());//文章ID对应的评论
                friendComment1.setComment_id(friendComment.getComment_id());//评论表主键ID
                friendComment1.setComment_time(friendComment.getComment_time());//评论时间
                friendComment1.setPinglun_time(a3);
                friendComment1.setComment_user_id(friendComment.getUser_id());//发布人的ID
                friendComment1.setComment_user_img(friendComment.getComment_user_img());//评论人头像路径
                friendComment1.setComment_user_name(friendComment.getComment_user_name());//评论人
                friendComment1.setUser_id(friendComment.getUser_id());//评论人ID
                commentList.add(friendComment1);
                pager.setResult(commentList);
                pager.setPageNo(finalPageNo);
                pager.setTotlaPage(totlaPage);
            }
        });
        return new ResponseEntity<>(pager, HttpStatus.OK);
    }

    //根据用户ID和动态ID 查询该动态下的所有评论的评论数
    @PostMapping("selectCommentCount")
    public ResponseEntity<?> selectCommentCount(@Param("User_id")int User_id,@Param("Blogs_id")int Blogs_id){
      int count = profilePageService.selectCommentCount(User_id,Blogs_id);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    //根据用户ID 查询申请表中的所有申请添加好友的陌生人
    @PostMapping("selectApply")
    public ResponseEntity<?> selectCommentCount(@Param("User_id")int User_id){
        List<Apply> applies = profilePageService.selectApply(User_id);
        return new ResponseEntity<>(applies, HttpStatus.OK);
    }

    //根据用户ID  查询个人描述
    @PostMapping("selectDescribe")
    public ResponseEntity<?> selectDescribe(@Param("User_id")int User_id){
        String describe = profilePageService.selectDescribe(User_id);
        return new ResponseEntity<>(describe, HttpStatus.OK);
    }

    //根据用户ID 查询兴趣爱好
    @PostMapping("selectHobbies")
    public ResponseEntity<?> selectHobbies(@Param("User_id")int User_id){
        Hobbies hobbies = profilePageService.selectHobbies(User_id);
        return new ResponseEntity<>(hobbies, HttpStatus.OK);
    }
    //模糊查询 根据
  /*  @PostMapping*/


    //根据用户ID 查询用户信息
    @PostMapping("selectUser")
    public ResponseEntity<?> selectUser(@Param("User_id")int User_id){
        User user = profilePageService.selectUser(User_id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    //根据文章ID 查询点赞人数
    @PostMapping("selectLike")
    public ResponseEntity<?> selectLike(@Param("Blogs_id")int Blogs_id){
        List<User_table> user_tables = profilePageService.selectLike(Blogs_id);
        final int[] like = {0};
        user_tables.forEach(user_table -> {
            if(user_table.getStatus()==1){
                like[0]++;
            }
        });
    return new ResponseEntity<>(like, HttpStatus.OK);
    }

    //新增文章评论
    @PostMapping("insertComment")
    public ResponseEntity<?> insertComment(@Param("Blogs_id")int Blogs_id,
                                           @Param("Comment_user_id")int Comment_user_id,
                                           @Param("Comment_content")String Comment_content,
                                           @Param("User_id")int User_id){
      int count = profilePageService.insertComment(Comment_user_id,Blogs_id,Comment_content,User_id);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }


    //新增点赞数据
    @PostMapping("insertUser_table")
    public ResponseEntity<?> insertUser_table(@Param("Blogs_id")int Blogs_id,
                                           @Param("User_id")int User_id){
        int count = profilePageService.insertUser_table(User_id,Blogs_id);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }
}
