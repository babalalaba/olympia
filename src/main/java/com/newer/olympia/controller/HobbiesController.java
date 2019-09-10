package com.newer.olympia.controller;/*
 *@author  yangdu
 *@date 2019/8/28 - 14:07
 * */

import com.newer.olympia.domain.*;
import com.newer.olympia.service.HobbiesService;
import com.newer.olympia.util.Pager2;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/app")
public class HobbiesController {
    @Autowired
    private HobbiesService hobbiesService;

    @PostMapping("/HobbiesAll")
    public ResponseEntity<?> HobbiesAll(Integer User_id) {
        List<Hobbies> hobbies = hobbiesService.hobbiesAll(User_id);
        System.out.println(hobbies);
        return new ResponseEntity<>(hobbies, HttpStatus.OK);
    }

    @PostMapping("/BlogsAlls")
    public ResponseEntity<?> BlogsAlls(Integer User_id) {
        List<Blogs> blogs = hobbiesService.BlogsAll(User_id);
        System.out.println(blogs + "主页博客显示");
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    @GetMapping("/AlbumAlls")
    public ResponseEntity<?> AlbumAlls(Integer User_id) {
        List<Album> albums = hobbiesService.AlbumAll(User_id);
        return new ResponseEntity<>(albums, HttpStatus.OK);
    }

    @GetMapping("/FriendAll")
    public ResponseEntity<?> FriendAll(Integer User_id) {
        List<Friend> friends = hobbiesService.FriendAll(User_id);
        return new ResponseEntity<>(friends, HttpStatus.OK);
    }

    //好友数量
    @GetMapping("/FriendSize")
    public ResponseEntity<?> FriendSize(Integer User_id) {
        List<Friend> friends = hobbiesService.FriendAll(User_id);
        return new ResponseEntity<>(friends.size(), HttpStatus.OK);
    }

    @GetMapping("/MedalAll")
    public ResponseEntity<?> MedalAll(Integer User_id) {
        List<Medal_user> medal_users = hobbiesService.MedalAll(User_id);
        return new ResponseEntity<>(medal_users, HttpStatus.OK);
    }

    /**
     * @param friend   是否同意 同意传1 不同意 传2
     * @param Apply_id 操作的数据id
     * @return
     */
    @GetMapping("/FirendApply")
    public ResponseEntity<?> FirendApply(Integer friend, Integer Apply_id) {
        Integer code = hobbiesService.friend(friend, Apply_id);
        return new ResponseEntity<>(code, HttpStatus.OK);
    }

    /**
     * 查询 所有待添加的好友
     *
     * @param User_id 当前登录对象id
     * @return
     */
    @GetMapping("/findAllByUser")
    public ResponseEntity<?> findAllByUser(Integer User_id) {
        List<Apply> applyList = hobbiesService.findAllByUser(User_id);
        System.out.println(applyList + "好友");
        return new ResponseEntity<>(applyList, HttpStatus.OK);
    }

    //申请数量
    @PostMapping("/findUserSize")
    public ResponseEntity<?> findUserSize(Integer User_id) {
        List<Apply> applyList = hobbiesService.findAllByUser(User_id);
        System.out.println(applyList.size() + "申请人数");
        return new ResponseEntity<>(applyList.size(), HttpStatus.OK);
    }

    //查找有这个用户。就往申请表添加数据
    @GetMapping("/insertApplys")
    public ResponseEntity<?> insertApplys(Apply apply) {
        int i = hobbiesService.insertApplys(apply);
        System.out.println(i + "申请成功");
        return new ResponseEntity<>(i, HttpStatus.OK);
    }

    //查询主页博客好友点赞
    @PostMapping("/FindUtableall")
    public ResponseEntity<?> FindUtableall(Integer User_id, Integer Blogs_id) {
        System.out.println(User_id + "1414");
        System.out.println(Blogs_id + "1313");
        int a = 0;
        User_table table = hobbiesService.Utablealling(User_id, Blogs_id);
        //判断时候要该用户点赞，
        if (table != null) {
            System.out.println("有该记录");
            hobbiesService.delUtable(table.getUser_table_id());
            a = a + 1;
        } else {
            System.out.println("没有记录：");
            User_table table1 = new User_table();
            table1.setUser_id(User_id);
            table1.setBlogs_id(Blogs_id);
            table1.setStatus(1);
            table1.setUser_table_time(new Date());
            hobbiesService.inserUtable(table1);
            a = a + 2;
            System.out.println(table1 + "好友头像");
        }
        return new ResponseEntity<>(a, HttpStatus.OK);
    }

    @GetMapping("/inserUtable")
    public ResponseEntity<?> inserUtable(User_table u) {
        u.setUser_table_time(new Date());
        int i = hobbiesService.inserUtable(u);
        System.out.println(i + "添加点赞成功");
        return new ResponseEntity<>(i, HttpStatus.OK);
    }

    @GetMapping("/delUtable")
    public ResponseEntity<?> delUtable(Integer User_table_id) {
        int i = hobbiesService.delUtable(User_table_id);
        System.out.println(i + "取消点赞成功");
        return new ResponseEntity<>(i, HttpStatus.OK);
    }

    @GetMapping("/updateUtable")
    public ResponseEntity<?> updateUtable(User_table u) {
        int i = hobbiesService.updateUtable(u);
        System.out.println(i + "修改点赞成功");
        return new ResponseEntity<>(i, HttpStatus.OK);
    }

    @PostMapping("/UtableSize")
    public ResponseEntity<?> UtableSize(Integer User_id, Integer Blogs_id) {
        List<User_table> user_tables = hobbiesService.FindUtableall(User_id, Blogs_id);
        return new ResponseEntity<>(user_tables.size(), HttpStatus.OK);
    }

    //查询主页博客好友点赞
    @PostMapping("/Utabledu")
    public ResponseEntity<?> Utabledu(Integer User_id, Integer Blogs_id) {
        List<User_table> user_tables = hobbiesService.FindUtableall(User_id, Blogs_id);
        System.out.println(user_tables + "5656");
        return new ResponseEntity<>(user_tables, HttpStatus.OK);
    }

    @PostMapping("/insertComment")
    public ResponseEntity<?> insertComment(Comment c) {
        c.setComment_time(new Date());
        int i = hobbiesService.insertComment(c);
        System.out.println(i + "增加评论成功");
        return new ResponseEntity<>(i, HttpStatus.OK);
    }

    //根据发布的动态ID 查询该用户发布的动态下所有的评论
    @PostMapping("/selectCommentAllByid")
    public ResponseEntity<?> selectCommentAllByid(@Param("User_id") int User_id, @Param("Blogs_id") int Blogs_id, @Param("pageNo") int pageNo) {
        if (pageNo==0) {
            pageNo = 1;
        }
        int pageNoSize=3;
        int pageNo1 = (pageNo-1) * pageNoSize;
        System.out.println(pageNo1 + "首页");
        System.out.println(pageNoSize + "大小");
        int totlaPage = hobbiesService.selectTotlaPage(Blogs_id);
        List<FriendComment> friendComments = hobbiesService.selectCommentAllByid(User_id, Blogs_id, pageNo1,pageNoSize);
        List<FriendComment> commentList = new ArrayList<>();
        //封装总页数
        double tc = totlaPage;
        Double num = Math.ceil(tc / pageNoSize);//向上取整
        Pager2 pager = new Pager2();
        long time = new Date().getTime();
        int finalPageNo = pageNo;
        friendComments.forEach(friendComment -> {
            long a = time - friendComment.getComment_time().getTime();
            if (a / (1000 * 60 * 60 * 24) >= 30) {
                Double a1 = Double.valueOf(((a / (1000 * 60 * 60 * 24)) / 30));
                int a2 = (int) Math.floor(a1);
                String a3 = a2 + "月天前";
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
                pager.setPageNo(pageNo1);
                pager.setPageSize(pageNoSize);
                pager.setTotlaPage(num.intValue());
            } else if (a / (1000 * 60 * 60) >= 24) {
                Double a1 = Double.valueOf(((a / (1000 * 60 * 60)) / 24));
                int a2 = (int) Math.floor(a1);
                String a3 = a2 + "天前";
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
                pager.setPageNo(pageNo1);
                pager.setPageSize(pageNoSize);
                pager.setTotlaPage(num.intValue());;
            } else if (a / (1000 * 60) >= 60) {
                Double a1 = Double.valueOf(((a / (1000 * 60)) / 60));
                int a2 = (int) Math.floor(a1);
                String a3 = a2 + "小时前";
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
                pager.setPageSize(pageNoSize);
                pager.setPageNo(pageNo1);
                pager.setTotlaPage(num.intValue());
            } else if (a / (1000) >= 60) {
                Double a1 = Double.valueOf(((a / (1000)) / 60));
                int a2 = (int) Math.floor(a1);
                String a3 = a2 + "分钟前";
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
                pager.setPageSize(pageNoSize);
                pager.setPageNo(pageNo1);
                pager.setTotlaPage(num.intValue());
            } else if (a / (1000) < 60) {
                Double a1 = Double.valueOf((a / 1000));
                int a2 = (int) Math.floor(a1);
                String a3 = a2 + "秒前";
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
                pager.setPageSize(pageNoSize);
                pager.setPageNo(pageNo1);
                pager.setTotlaPage(num.intValue());
            }
        });
        System.out.println(pager + "7878");
        return new ResponseEntity<>(pager, HttpStatus.OK);
    }

    //根据用户ID 查询所有发布的动态
    @PostMapping("selectBlogsAlling")
    public ResponseEntity<?> selectBlogsAlling() {
        List<SyjBlgos> blogs = hobbiesService.selectBlogsAllByid();
        System.out.println(blogs + "ooo7");
        List<SyjBlgos> syjBlgosList = new ArrayList<>();
        long time = new Date().getTime();
        blogs.forEach(blogs1 -> {
            long a = time - blogs1.getBlogs_time().getTime();
            if (a / (1000 * 60 * 60 * 24) >= 30) {
                Double a1 = Double.valueOf(((a / (1000 * 60 * 60 * 24)) / 30));
                int a2 = (int) Math.floor(a1);
                String a3 = a2 + "月天前";
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
                syjBlgos.setUser_table(blogs1.getUser_table());
                syjBlgosList.add(syjBlgos);
            } else if (a / (1000 * 60 * 60) >= 24) {
                Double a1 = Double.valueOf(((a / (1000 * 60 * 60)) / 24));
                int a2 = (int) Math.floor(a1);
                String a3 = a2 + "天前";
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
                syjBlgos.setUser_table(blogs1.getUser_table());
                syjBlgosList.add(syjBlgos);
            } else if (a / (1000 * 60) >= 60) {
                Double a1 = Double.valueOf(((a / (1000 * 60)) / 60));
                int a2 = (int) Math.floor(a1);
                String a3 = a2 + "小时前";
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
                syjBlgos.setUser_table(blogs1.getUser_table());
                syjBlgosList.add(syjBlgos);
            } else if (a / (1000) >= 60) {
                Double a1 = Double.valueOf(((a / (1000)) / 60));
                int a2 = (int) Math.floor(a1);
                String a3 = a2 + "分钟前";
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
                syjBlgos.setUser_table(blogs1.getUser_table());
                syjBlgosList.add(syjBlgos);
            } else if (a / (1000) < 60) {
                Double a1 = Double.valueOf((a / 1000));
                int a2 = (int) Math.floor(a1);
                String a3 = a2 + "秒前";
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
                syjBlgos.setUser_table(blogs1.getUser_table());
                syjBlgosList.add(syjBlgos);
            }

        });
        return new ResponseEntity<>(syjBlgosList, HttpStatus.OK);

    }

    //根据文章ID 查询点赞人数
    @PostMapping("/selectLike")
    public ResponseEntity<?> selectLike(@Param("Blogs_id") int Blogs_id) {
        List<User_table> user_tables = hobbiesService.selectLike(Blogs_id);
        final int[] like = {0};
        user_tables.forEach(user_table -> {
            if (user_table.getStatus() == 1) {
                like[0]++;
            }
        });
        return new ResponseEntity<>(like, HttpStatus.OK);
    }

    //根据用户ID和动态ID 查询该动态下的所有评论的评论数
    @PostMapping("/selectCommentCount")
    public ResponseEntity<?> selectCommentCount(@Param("User_id") int User_id, @Param("Blogs_id") int Blogs_id) {
        int count = hobbiesService.selectCommentCount(User_id, Blogs_id);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    //查询主页博客好友点赞
    @PostMapping("/Utablealltupian")
    public ResponseEntity<?> Utablealltupian(Integer User_id, Integer Blogs_id) {
        List<User_table> table = hobbiesService.User_tableing(User_id, Blogs_id);
        System.out.println(table + "好友头像888=====");
        return new ResponseEntity<>(table, HttpStatus.OK);
    }

    @PostMapping("/delBlogsing")
    public ResponseEntity<?> delBlogsing(Integer Blogs_id) {
        int i = hobbiesService.delBlogsing(Blogs_id);
        System.out.println(i + "删除主页博客");
        return new ResponseEntity<>(i, HttpStatus.OK);
    }

    //控制主页博客数
    @PostMapping("/delBlogsSize")
    public ResponseEntity<?> delBlogsSize(Integer pageNo) {
        if (pageNo==0) {
            pageNo = 0;
        }
        int pageNoSize=10;
        int pageNo1 = pageNo * pageNoSize;
        System.out.println(pageNo1 + "首页");
        System.out.println(pageNoSize + "大小");
        int totlaPage = hobbiesService.TotlaPage();//总页数
        Pager2 pager = new Pager2();
        //封装总页数
        double tc = totlaPage;
        Double num = Math.ceil(tc / pageNoSize);//向上取整
        List<SyjBlgos> blogs = hobbiesService.selectBlogsAllByiding(pageNo, pageNoSize);
        List<SyjBlgos> syjBlgosList = new ArrayList<>();
        long time = new Date().getTime();
        Integer finalPageNo = pageNo;
        blogs.forEach(blogs1 -> {
            long a = time - blogs1.getBlogs_time().getTime();
            if (a / (1000 * 60 * 60 * 24) >= 30) {
                Double a1 = Double.valueOf(((a / (1000 * 60 * 60 * 24)) / 30));
                int a2 = (int) Math.floor(a1);
                String a3 = a2 + "月天前";
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
                syjBlgos.setUser_table(blogs1.getUser_table());
                syjBlgosList.add(syjBlgos);
                pager.setPageNo(finalPageNo);//当前页
                pager.setResult(syjBlgosList);
                //pager.setTotlaPage(totlaPage);
                pager.setTotlaPage(num.intValue());
                pager.setPageSize(pageNoSize);
            } else if (a / (1000 * 60 * 60) >= 24) {
                Double a1 = Double.valueOf(((a / (1000 * 60 * 60)) / 24));
                int a2 = (int) Math.floor(a1);
                String a3 = a2 + "天前";
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
                syjBlgos.setUser_table(blogs1.getUser_table());
                syjBlgosList.add(syjBlgos);
                pager.setPageNo(finalPageNo);//当前页
                pager.setResult(syjBlgosList);
                pager.setTotlaPage(num.intValue());
                pager.setPageSize(pageNoSize);
            } else if (a / (1000 * 60) >= 60) {
                Double a1 = Double.valueOf(((a / (1000 * 60)) / 60));
                int a2 = (int) Math.floor(a1);
                String a3 = a2 + "小时前";
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
                syjBlgos.setUser_table(blogs1.getUser_table());
                syjBlgosList.add(syjBlgos);
                pager.setPageNo(finalPageNo);//当前页
                pager.setResult(syjBlgosList);
                pager.setTotlaPage(num.intValue());
                pager.setPageSize(pageNoSize);
            } else if (a / (1000) >= 60) {
                Double a1 = Double.valueOf(((a / (1000)) / 60));
                int a2 = (int) Math.floor(a1);
                String a3 = a2 + "分钟前";
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
                syjBlgos.setUser_table(blogs1.getUser_table());
                syjBlgosList.add(syjBlgos);
                pager.setPageNo(finalPageNo);//当前页
                pager.setResult(syjBlgosList);
                pager.setTotlaPage(num.intValue());
                pager.setPageSize(pageNoSize);
            } else if (a / (1000) < 60) {
                Double a1 = Double.valueOf((a / 1000));
                int a2 = (int) Math.floor(a1);
                String a3 = a2 + "秒前";
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
                syjBlgos.setUser_table(blogs1.getUser_table());
                syjBlgosList.add(syjBlgos);
                pager.setPageNo(finalPageNo);//当前页
                pager.setResult(syjBlgosList);
                pager.setTotlaPage(num.intValue());
                pager.setPageSize(pageNoSize);
            }

        });
        System.out.println(pager + "6767");
        return new ResponseEntity<>(pager, HttpStatus.OK);
    }
    @PostMapping("/updataUsertitle_img")
    public ResponseEntity<?> updataUsertitle_img(@RequestParam(value = "file",required = false)MultipartFile file,
                                                 @RequestParam("User_name") String User_name){
        System.out.println(file+"888888===");
        System.out.println(User_name+"888888===");
        String filePath = null;
        if (!file.isEmpty()) {
            try {
                // 文件保存路径
                filePath = "H:\\spring\\nginx-1.16.0\\html\\word\\img\\"+User_name+".jpg";
                System.out.println(filePath);
                // 转存文件
                file.transferTo(new File(filePath));
                /*filePath = "imgs/"+User_id+"/.jpg";*/
                filePath = "/"+User_name+".jpg";
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        int i = hobbiesService.updataUsertitle_img(filePath, User_name);
        System.out.println(i+"上传背景成功");
        return  new ResponseEntity<>(i,HttpStatus.OK);
    }
}
