package com.newer.olympia.controller;

import com.newer.olympia.domain.Admis;
import com.newer.olympia.domain.Blogs;
import com.newer.olympia.domain.Blogs2;
import com.newer.olympia.domain.User;
import com.newer.olympia.service.AdminService;
import com.newer.olympia.service.PersonalCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//管理员controller
//开发人员：易霖
@RestController
public class adminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private PersonalCenterService personalCenterService;
    @PostMapping("adLogin")
    public ResponseEntity<?> adLogin(String Admis_username,String Admis_pwd){
        System.out.println("username:"+Admis_username);
        System.out.println("password:"+Admis_pwd);
        Admis admis=adminService.selAdmis(Admis_username);
        //查到数据返回一个用户对象
        if (admis!=null){
            if (admis.getAdmis_pwd().equals(Admis_pwd)){
                return new ResponseEntity<>(admis,HttpStatus.OK);
            }else {
                return new ResponseEntity<>(2,HttpStatus.OK);
            }

        }
        //登录失败返回2
        return new ResponseEntity<>(1, HttpStatus.OK);
    }
    @PostMapping("loadUser")
    public  ResponseEntity<?> loadUser(int userId){
        Admis admis=adminService.selAdmisByUser_id(userId);
        return new ResponseEntity<>(admis,HttpStatus.OK);
    }
    //更新管理员密码
    @PostMapping("updAdmPwd")
    public ResponseEntity<?> updAdmPwd(int admis_id,String pwd,String pwd1,String pwd2){
        Admis admis1=adminService.selAdmisByUser_id(admis_id);
        if (admis1.getAdmis_pwd().equals(pwd)){
            if(pwd1.equals(pwd2)){
                Admis admis=new Admis();
                admis.setAdmis_id(admis_id);
                admis.setAdmis_pwd(pwd1);
                int count=adminService.updAdmPwd(admis);
                if (count>0){
                    return new ResponseEntity<>(4,HttpStatus.OK);//修改成功
                }else{
                    return new ResponseEntity<>(3,HttpStatus.OK);//修改失败
                }//修改密码if结束
            }else {
                return new ResponseEntity<>(2,HttpStatus.OK);//新密码与确认密码不一致
            }//判断两次新密码输入if结束
        }else {
            return new ResponseEntity<>(1,HttpStatus.OK);//原密码不正确
        }//判断旧密码是否正确if结束
    }
    //查询违规的帖子数量
    @PostMapping("selblogRep")
    public ResponseEntity<?> selblogRep(){
        List<Blogs> list=adminService.selblogRep();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    //查询帖子和用户的详细信息
    @PostMapping("selBlogByBlogId")
    public ResponseEntity<?> selBlogByBlogId(int user_id,int blogs_id){
        User user=personalCenterService.selUserByUserId(user_id);
        Blogs blogs=adminService.selblogByBlogsId(blogs_id);
        List list=new ArrayList();
        list.add(user);
        list.add(blogs);
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    @PostMapping("ywgFinal")
    public ResponseEntity<?> ywgFinal(int Blogs_id,String Blogs_season){
        //删除前的帖子
        Blogs blogs1=adminService.selblogByBlogsId(Blogs_id);
        blogs1.setBlogs_state(3);
        Blogs blogs2=adminService.selblogByBlogsId(Blogs_id);
        blogs2.setBlogs_content("该帖已违规，请联系管理员处理");
        blogs2.setBlogs_img(null);
        blogs2.setBlogs_state(3);
        blogs2.setBlogs_season(Blogs_season);
        int count1=adminService.BackupBlog(blogs1);
        if (count1>0){
            int count2=adminService.updBlogs(blogs2);
            if (count2>0){
                return new ResponseEntity<>(1,HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(2,HttpStatus.OK);
    }
    //处理被驳回的帖子任然有违规时执行以下方法
    @PostMapping("ywgFinalAg")
    public ResponseEntity<?> ywgFinalAg(int Blogs_id,String Blogs_season){
        //删除前的帖子
        Blogs blogs1=adminService.selblogByBlogsId(Blogs_id);
        blogs1.setBlogs_state(3);
        Blogs blogs2=adminService.selblogByBlogsId(Blogs_id);
        blogs2.setBlogs_content("该帖已违规，请联系管理员处理");
        blogs2.setBlogs_img(null);
        blogs2.setBlogs_state(3);
        blogs2.setBlogs_season(Blogs_season);
            int count2=adminService.updBlogs(blogs2);
            if (count2>0){
                return new ResponseEntity<>(1,HttpStatus.OK);
        }
        return new ResponseEntity<>(2,HttpStatus.OK);
    }

    //无违规的操作
    @PostMapping("wwgFinal")
    public ResponseEntity<?> wwgFinal(int Blogs_id){
        Blogs blogs=adminService.selblogByBlogsId(Blogs_id);
        blogs.setBlogs_state(1);
        blogs.setBlogs_season("");
        int count=adminService.wwgBlogs(blogs);
        if (count>0){
                return new ResponseEntity<>(1,HttpStatus.OK);
        }
        return new ResponseEntity<>(2,HttpStatus.OK);
    }
    //对无违规的驳回帖子做更改，并删除备份帖
    @PostMapping("wwgFinal2")
    public ResponseEntity<?> wwgFinal2(int Blogs_id){
        Blogs2 blogs2=adminService.selblog2ByBlogsId(Blogs_id);
        blogs2.setBlogs_state(1);
        blogs2.setBlogs_season("");
        int count=adminService.wwgBlogs2(blogs2);
        //修改成功后，删除
        if (count>0){
            int count2=adminService.delBlogs2(Blogs_id);
            if (count2>0){
                return new ResponseEntity<>(1,HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(2,HttpStatus.OK);
    }


    //查询被驳回的帖子
    @PostMapping("selblogReject")
    public ResponseEntity<?> selblogReject(){
        List<Blogs> list=adminService.selblogReject();
        System.out.println(list);
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    //根据用户驳回的帖子id查询当前帖子
    @PostMapping("selBlog2ByBlogId")
    public ResponseEntity<?> selBlog2ByBlogId(int user_id,int blogs_id){
        User user=personalCenterService.selUserByUserId(user_id);
        Blogs2 blogs=adminService.selblog2ByBlogsId(blogs_id);
        List list=new ArrayList();
        list.add(user);
        list.add(blogs);
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    @PostMapping("selUser")
    public ResponseEntity<?> selUser(int userId){
        User user=personalCenterService.selUserByUserId(userId);
        List<Blogs> list=adminService.selBlogByUser(userId);
        int UserVio=0;
        for (int i=0;i<list.size();i++){
            if (list.get(i).getBlogs_state().equals(3)){
                UserVio++;
            }
        }
        List list1=new ArrayList();
        list1.add(UserVio);
        list1.add(user);
        list1.add(list);
        return new ResponseEntity<>(list1,HttpStatus.OK);
    }

    @PostMapping("gbUserSta")
    public ResponseEntity<?> gbUserSta(int User_id,int User_safety){
        int count=adminService.gbUserSta(User_id,User_safety);
        if (count>0){
            return new ResponseEntity<>(1,HttpStatus.OK);
        }else {
            return new ResponseEntity<>(2,HttpStatus.OK);
        }
    }
    @PostMapping("selZl")
    public ResponseEntity<?> selZl(){
        int bk=adminService.selBlogNum2().size();
        int dt=adminService.selBlogNum1().size();
        int jb=adminService.selblogRep().size();
        int bh=adminService.selblogReject().size();
        Map<String,Integer> map=new HashMap<>();
        map.put("bk",bk);
        map.put("dt",dt);
        map.put("jb",jb);
        map.put("bh",bh);
        return new ResponseEntity<>(map,HttpStatus.OK);
    }
}
