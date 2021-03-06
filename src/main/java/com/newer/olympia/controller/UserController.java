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
import org.springframework.web.multipart.MultipartFile;

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
        System.out.println(a+"74");
        return new ResponseEntity<>(a, HttpStatus.OK);
    }

    //查询博客里的数量
    @PostMapping("/BlogsSize")
    public ResponseEntity<?> BlogsSize(Integer User_id) {
        List<Inform> blogs = userService.FindBlogs(User_id);
        return new ResponseEntity<>(blogs.size(), HttpStatus.OK);
    }

    //将未读博客信息改成已读
    @PostMapping("/UpdBlogsSize")
    public ResponseEntity<?> UpdBlogsSize(Inform b) {
        int i = userService.updateBlog(b);
        System.out.println(i + "修改成功");
        return new ResponseEntity<>(i, HttpStatus.OK);
    }

    //根据ID查询用户;查询加好友时用户更新后的信息
    @PostMapping("/FindUser")
    public ResponseEntity<?> FindUser(String User_name) {
        List<User> users = userService.findUserImg(User_name);
        System.out.println(users+"用户88");
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


    @RequestMapping("/allPicture")
    public ResponseEntity<?> allPicture(@RequestParam(value = "file",required = false)MultipartFile file,
                                        @RequestParam("User_name") String User_name) {
        System.out.println(User_name+"141314");
        System.out.println(file+"888888===");
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
       /* Picture p=new Picture();
        p.setPicture_path(filePath);
        p.setUser_id(User_id);
        int i = userService.allPicture(p);
        System.out.println(i + "上传成功");
        System.out.println(p.getPicture_id());
        int Picture_id= p.getPicture_id();*/
        int i = userService.updUsering(filePath, User_name);
        System.out.println(i + "上传成功");
        return new ResponseEntity<>(i, HttpStatus.OK);
    }
   /* //查询上传照片
    @PostMapping("/FindMessages")
    public ResponseEntity<?> PictureAllBy(Integer User_id) {
        List<Picture> pictures = userService.PictureAllBy(User_id);
        System.out.println(pictures);
        return new ResponseEntity<>(pictures, HttpStatus.OK);
    }*/
   //根据ID查询用户
   @PostMapping("/FindUsering")
   public ResponseEntity<?> FindUsering(Integer User_id) {
       List<User> users = userService.FindUser(User_id);
       return new ResponseEntity<>(users, HttpStatus.OK);
   }
}