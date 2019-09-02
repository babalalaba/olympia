package com.newer.olympia.controller;

import com.alibaba.fastjson.JSONObject;
import com.newer.olympia.domain.Encrypted;
import com.newer.olympia.domain.Privacy;
import com.newer.olympia.domain.User;
import com.newer.olympia.service.PersonalCenterService;
import com.newer.olympia.util.HttpUtils;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//Controller作用模块：个人中心
//创建人员：易霖
//本Controller功能目前为1、连接阿里云国家行政区规划数据库API 2、连接userServlet拿到用户表user中的数据和更改user数据
@RestController
public class PersonalCenterController {
    @Autowired
    private PersonalCenterService personalCenterService;
    //查询行政规划数据库
    @PostMapping("/SelMap")
    public ResponseEntity<?> SelMap(){
        String host = "https://jisuarea.market.alicloudapi.com";
        String path = "/area/all";
        String method = "GET";
        String appcode = "2ccf2dad6532416e83135df2be9fabc4";
        Map<String, String> headers = new HashMap<String, String>();
        //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();
        try {
            HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
            return new ResponseEntity<>(EntityUtils.toString(response.getEntity()), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(false, HttpStatus.OK);
    }

    @PostMapping("/selUserByUserId")
    public  ResponseEntity<?> selUserByUserId(int User_id){
        User user=personalCenterService.selUserByUserId(User_id);
        if (user!=null){
            return new ResponseEntity<>(user,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.OK);
    }
    @PostMapping("/subPro")
    public ResponseEntity<?> subPro(User user){
        int count=personalCenterService.subProByUserId(user);
        if (count>0){
            return new ResponseEntity<>(count,HttpStatus.OK);
        }
        return new ResponseEntity<>(0,HttpStatus.OK);
    }
    @PostMapping("SelPri")
    public ResponseEntity<?> SelPri(int User_id){
        List<Privacy> list=personalCenterService.SelPri(User_id);

        if (list!=null){
            return new ResponseEntity<>(list,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.OK);
    }
    @PostMapping("UpdPri")
    public ResponseEntity<?>  UpdPri(int Privacy_describe1,int Privacy_describe2,int Privacy_describe3,int Privacy_describe4,
                                     int User_id){
        /*for(int i=1;i<=4;i++){
            Privacy privacy=new Privacy();
            privacy.setPrivacy_describe(i);
            if (i==2){
                privacy.setPrivacy_describe(8);
            }
            privacy.setPrivacy_state(Privacy_describe1);
            privacy.setUser_id(User_id);
            int count=personalCenterService.UpdPri(privacy);
            //如果其中一条数据修改失败，则回滚保存的数据
            if (count==0){
                try{
                    System.out.println("问题"+i+"保存失败！抛异常，数据回滚！");
                    int a=6/0;
                }catch (Exception e){

                    throw new RuntimeException("没保存成功，抛异常了！！！");
                }
                return new ResponseEntity<>(false,HttpStatus.OK);
            }else {
                System.out.println("问题"+i+"保存成功！");
            }
        }
        return new ResponseEntity<>(true,HttpStatus.OK);*/
        try{
            boolean test=personalCenterService.test(Privacy_describe1,Privacy_describe2,Privacy_describe3,Privacy_describe4,User_id);
            return new ResponseEntity<>(true,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(false,HttpStatus.OK);
        }

    }

    //查询密保问题
    @PostMapping("/selEncQueByUserId")
    public ResponseEntity<?> selEncQueByUserId(int User_id){
        List<Encrypted> list=personalCenterService.selEncQueByUserId(User_id);
        if (list.size()>0){
            return new ResponseEntity<>(list,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.OK);
    }
    //验证用户输入的问题与数据库里的是否一致
    @PostMapping("/selEncAnsByUserId")
    public ResponseEntity<?> selEncAnsByUserId(String ans1,String ans2,String ans3,int user_id){
        String ans[]={ans1,ans2,ans3};
        List<Encrypted> list=personalCenterService.selEncAnsByUserId(user_id);
        for(int i=0;i<list.size();i++){
            if (!ans[i].equals(list.get(i).getEncrypted_answer())){
                return new ResponseEntity<>(false,HttpStatus.OK);
            };
        }
        return new ResponseEntity<>(true,HttpStatus.OK);
    }
    //保存密保
    @PostMapping("updEncrypted")
    public ResponseEntity<?> updEncrypted(int que1Id,String que1,String ans1,int que2Id,String que2,String ans2,int que3Id,String que3,String ans3,int User_id){
        Encrypted encrypted = null;
        for(int i=1;i<4;i++){
            if (i==1){
                encrypted=new Encrypted(que1Id,que1,ans1,User_id);
            }else if (i==2){
                encrypted=new Encrypted(que2Id,que2,ans2,User_id);
            }else if (i==3){
                encrypted=new Encrypted(que3Id,que3,ans3,User_id);
            }
            int count=personalCenterService.updEncrypted(encrypted);
            if (count==0){
                return new ResponseEntity<>(false,HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(true,HttpStatus.OK);
    }
    //修改用户密码
    @PostMapping("upPwdByUserId")
    public ResponseEntity<?> upPwdByUserId(int User_id,String pwd,String pwd1,String pwd2){
        User user=personalCenterService.selUserByUserId(User_id);
        if (pwd.equals(user.getUser_pwd())){
            if(pwd1.equals(pwd2)){
                int count=personalCenterService.upPwdByUserId(User_id,pwd1);
                if (count>0){
                    return new ResponseEntity<>(4,HttpStatus.OK);//返回值为4密码修改成功
                }else {
                    return new ResponseEntity<>(3,HttpStatus.OK);//返回值为3时修改失败
                }
            }else {
                return new ResponseEntity<>(2,HttpStatus.OK);//返回值为2时两次新密码不一致
            }
        }else {
            return new ResponseEntity<>(1,HttpStatus.OK);//返回值为1时旧密码错误
        }
    }
    //查询当前用户的密保设置状态
    @PostMapping("selEncSta")
    public ResponseEntity<?> selEncSta(int user_id){
        List<Encrypted> list=personalCenterService.selEncAnsByUserId(user_id);
        Map<String,String> listMap=new HashMap<>();
        listMap.put("que",null);
        listMap.put("email",null);
        listMap.put("mobile",null);
        if (list.size()<3){
            listMap.put("que","qNull");
        }
        String email=personalCenterService.selUserByUserId(user_id).getUser_email();
        if (email==null || email.equals("")){
            listMap.put("email","eNull");
        }
        String moblie=personalCenterService.selUserByUserId(user_id).getUser_mobile();
        if (moblie==null || moblie.equals("")){
            listMap.put("mobile","mNull");
        }

        return new ResponseEntity<>(listMap,HttpStatus.OK);
    }

    @PostMapping("setEncrypted")
    public ResponseEntity<?> setEncrypted(String setQue1,String setAns1,String setQue2,String setAns2,String setQue3,String setAns3,int User_id){
        System.out.println("进到setEncrypted里了！");
        List<Encrypted> list=personalCenterService.selEncAnsByUserId(User_id);
        if(!(list.size()>0)){
            Encrypted encrypted = null;
            for(int i=1;i<=3;i++){
                if (i==1){
                    encrypted=new Encrypted(null,setQue1,setAns1,User_id);
                }else if (i==2){
                    encrypted=new Encrypted(null,setQue2,setAns2,User_id);
                }else if (i==3){
                    encrypted=new Encrypted(null,setQue3,setAns3,User_id);
                }
                System.out.println(encrypted.toString());
                int count=personalCenterService.insEncrypted(encrypted);
                if (count==0){
                    return new ResponseEntity<>(2,HttpStatus.OK);//保存失败
                }
            }
            return new ResponseEntity<>(3,HttpStatus.OK);//保存成功
        }
        return new ResponseEntity<>(1,HttpStatus.OK);//密保已存在，不能再新增
        }
}
