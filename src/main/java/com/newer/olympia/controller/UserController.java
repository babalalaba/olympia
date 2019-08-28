package com.newer.olympia.controller;

import com.newer.olympia.domain.*;
import com.newer.olympia.service.UserService;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadBase;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/app")
public class UserController {
    @Autowired
    private UserService userService;

    //查询博客评论
    @GetMapping("/FindBlogs")
    public ResponseEntity<?> FindBlogs(Integer User_id) {
        List<Inform> a = userService.FindBlogs(User_id);
        System.out.println(a + "....===");
        return new ResponseEntity<>(a, HttpStatus.OK);
    }

    //查询博客里的数量
    @PostMapping("/BlogsSize")
    public ResponseEntity<?> BlogsSize(Integer User_id) {
        List<Inform> blogs = userService.FindBlogs(User_id);
        System.out.println(blogs.size() + "博客");
        return new ResponseEntity<>(blogs.size(), HttpStatus.OK);
    }

    //将未读博客信息改成已读
    @PostMapping("/UpdBlogsSize")
    public ResponseEntity<?> UpdBlogsSize(Inform b) {
        int i = userService.updateBlog(b);
        System.out.println(i + "修改成功");
        return new ResponseEntity<>(i, HttpStatus.OK);
    }

    //查询所有用户
    @PostMapping("/FindUser")
    public ResponseEntity<?> FindUser() {
        List<User> users = userService.FindUser();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    //查询用户，并显示头像
    @GetMapping("/usersession")
    public ResponseEntity<?> usersession(HttpSession session) {
        User ad = (User) session.getAttribute("ad");
        System.out.println(ad);
        return new ResponseEntity<>(ad, HttpStatus.OK);
    }



    //查询留言板
    @PostMapping("/FindMessages")
    public ResponseEntity<?> FindMessages(Integer User_id) {
        List<Messages> messages = userService.FindMessages(User_id);
        System.out.println(messages + "yyy");
        return new ResponseEntity<>(messages, HttpStatus.OK);
    }

    //查询留言板里的数量
    @PostMapping("/MessagesSize")
    public ResponseEntity<?> MessagesSize(Integer User_id) {
        List<Messages> messages = userService.FindMessages(User_id);
        System.out.println(messages.size() + "大小");
        return new ResponseEntity<>(messages.size(), HttpStatus.OK);
    }

    @PostMapping("/updMessagesSize")
    public ResponseEntity<?> updMessagesSize(Messages m) {
        int i = userService.updMessagesAll(m);
        System.out.println(i + "大");
        return new ResponseEntity<>(i, HttpStatus.OK);
    }

    /* @PostMapping("/updMessagesAll")
     public ResponseEntity<?> updMessagesAll(Messages m){
         int i = userService.updMessagesAll(m);
         System.out.println(i+"大小");
         return new ResponseEntity<>(i,HttpStatus.OK);
     }*/
    @PostMapping("/delMessagesAll")
    public ResponseEntity<?> delMessagesAll(Integer Messages_id) {
        int i = userService.delMessagesAll(Messages_id);
        System.out.println(i + "删除成功");
        return new ResponseEntity<>(i, HttpStatus.OK);
    }

    @PostMapping("/allPicture")
    public ResponseEntity<?> allPicture(Integer User_id) {
        List<Picture> pictures = userService.allPicture(User_id);
        System.out.println(pictures + "上传成功");
        return new ResponseEntity<>(pictures, HttpStatus.OK);
    }

    @PostMapping("/createImg ")
    public void createImg(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.err.println("=====");
        Part shangchuan = request.getPart("shangchuan");
        InputStream in = shangchuan.getInputStream();

        FileOutputStream fos = new FileOutputStream("H:\\spring\\nginx-1.16.0\\html\\word\\imgs");

        byte[] buf = new byte[1024];
        int len;
        while ((len = in.read(buf)) != -1) {
            fos.write(buf, 0, len);
        }
        System.err.println("=====");
    }
}