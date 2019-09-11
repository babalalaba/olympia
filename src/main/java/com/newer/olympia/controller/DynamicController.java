package com.newer.olympia.controller;

import com.newer.olympia.domain.Blogs;
import com.newer.olympia.domain.ReMap;
import com.newer.olympia.domain.User;
import com.newer.olympia.service.DynamicService;
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
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
public class DynamicController {
    @Autowired
    private DynamicService dynamicService;

    @GetMapping("/FindBrithdayTest")//好友生日查询
    public ResponseEntity<?> FindBrithdayTest(@Param("User_id") Integer User_id) {

        List<User> list = dynamicService.FindBirthday(User_id);
        return new ResponseEntity<>(list, HttpStatus.OK);


    }

    @GetMapping("/FindUserTest")//用户头像
    public ResponseEntity<?> FindUserTest(@Param("User_id") Integer User_id) {
        User user = dynamicService.FindUser(User_id);
        return new ResponseEntity<>(user, HttpStatus.OK);


    }
    @PostMapping("/FindUserTest1")//用户头像
    public ResponseEntity<?> FindUserTest1(@Param("User_id") Integer User_id) {
        User user = dynamicService.FindUser(User_id);
        return new ResponseEntity<>(user, HttpStatus.OK);


    }


    @PostMapping("dongTaiTest")//动态发布
    public ResponseEntity<?> dongTaiTest(Blogs blogs){
       User user =  dynamicService.selectUser(blogs.getUser_id());
    /*   if (user.getUser_state()==3)*/
        int count=dynamicService.addDongtai(blogs);
        if(count==1){System.out.println(blogs.getBlogs_content()+"-----------------");}

        return new ResponseEntity<>(count,HttpStatus.OK);

    }

    //根据用户ID 查询所有好友和自己发布的动态，按时间排序
    @GetMapping("findContentTest")
    public ResponseEntity<?> findContentTest(@Param("User_id")Integer User_id,HttpSession session){

        List<ReMap> reMapList=dynamicService.findContent(User_id);
        List<ReMap> reMapsList=new ArrayList<>();
        long time = new Date().getTime();
        reMapList.forEach(reMap -> {

            long a=time- reMap.getBlogs_time().getTime();
                    if(a/(1000*60*60*24)>=30) {
                        Double a1 = Double.valueOf(((a / (1000 * 60 * 60 * 24)) / 30));//long转Double类型
                        int a2 = (int) Math.floor(a1);
                        String a3 = a2 + "月前";
                        ReMap  reMaps=new ReMap();
                        reMaps.setUser_last_name(reMap.getUser_last_name());
                        reMaps.setUser_name(reMap.getUser_name());
                        reMaps.setUser_img(reMap.getUser_img());
                        reMaps.setBlogs_id(reMap.getBlogs_id());
                        reMaps.setBlogs_content(reMap.getBlogs_content());
                        reMaps.setHowTime(a3);
                        reMapsList.add(reMaps);

                    }else if(a/(1000*60*60)>=24) {
                        Double a1 = Double.valueOf(((a / (1000 * 60 * 60)) / 24));
                        int a2 = (int) Math.floor(a1);
                        String a3 = a2 + "天前";
                        ReMap  reMaps=new ReMap();
                        reMaps.setUser_last_name(reMap.getUser_last_name());
                        reMaps.setUser_name(reMap.getUser_name());
                        reMaps.setUser_img(reMap.getUser_img());
                        reMaps.setBlogs_id(reMap.getBlogs_id());
                        reMaps.setBlogs_content(reMap.getBlogs_content());
                        reMaps.setHowTime(a3);
                        reMapsList.add(reMaps);
                    }else if(a/(1000*60)>=60) {
                        Double a1 = Double.valueOf(((a / (1000 * 60)) / 60));
                        int a2 = (int) Math.floor(a1);
                        String a3 = a2 + "小时前";
                        ReMap  reMaps=new ReMap();
                        reMaps.setUser_last_name(reMap.getUser_last_name());
                        reMaps.setUser_name(reMap.getUser_name());
                        reMaps.setUser_img(reMap.getUser_img());
                        reMaps.setBlogs_id(reMap.getBlogs_id());
                        reMaps.setBlogs_content(reMap.getBlogs_content());
                        reMaps.setHowTime(a3);
                        reMapsList.add(reMaps);
                    }else if(a/(1000)>=60) {
                        Double a1 = Double.valueOf(((a / (1000)) / 60));
                        int a2 = (int) Math.floor(a1);
                        String a3 = a2 + "分钟前";
                        ReMap reMaps = new ReMap();
                        reMaps.setUser_last_name(reMap.getUser_last_name());
                        reMaps.setUser_name(reMap.getUser_name());
                        reMaps.setUser_img(reMap.getUser_img());
                        reMaps.setBlogs_id(reMap.getBlogs_id());
                        reMaps.setBlogs_content(reMap.getBlogs_content());
                        reMaps.setHowTime(a3);
                        reMapsList.add(reMaps);
                    }else if(a/(1000)<60) {
                        Double a1 = Double.valueOf((a / 1000));
                        int a2 = (int) Math.floor(a1);
                        String a3 = a2 + "秒前";
                        ReMap reMaps = new ReMap();
                        reMaps.setUser_last_name(reMap.getUser_last_name());
                        reMaps.setUser_name(reMap.getUser_name());
                        reMaps.setUser_img(reMap.getUser_img());
                        reMaps.setBlogs_id(reMap.getBlogs_id());
                        reMaps.setBlogs_content(reMap.getBlogs_content());
                        reMaps.setHowTime(a3);
                        reMapsList.add(reMaps);
                    }

        });
        return new ResponseEntity<>(reMapsList,HttpStatus.OK);

    }




    @GetMapping(value = "/myfile")
    public String file() {

        return "file";
    }




    @PostMapping(value = "myfileUpload")//上传
    public ResponseEntity<?> fileUpload(@RequestParam(value = "file") MultipartFile file, Model model, HttpServletRequest request,
                                        HttpSession session) {
         List<String> list=new ArrayList<>();

        if (file.isEmpty()) {
            System.out.println("文件为空");
        }

        String fileName = file.getOriginalFilename();  // 文件名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
        String filePath = "D://temp-rainy//"; // 上传后的路径
        fileName = UUID.randomUUID() + suffixName; // 新文件名
        File dest = new File(filePath + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String filename = fileName;
        model.addAttribute("filename", filename);
        list.add(filename);

        return new ResponseEntity<>(list,HttpStatus.OK);
    }











}
