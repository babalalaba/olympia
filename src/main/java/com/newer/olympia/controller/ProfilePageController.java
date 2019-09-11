package com.newer.olympia.controller;


import com.newer.olympia.domain.*;
import com.newer.olympia.service.ProfilePageService;
import com.newer.olympia.util.Pager;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
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
    public ResponseEntity<?> selectBlogsAll(@Param("User_id") int User_id,String Friend_user_id){
        List<SyjBlgos> blogs =  new ArrayList<>();
        if(Friend_user_id==null){
            blogs =   profilePageService.selectBlogsAllByid(User_id);
        }else {
            blogs =  profilePageService.selectBlogsAllByid1(User_id);
        }

        List<SyjBlgos> syjBlgosList = new ArrayList<>();
        long time = new Date().getTime();
        blogs.forEach(blogs1 -> {
          long a =   time-(blogs1.getBlogs_time().getTime()-28800000);
          if(a/(1000*60*60*24)>=30){
             Double a1 = Double.valueOf(((a/(1000*60*60*24))/30));//long转Double类型
              int a2 =(int)Math.floor(a1);
              String a3 = a2+"月前";
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
          }else if((a/(1000*60*60))>=24){
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
          }else if((a/(1000*60))>=60){
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
          }else if((a/1000)>=60){
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
          }else if((a/1000)<60){
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
    public ResponseEntity<?> selectCommentAllByid(int Blogs_id,int PageNo,int PageSize){
       List<Comment> comments = profilePageService.selectCommentAllByid(Blogs_id);
        int count = 0;
        Pager<FriendComment> pager = new Pager<FriendComment>();
        count = profilePageService.selectCommentCount(Blogs_id);
        int totalPageCount = 0;
        if ( count % PageSize == 0 ) {
            totalPageCount = count / PageSize;
        } else {
            totalPageCount = count / PageSize + 1;
        }
        List<FriendComment> friendComments = new ArrayList<>();
        int  a =(PageNo-1)*3;
        if (comments.size()!=0){
            for (int i =a ;i<comments.size();i++){//
                FriendComment friendComment = new FriendComment();
                User user = profilePageService.selectUser(comments.get(i).getComment_user_id());
                friendComment.setUser_id(comments.get(i).getUser_id());
                friendComment.setComment_user_name(user.getUser_name());
                friendComment.setComment_user_img(user.getUser_img());
                friendComment.setComment_user_id(comments.get(i).getComment_user_id());
                friendComment.setComment_time(comments.get(i).getComment_time());
                friendComment.setComment_id(comments.get(i).getComment_id());
                friendComment.setComment_content(comments.get(i).getComment_content());
                friendComment.setBlogs_id(comments.get(i).getBlogs_id());
                long time1 = new Date().getTime();
                long time2 = (comments.get(i).getComment_time().getTime())-28800000;
                String a3=null;
                if(((time1-time2)/(1000*60*60*24))>=30){
                    Double a1 = Double.valueOf((((time1-time2)/(1000*60*60*24))/30));//long转Double类型
                    int a2 =(int)Math.floor(a1);
                    a3 = a2+"月前";
                }else if(((time1-time2)/(1000*60*60))>=24){
                    Double a1 = Double.valueOf((((time1-time2)/(1000*60*60))/24));
                    int a2 =(int)Math.floor(a1);
                    a3 = a2+"天前";
                }else if(((time1-time2)/(1000*60))>=60){
                    Double a1 = Double.valueOf((((time1-time2)/(1000*60))/60));
                    int a2 =(int)Math.floor(a1);
                    a3 = a2+"小时前";
                }else if(((time1-time2)/(1000))>=60){
                    Double a1 = Double.valueOf((((time1-time2)/(1000))/60));
                    int a2 =(int)Math.floor(a1);
                    a3 = a2+"分钟前";
                }else if(((time1-time2)/(1000))<60){
                    Double a1 = Double.valueOf(((time1-time2)/1000));
                    int a2 =(int)Math.floor(a1);
                    a3 = a2+"秒前";
                }
                friendComment.setPinglun_time(a3);
                friendComments.add(friendComment);
            };
            pager.setDatas(friendComments);
            pager.setPageNo(PageNo);
            pager.setTotalno(totalPageCount);
            pager.setTotalsize(count);
            pager.setPageSize(PageSize);
        }else {
            List<String> stringList = new ArrayList<>();
            stringList.add("没有数据");
            return new ResponseEntity<>(stringList, HttpStatus.OK);
        }
        return new ResponseEntity<>(pager, HttpStatus.OK);
    }

    //根据用户ID和动态ID 查询该动态下的所有评论的评论数
    @PostMapping("selectCommentCount")
    public ResponseEntity<?> selectCommentCount1(int Blogs_id){
      int count = profilePageService.selectCommentCount(Blogs_id);
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

    //根据用户ID 查询用户信息
    @PostMapping("selectUser")
    public ResponseEntity<?> selectUser(@Param("User_id")int User_id){
        User user = profilePageService.selectUser(User_id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    //根据文章ID 查询点赞人数
    @PostMapping("selectLike")
    public ResponseEntity<?> selectLike(@Param("Blogs_id")int Blogs_id){
        List<Integer> user_tables = profilePageService.selectLike(Blogs_id);
         int like = 0;
         for (int i=0;i<user_tables.size();i++){
             if (user_tables.get(i)==1){
                 like++;
             }
         }

    return new ResponseEntity<>(like, HttpStatus.OK);
    }

    //新增文章评论
    @PostMapping("insertComment")
    public ResponseEntity<?> insertComment(int Blogs_id,int Comment_user_id,String Comment_content,int User_id){
      int count = 0;
        if(Comment_user_id==User_id){//如果评论人ID等于用户自身ID  那么此时不添加通知
             count = profilePageService.insertComment(Comment_user_id,Blogs_id,Comment_content);
        }else {//不相同则说明现在进入访客模式
            User user = profilePageService.selectUser(Comment_user_id);
            Blogs blogs = profilePageService.selectBlog(Blogs_id);
            String message = blogs.getBlogs_content().substring(0,3);
            String Inform_board = user.getUser_name() + "对你发布的" + '"' + message + '"' + "这篇博客进行了评论";
            count = profilePageService.insertComment(Comment_user_id,Blogs_id,Comment_content);
            profilePageService.insertInform(Comment_user_id,User_id,Inform_board);
        }
        return new ResponseEntity<>(count, HttpStatus.OK);
    }


    //新增点赞数据
    @PostMapping("insertUser_table")
    public ResponseEntity<?> insertUser_table(@Param("Blogs_id")int Blogs_id,
                                           @Param("User_id")int User_id,int Inform_user_id){
        int count = 0;
        if (User_id==Inform_user_id){
            User_table user_table = profilePageService.shifoudianzan2(User_id,Blogs_id);
            if(user_table!=null){
                count = profilePageService.shanchudianzan2(User_id,Blogs_id);
            }else{
                count = profilePageService.insertUser_table(User_id,Blogs_id);
            }
        }else{
            User_table user_table = profilePageService.shifoudianzan2(User_id,Blogs_id);
            if(user_table==null){
                count = profilePageService.insertUser_table(User_id,Blogs_id);
                User user = profilePageService.selectUser(User_id);
                Blogs blogs = profilePageService.selectBlog(Blogs_id);
                String message = blogs.getBlogs_content().substring(0,5);
               String Inform_board = user.getUser_name()+"对你发布的"+'"'+message+'"'+"这篇博客进行了点赞";
                int count2 = profilePageService.insertInform(Inform_user_id,User_id,Inform_board);
                System.out.println(count2);
            }else{
                count = profilePageService.shanchudianzan2(User_id,Blogs_id);
                User user = profilePageService.selectUser(User_id);
                Blogs blogs = profilePageService.selectBlog(Blogs_id);
                String message = blogs.getBlogs_content().substring(0,5);
                String Inform_board = user.getUser_name()+"对你发布的"+'"'+message+'"'+"这篇博客进行了点赞";
                int count2 = profilePageService.deleteInform(Inform_board);
                System.out.println(count2);
            }
        }

        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    //查询用户教育历史
    @PostMapping("selectEducation")
    public ResponseEntity<?> selectEducation(@Param("User_id")int User_id){
        List<Education> educations = profilePageService.selectEducation(User_id);
        return new ResponseEntity<>(educations, HttpStatus.OK);
    }

    //查询工作史
    @PostMapping("selectJob")
    public ResponseEntity<?> selectJob(@Param("User_id")int User_id){
        List<Job> jobs = profilePageService.selectJob(User_id);
        return new ResponseEntity<>(jobs, HttpStatus.OK);
    }

    //查询用户好友
    @PostMapping("selectFriend")
    public ResponseEntity<?> selectFriend(@Param("User_id")int User_id,@Param("PageNo")int PageNo,@Param("PageSize")int PageSize,@Param("User_name")String User_name){
       List<Friend> friends = new ArrayList<>();
       int count = 0;
        if (User_name!=null||User_name!=""){
            friends = profilePageService.selectUserByName(User_id,User_name);
            count = profilePageService.selectFriendCountByName(User_id,User_name);//根据用户ID 查询出用户的好友数量
        }else {
            friends = profilePageService.selectFriend(User_id);//查询用户好友表
             count = profilePageService.selectFriendCount(User_id);//根据用户ID 查询出用户的好友数量
        }

        Pager<ProfilePage_06> pager = new Pager<ProfilePage_06>();
        int totalPageCount = 0;
        if ( count % PageSize == 0 ) {
            totalPageCount = count / PageSize;
        } else {
            totalPageCount = count / PageSize + 1;
        }
        List<ProfilePage_06> profilePage_06s = new ArrayList<>();
       int  a =(PageNo-1)*8;
        if (friends.size()!=0){
        for (int i =a ;i<friends.size();i++){//遍历用户好友集合

           User user= profilePageService.selectUser(friends.get(i).getFriend_user_id());//首先根据其中的好友ID 来查询好友个人信息
           int FriendCount = profilePageService.selectFriendCount(friends.get(i).getFriend_user_id());//根据好友ID 查询好友的好友数量
            int PictureAmount = profilePageService.selectPictureAmount(friends.get(i).getFriend_user_id());//根据好友ID 查询好友上传的照片数量
            int BlogsAmount = profilePageService.selectBlogsAmount(friends.get(i).getFriend_user_id());//根据好友ID 查询好友发布的博文数量
            Date date = profilePageService.selectBecomeTime(User_id,friends.get(i).getFriend_user_id());//根据用户ID和好友ID 查询用户与好友成立为好友的时间
            String time1 = new SimpleDateFormat("yyyy").format(date);//时间转String 取年
            String time2 = new SimpleDateFormat("MM").format(date);//时间转String 取月
            String time3 = time1+"年"+time2+"月";//拼接
            ProfilePage_06 profilePage06 = new ProfilePage_06();//new 一个 对象 set值
            profilePage06.setUser_id(user.getUser_id());
            profilePage06.setTitle_img(user.getUser_title_img());
            profilePage06.setUser_img(user.getUser_img());
            profilePage06.setUser_name(user.getUser_name());
            profilePage06.setUser_address(user.getUser_province()+user.getUser_city());
            profilePage06.setFriendCount(FriendCount);
            profilePage06.setPhotoCount(PictureAmount);
            profilePage06.setBlogsCount(BlogsAmount);
            profilePage06.setIntro(user.getUser_describe());
            profilePage06.setTime(time3);

            profilePage_06s.add(profilePage06);//将对象存入集合
        };
        pager.setDatas(profilePage_06s);
        pager.setPageNo(PageNo);
        pager.setTotalno(totalPageCount);
        pager.setTotalsize(count);
        pager.setPageSize(PageSize);
        }else {
            List<String> stringList = new ArrayList<>();
            stringList.add("没有数据");
            return new ResponseEntity<>(stringList, HttpStatus.OK);
        }
        return new ResponseEntity<>(pager, HttpStatus.OK);
    }

    //查询好友数量
   @PostMapping("selectFriendCount")
    public ResponseEntity<?> selectFriendCount(@Param("User_id")int User_id){
        int count = profilePageService.selectFriendCount(User_id);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    //删除好友
    @PostMapping("deleteFriend")
    public ResponseEntity<?> deleteFriend(@Param("User_id")int User_id,@Param("Friend_user_id")int Friend_user_id){
        int count = profilePageService.deleteFriend(User_id,Friend_user_id);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    @GetMapping(value = "/file1")
    public String file() {
        return "file";
    }

    //上传照片创建相册
    @PostMapping("/fileUpload1")
    public ResponseEntity<?>  fileUpload(@RequestParam(value = "file") MultipartFile file, Model model, HttpServletRequest request,String Album_name,String Album_describe,int User_id) {
        List<String> stringList = new ArrayList<>();

        if (Album_name==null||Album_name.equals("")||Album_describe==null||Album_describe.equals("")){
            stringList.add("相册名或相册描述不能为空");
            return new ResponseEntity<>(stringList, HttpStatus.OK);
        }else {
            Album album   = profilePageService.selectAlbum(Album_name,User_id);
            if (album!=null){
                stringList.add("该相册名已存在");
                return new ResponseEntity<>(stringList, HttpStatus.OK);
            }else {
                if (file.isEmpty()) {
                    System.out.println("文件为空空");
                }
                String fileName = file.getOriginalFilename();  // 文件名
                String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
                String filePath = "D://temp-rainy//"; // 上传后的路径
                fileName = UUID.randomUUID() + suffixName; // 新文件名
                System.out.println(Album_name);
                int count = profilePageService.insertpicture(fileName,User_id,Album_name);//根据路径,用户ID,相册名先将图片存入照片表
                Picture picture = profilePageService.selectPictureByPath(fileName,User_id);//根据路径,查询出照片ID
                int count2 = profilePageService.insertAlbum(Album_name,picture.getPicture_id(),User_id,Album_describe);//新增相册
                File dest = new File(filePath + fileName);
                if (!dest.getParentFile().exists()) {
                    dest.getParentFile().mkdirs();
                }
                try {
                    file.transferTo(dest);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String filename = "/temp-rainy/" + fileName;
                model.addAttribute("filename", filename);
                stringList.add("成功");
                return new ResponseEntity<>(stringList, HttpStatus.OK);
                }

        }


    }

    //查询用户所有相册
    @PostMapping("selectAlbum")
    public ResponseEntity<?> selectAlbum(@Param("User_id")int User_id,@Param("PageNo")int PageNo,@Param("PageSize")int PageSize){
        List<Album> albums = new ArrayList<>();
        int count = 0;
            albums = profilePageService.selectAlbumAll(User_id);//查询用户相册表
            count = profilePageService.selectAlbumCount(User_id);//根据用户ID 查询出用户的相册数量
        Pager<ProfilePage_Photos_07> pager = new Pager<ProfilePage_Photos_07>();
        System.out.println(albums);
        int totalPageCount = 0;
        if ( count % PageSize == 0 ) {
            totalPageCount = count / PageSize;
        } else {
            totalPageCount = count / PageSize + 1;
        }
        List<ProfilePage_Photos_07> profilePage_photos_07s = new ArrayList<>();
        int  a =(PageNo-1)*7;
        if (albums.size()!=0){
            for (int i =a ;i<albums.size();i++){//遍历用户照片集合集合
                ProfilePage_Photos_07 profilePagePhotos07 = new ProfilePage_Photos_07();//new 一个07页面的实体类
                profilePagePhotos07.setAlbum_comment_count(
                        profilePageService.selectAlbum_commentCount(
                                albums.get(i).getAlbum_id()));//根据遍历的相册ID 调用根据相册ID 查询该相册有多少评论数
                profilePagePhotos07.setAlbum_describe(albums.get(i).getAlbum_describe());
                profilePagePhotos07.setAlbum_id(albums.get(i).getAlbum_id());
               List<Integer> integers= profilePageService.xiangcedianzanshu(albums.get(i).getAlbum_id());
               int like = 0;
               for (int w=0 ;w<integers.size();w++){
                    if (integers.get(w)==1){
                        like++;
                    }
                }
                profilePagePhotos07.setAlbum_like(like);
                profilePagePhotos07.setAlbum_name(albums.get(i).getAlbum_name());
                profilePagePhotos07.setAlbum_time(albums.get(i).getAlbum_time());
                profilePagePhotos07.setPicture_count(profilePageService.selectPictureCount(
                        albums.get(i).getAlbum_name()));//根据遍历的相册名称 调用根据相册名称 查询该相册有多少相片
                profilePagePhotos07.setPicture_id(albums.get(i).getPicture_id());
                profilePagePhotos07.setUser_id(albums.get(i).getUser_id());
                profilePagePhotos07.setPicture_path(profilePageService.selectPicture_pathById(albums.get(i).getPicture_id()));
                profilePage_photos_07s.add(profilePagePhotos07);//将对象存入集合
            };
            pager.setDatas(profilePage_photos_07s);
            pager.setPageNo(PageNo);
            pager.setTotalno(totalPageCount);
            pager.setTotalsize(count);
            pager.setPageSize(PageSize);
        }else {
            List<String> stringList = new ArrayList<>();
            stringList.add("没有数据");
            return new ResponseEntity<>(stringList, HttpStatus.OK);
        }
        return new ResponseEntity<>(pager, HttpStatus.OK);
    }

    //查询相册所有照片
    @PostMapping("selectPictures")
    public ResponseEntity<?> selectPictures(@Param("User_id")int User_id,String Album_name){
      User user =   profilePageService.selectUser(User_id);
      Album album = profilePageService.selectAlbum(Album_name,User_id);
      int Album_comment_count = profilePageService.selectAlbum_commentCount(album.getAlbum_id());
      int Picture_count = profilePageService.selectPictureCount(Album_name);
      Picture picture = profilePageService.selectPictureById(album.getPicture_id());
      List<Picture> pictures = profilePageService.selectPicture(Album_name,User_id);
      ProfilePage_Photos_07 profilePagePhotos07 = new ProfilePage_Photos_07();
      profilePagePhotos07.setPicture_path(picture.getPicture_path());
        profilePagePhotos07.setUser_id(User_id);
        profilePagePhotos07.setPicture_id(picture.getPicture_id());
        profilePagePhotos07.setPicture_count(Picture_count);
    profilePagePhotos07.setAlbum_time(album.getAlbum_time());
        profilePagePhotos07.setAlbum_name(album.getAlbum_name());
        profilePagePhotos07.setAlbum_like(album.getAlbum_like());
        profilePagePhotos07.setAlbum_id(album.getAlbum_id());
        profilePagePhotos07.setAlbum_describe(album.getAlbum_describe());
        profilePagePhotos07.setAlbum_comment_count(Album_comment_count);
        profilePagePhotos07.setUser_name(user.getUser_name());
        profilePagePhotos07.setImg_path(user.getUser_img());
        profilePagePhotos07.setPictures(pictures);
        return new ResponseEntity<>(profilePagePhotos07, HttpStatus.OK);
    }

    //查询用户所有相册评论
    @PostMapping("selectAlbum_comment")
    public ResponseEntity<?> selectAlbum_comment(int Album_id,@Param("PageNo")int PageNo,@Param("PageSize")int PageSize){
        List<Album_comment> Album_comment = new ArrayList<>();
        List<Album_comment_07> album_comment_07s = new ArrayList<>();
        int count = 0;
        Album_comment = profilePageService.selectAlbum_comment(Album_id);//查询用相册评论表
        count = profilePageService.selectAlbum_comment_count(Album_id);//根据相册ID 查询出相册评论数
        Pager<Album_comment_07> pager = new Pager<Album_comment_07>();
        int totalPageCount = 0;
        if ( count % PageSize == 0 ) {
            totalPageCount = count / PageSize;
        } else {
            totalPageCount = count / PageSize + 1;
        }
        List<ProfilePage_Photos_07> profilePage_photos_07s = new ArrayList<>();
        int  a =(PageNo-1)*2;
        if (Album_comment.size()!=0){
            for (int i =a ;i<Album_comment.size();i++){//
                Album_comment_07 album_comment_07 = new Album_comment_07();
                album_comment_07.setAlbum_id(Album_comment.get(i).getAlbum_id());
                album_comment_07.setComment_content(Album_comment.get(i).getComment_content());
                album_comment_07.setComment_id(Album_comment.get(i).getComment_id());
                album_comment_07.setComment_time(Album_comment.get(i).getComment_time());
                album_comment_07.setComment_user_id(Album_comment.get(i).getComment_user_id());
                long time1 = new Date().getTime();
                long time2 = Album_comment.get(i).getComment_time().getTime();
                String a3=null;
                if((time1-time2)/(1000*60*60*24)>=30){
                    Double a1 = Double.valueOf((((time1-time2)/(1000*60*60*24))/30));//long转Double类型
                    int a2 =(int)Math.floor(a1);
                     a3 = a2+"月前";
                }else if((time1-time2)/(1000*60*60)>=24){
                    Double a1 = Double.valueOf((((time1-time2)/(1000*60*60))/24));
                    int a2 =(int)Math.floor(a1);
                     a3 = a2+"天前";
                }else if((time1-time2)/(1000*60)>=60){
                    Double a1 = Double.valueOf((((time1-time2)/(1000*60))/60));
                    int a2 =(int)Math.floor(a1);
                     a3 = a2+"小时前";
                }else if((time1-time2)/(1000)>=60){
                    Double a1 = Double.valueOf((((time1-time2)/(1000))/60));
                    int a2 =(int)Math.floor(a1);
                     a3 = a2+"分钟前";
                }else if((time1-time2)/(1000)<60){
                    Double a1 = Double.valueOf(((time1-time2)/1000));
                    int a2 =(int)Math.floor(a1);
                     a3 = a2+"秒前";
                }
                album_comment_07.setPinglun_time(a3);
                User user = profilePageService.selectUser(Album_comment.get(i).getComment_user_id());
                album_comment_07.setUser_id(user.getUser_id());
                album_comment_07.setUser_img(user.getUser_img());
                album_comment_07.setUser_name(user.getUser_name());
                album_comment_07s.add(album_comment_07);
            };
            pager.setDatas(album_comment_07s);
            pager.setPageNo(PageNo);
            pager.setTotalno(totalPageCount);
            pager.setTotalsize(count);
            pager.setPageSize(PageSize);
        }else {
            List<String> stringList = new ArrayList<>();
            stringList.add("没有数据");
            return new ResponseEntity<>(stringList, HttpStatus.OK);
        }
        return new ResponseEntity<>(pager, HttpStatus.OK);
    }

    //新增相册点赞
    @PostMapping("insertAlbum_dianzan")
    public ResponseEntity<?> insertAlbum_dianzan(int User_id,String Album_name){
        Album album =  profilePageService.selectAlbum(Album_name,User_id);
       User_table user_table= profilePageService.shifoudianzan(User_id,album.getAlbum_id());
       int count = 0;
       if(user_table!=null){
           count = profilePageService.shanchudianzan(User_id,album.getAlbum_id());
       }else{
           count = profilePageService.insertAlbum_dianzan(User_id,album.getAlbum_id());
       }
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    //查询相册点赞
    @PostMapping("xiangcedianzanshu")
    public ResponseEntity<?> xiangcedianzanshu(int User_id,String Album_name){
      Album album =  profilePageService.selectAlbum(Album_name,User_id);
      List<Integer> integers = profilePageService.xiangcedianzanshu(album.getAlbum_id());//根据相册ID查询出所有为1状态的相册点赞
        int count = 0;
      for (int i=0;i<integers.size();i++){
          if(integers.get(i)==1){
              count++;
          }
      }
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    //查询博客点赞
    @PostMapping("bokedianzanshu")
    public ResponseEntity<?> bokedianzanshu(int User_id,int Blogs_id){
        List<Integer> integers = profilePageService.selectLike(Blogs_id);//根据相册ID查询出所有为1状态的相册点赞
        int count = 0;
        for (int i=0;i<integers.size();i++){
            if(integers.get(i)==1){
                count++;
            }
        }
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    //查询相册点赞人头像
    @PostMapping("dianzanrentou")
    public ResponseEntity<?> dianzanrentou(int User_id,String Album_name){
        Album album =  profilePageService.selectAlbum(Album_name,User_id);
        List<Integer> integerList = profilePageService.dianzanrentuo(album.getAlbum_id());//查询出所有点赞人的ID
        List<User> userList = new ArrayList<>();
        for (int i=0;i<integerList.size();i++){
            User user = profilePageService.selectUser(integerList.get(i));
            userList.add(user);
        }
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }


    //查询相册点赞人头像
    @PostMapping("dianzanrentou1")
    public ResponseEntity<?> dianzanrentou1(int Album_id){
        List<Integer> integerList = profilePageService.dianzanrentuo(Album_id);//查询出所有点赞人的ID
        List<User> userList = new ArrayList<>();
        for (int i=0;i<integerList.size();i++){
            User user = profilePageService.selectUser(integerList.get(i));
            userList.add(user);
        }
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    //删除相册
    @PostMapping("deleteAlbum")
    public ResponseEntity<?> deleteAlbum(String Album_name,int User_id){
        Album album = profilePageService.selectAlbum(Album_name,User_id);
      int count =   profilePageService.deleteAlbum(Album_name,User_id);//删除相册
      int count2=  profilePageService.deletePicture(Album_name,User_id);//删除照片
        int  count3 = profilePageService.deleteAlbum_comment(album.getAlbum_id(),User_id);//删除评论
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    //上传照片到相册
    @PostMapping("/fileUpload2")
    public ResponseEntity<?>  fileUpload2(@RequestParam(value = "file") MultipartFile file, Model model, HttpServletRequest request,String Album_name,int User_id) {
        List<String> stringList = new ArrayList<>();
                if (file.isEmpty()) {
                    System.out.println("文件为空空");
                }
        System.out.println(Album_name);
                String fileName = file.getOriginalFilename();  // 文件名
                String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
                String filePath = "D://temp-rainy//"; // 上传后的路径
                fileName = UUID.randomUUID() + suffixName; // 新文件名
                File dest = new File(filePath + fileName);
                int count = profilePageService.insertpicture(fileName,User_id,Album_name);
                if (!dest.getParentFile().exists()) {
                    dest.getParentFile().mkdirs();
                }
                try {
                    file.transferTo(dest);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String filename = "/temp-rainy/" + fileName;
                model.addAttribute("filename", filename);
                stringList.add("成功");
                return new ResponseEntity<>(stringList, HttpStatus.OK);
            }

    //添加相册评论
    @PostMapping("insertAlbum_comment")
    public ResponseEntity<?> insertAlbum_comment(int Comment_user_id,int Album_id,String Comment_content){
        int count = profilePageService.insertAlbum_comment(Comment_user_id,Album_id,Comment_content);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    //根据ID查询相册评论数
    @PostMapping("chaxunpinglunshu")
    public ResponseEntity<?> chaxunpinglunshu(int Album_id){
        int count = profilePageService.selectAlbum_comment_count(Album_id);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    //根据照片ID 删除单个照片
    @PostMapping("deletePictureById")
    public ResponseEntity<?> deletePictureById(int Picture_id){
        int count = profilePageService.deletePictureById(Picture_id);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }


    //查询用户所有博客文章
    @PostMapping("selectBoKe")
    public ResponseEntity<?> selectBoKe(@Param("User_id")int User_id,@Param("PageNo")int PageNo,@Param("PageSize")int PageSize){
        List<Blogs> blogs = profilePageService.selectBoKe(User_id);
        int count = 0;
        count = profilePageService.selectBoKeCount(User_id);
        Pager<SyjBlgos> pager = new Pager<SyjBlgos>();
        int totalPageCount = 0;
        if ( count % PageSize == 0 ) {
            totalPageCount = count / PageSize;
        } else {
            totalPageCount = count / PageSize + 1;
        }
        List<SyjBlgos> syjBlgosList = new ArrayList<>();
        int  a =(PageNo-1)*3;
        int like = 0;
        if (blogs.size()!=0){
            for (int i =a ;i<blogs.size();i++){
               long time1 = new Date().getTime();
                long time2 = blogs.get(i).getBlogs_time().getTime();
                String a3=null;
                if((time1-time2)/(1000*60*60*24)>=30){
                    Double a1 = Double.valueOf((((time1-time2)/(1000*60*60*24))/30));//long转Double类型
                    int a2 =(int)Math.floor(a1);
                    a3 = a2+"月前";
                }else if((time1-time2)/(1000*60*60)>=24){
                    Double a1 = Double.valueOf((((time1-time2)/(1000*60*60))/24));
                    int a2 =(int)Math.floor(a1);
                    a3 = a2+"天前";
                }else if((time1-time2)/(1000*60)>=60){
                    Double a1 = Double.valueOf((((time1-time2)/(1000*60))/60));
                    int a2 =(int)Math.floor(a1);
                    a3 = a2+"小时前";
                }else if((time1-time2)/(1000)>=60){
                    Double a1 = Double.valueOf((((time1-time2)/(1000))/60));
                    int a2 =(int)Math.floor(a1);
                    a3 = a2+"分钟前";
                }else if((time1-time2)/(1000)<60){
                    Double a1 = Double.valueOf(((time1-time2)/1000));
                    int a2 =(int)Math.floor(a1);
                    a3 = a2+"秒前";
                }
                User user = profilePageService.selectUser(blogs.get(i).getUser_id());
                SyjBlgos  syjBlgos = new SyjBlgos(blogs.get(i).getBlogs_id(),
                        blogs.get(i).getUser_id(),
                        blogs.get(i).getBlogs_content(),
                        blogs.get(i).getBlogs_type(),
                        blogs.get(i).getBlogs_img(),
                        blogs.get(i).getBlogs_time(),
                        like, blogs.get(i).getBlogs_state()
                        ,a3,user.getUser_img(),
                        user.getUser_name(),profilePageService.selectCommentCount(blogs.get(i).getBlogs_id()));
                syjBlgosList.add(syjBlgos);

            }
            pager.setDatas(syjBlgosList);
            pager.setPageNo(PageNo);
            pager.setTotalno(totalPageCount);
            pager.setTotalsize(count);
            pager.setPageSize(PageSize);
        }
        return new ResponseEntity<>(pager, HttpStatus.OK);
    }


    //查询博客点赞人头像
    @PostMapping("dianzanrentou3")
    public ResponseEntity<?> dianzanrentou3(int Blogs_id){
        List<Integer> integerList = profilePageService.dianzanrentuo2(Blogs_id);//查询出所有点赞人的ID
        List<User> userList = new ArrayList<>();
        for (int i=0;i<integerList.size();i++){
            User user = profilePageService.selectUser(integerList.get(i));
            userList.add(user);
        }
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    //删除博客
    @PostMapping("deleteBoKe")
    public ResponseEntity<?> deleteBoKe(int Blogs_id){
    int count = profilePageService.deleteBoKe(Blogs_id);
    int count1 = profilePageService.deleteBoKe1(Blogs_id);
    int count2 =profilePageService.deleteBoKe2(Blogs_id);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    //查询权限
    @PostMapping("selectPrivacy")
    public ResponseEntity<?> selectPrivacy(int User_id){
        int zhuangtaima = -1;
       List<Privacy> privacyList =  profilePageService.selectPrivacy(User_id);
       if(privacyList!=null){
           for (int i=0;i<privacyList.size();i++){
               if (privacyList.get(i).getPrivacy_describe()==2){
                   if(privacyList.get(i).getPrivacy_state()==0){
                       zhuangtaima = 0;
                   }
                   if(privacyList.get(i).getPrivacy_state()==1){
                       zhuangtaima = 1;
                   }
                   if(privacyList.get(i).getPrivacy_state()==2){
                       zhuangtaima = 2;
                   }
               }
           }
       }else {
           zhuangtaima = -1;
       }
        return new ResponseEntity<>(zhuangtaima, HttpStatus.OK);
    }

    //查询共同好友
    @PostMapping("selectFriendAll")
    public ResponseEntity<?> selectFriendAll(int User_id,int Friend_user_id){
        int count = 0;
        List<Integer> integers = profilePageService.selectFriendAll(User_id);
        for (int i=0;i<integers.size();i++){
            if (Friend_user_id==integers.get(i)){
                count = 1;
            }
        }
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    //举报
    @PostMapping("jubao")
    public ResponseEntity<?> jubao(int Blogs_id,String Blogs_season){
       int count  = profilePageService.updJubao(Blogs_season,Blogs_id);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    //反馈
    @PostMapping("fankui")
    public ResponseEntity<?> fankui(int Blogs_id,String Blogs_season){
        int count  = profilePageService.updJubao(Blogs_season,Blogs_id);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }
}
