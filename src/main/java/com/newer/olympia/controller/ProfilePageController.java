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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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
        Pager<FriendComment> pager = new Pager<FriendComment>();
        long time = new Date().getTime();
        int finalPageNo = pageNo;
        friendComments.forEach(friendComment -> {
            long a =   time-friendComment.getComment_time().getTime();
            if(a/(1000*60*60*24)>=30){
                Double a1 = Double.valueOf(((a/(1000*60*60*24))/30));
                int a2 =(int)Math.floor(a1);
                String a3 = a2+"月前";
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
                pager.setDatas(commentList);
                pager.setPageNo(finalPageNo);
                pager.setTotalno(totlaPage);
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
                pager.setDatas(commentList);
                pager.setPageNo(finalPageNo);
                pager.setTotalno(totlaPage);
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
                pager.setDatas(commentList);
                pager.setPageNo(finalPageNo);
                pager.setTotalno(totlaPage);
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
                pager.setDatas(commentList);
                pager.setPageNo(finalPageNo);
                pager.setTotalno(totlaPage);
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
                pager.setDatas(commentList);
                pager.setPageNo(finalPageNo);
                pager.setTotalno(totlaPage);
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


   @PostMapping("selectFriendCount")
    public ResponseEntity<?> selectFriendCount(@Param("User_id")int User_id){
        int count = profilePageService.selectFriendCount(User_id);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    @PostMapping("deleteFriend")
    public ResponseEntity<?> deleteFriend(@Param("User_id")int User_id,@Param("Friend_user_id")int Friend_user_id){
        int count = profilePageService.deleteFriend(User_id,Friend_user_id);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    @GetMapping(value = "/file")
    public String file() {
        return "file";
    }

    //上传照片创建相册
    @PostMapping("/fileUpload")
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
                profilePagePhotos07.setAlbum_like(albums.get(i).getAlbum_like());
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

}
