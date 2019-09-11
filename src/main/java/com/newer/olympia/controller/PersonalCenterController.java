package com.newer.olympia.controller;

import com.alibaba.fastjson.JSONObject;
import com.newer.olympia.domain.*;
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
    //验证码
    private String randNom;
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
        }else {
            listMap.put("email",email);
        }
        String moblie=personalCenterService.selUserByUserId(user_id).getUser_mobile();
        if (moblie==null || moblie.equals("")){
            listMap.put("mobile","mNull");
        }else {
            listMap.put("mobile",moblie);
        }

        return new ResponseEntity<>(listMap,HttpStatus.OK);
    }
//更新密保问题
    @PostMapping("setEncrypted")
    public ResponseEntity<?> setEncrypted(String setQue1,String setAns1,String setQue2,String setAns2,String setQue3,String setAns3,int User_id){
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

        //获取手机验证码
    @PostMapping("getRandomCode")
    public ResponseEntity<?> getRandomCode(String User_mobile,int User_id){
        User user=personalCenterService.selUserByUserId(User_id);
        if (user.getUser_mobile().equals(User_mobile)){
            Map<String,String> map=personalCenterService.getMoblieNo(User_mobile);
            if (map.size()>0){
                randNom=(String)map.get("rand");
                //获取验证码成功
                return new ResponseEntity<>(3,HttpStatus.OK);
            }else {
                //获取验证码失败
                return new ResponseEntity<>(2,HttpStatus.OK);
            }
        }else {
            //输入的手机号码并非该用户手机号码，返回1代表该错误
            return new ResponseEntity<>(1,HttpStatus.OK);
        }
    }
    //验证旧手机验证码
    @PostMapping("checkVerCode")
    public ResponseEntity<?> checkVerCode(String checkCode,int User_id){
        if(checkCode.equals(randNom)){
            return new ResponseEntity<>(1,HttpStatus.OK);//验证成功
        }
        return new ResponseEntity<>(2,HttpStatus.OK);//验证码错误
    }

//新手机号码随机验证码
    @PostMapping("getNewRandomCode")
    public ResponseEntity<?> getNewRandomCode(String User_mobile,int User_id){
        System.out.println("新手机号："+User_mobile);
            User user=personalCenterService.selUserByUserId(User_id);
            Map<String,String> map=personalCenterService.getMoblieNo(User_mobile);
            if (map.size()>0){
                randNom=(String)map.get("rand");
                //获取验证码成功
                return new ResponseEntity<>(3,HttpStatus.OK);
            }else {
                //获取验证码失败
                return new ResponseEntity<>(2,HttpStatus.OK);
            }

        }


    //验证新的手机，以及保存新的手机号码
    @PostMapping("updMobile")
    public ResponseEntity<?> updMobile(String User_mobile,String checkCode,int User_id){
        if(checkCode.equals(randNom)){
            //保存新的手机号码
            int count=personalCenterService.upChecodeByUserId(User_id,User_mobile);
            if (count>0){
                return new ResponseEntity<>(1,HttpStatus.OK);//保存成功
            }
            return new ResponseEntity<>(2,HttpStatus.OK);//保存失败
        }
        return new ResponseEntity<>(3,HttpStatus.OK);
    }

    /**********************************************兴趣和爱好controller*******************************************************/
    @PostMapping("selHobbies")
    //查询用户爱好
    public ResponseEntity<?> selHobbies(int User_id){
        System.out.println("进入selHobbies");
        Hobbies hobbies=personalCenterService.selHobbies(User_id);
        if (hobbies!=null){
            return new ResponseEntity<>(hobbies,HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.OK);
    }

    //保存用户爱好
    @PostMapping("subHobbies")
    public ResponseEntity<?> subHobbies(Hobbies hobbies){
        Hobbies hobbie=personalCenterService.selHobbies(hobbies.getUser_id());
        int count;
        if (hobbie==null){
            count=personalCenterService.subHobbies(hobbies);
        }else {
            count=personalCenterService.updHobbies(hobbies);

        }
        if (count>0){
            return new ResponseEntity<>(1,HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.OK);
    }
    //查询用户教育经历
    @PostMapping("selEdu")
    public ResponseEntity<?> selEdu(int User_id){
        List<Education> list=personalCenterService.selEdu(User_id);
        if (list.size()>0){
            return new ResponseEntity<>(list,HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.OK);
    }
    //查询用户工作经历
    @PostMapping("selEmp")
    public ResponseEntity<?> selEmp(int User_id){
        List<Job> list=personalCenterService.selEmp(User_id);
        if (list.size()>0){
            return new ResponseEntity<>(list,HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.OK);
    }

    //保存用户的教育信息
    @PostMapping("subEdu")
    public ResponseEntity<?> subEdu(int User_id,String sch1Name,String sch1Time,String sch1Dec,String sch2Name,String sch2Time,String sch2Dec,String sch3Name,String sch3Time,String sch3Dec){
        Education education=new Education();
        List<Education> list=personalCenterService.selEdu(User_id);
        for (int i=0;i<3;i++){
            if (i==0){
                education.setUser_id(User_id);
                education.setEducation_site(sch1Name);
                education.setEducation__time(sch1Time);
                education.setEducation_describe(sch1Dec);
            }else if (i==1){
                education.setUser_id(User_id);
                education.setEducation_site(sch2Name);
                education.setEducation__time(sch2Time);
                education.setEducation_describe(sch2Dec);
            }else if (i==2){
                education.setUser_id(User_id);
                education.setEducation_site(sch3Name);
                education.setEducation__time(sch3Time);
                education.setEducation_describe(sch3Dec);
            }
            int count;
            if (list.size()>i){
                    education.setEducation_id(list.get(i).getEducation_id());
                    count = personalCenterService.updEdu(education);
            }else {
                count=personalCenterService.subEdu(education);
            }
            if (count<=0){
                return new ResponseEntity<>(2,HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(1,HttpStatus.OK);
    }
    @PostMapping("subJob")
    public ResponseEntity<?> subJob(int User_id,String job1Name,String job1Time,String job1Dec,String job2Name,String job2Time,String job2Dec,String job3Name,String job3Time,String job3Dec){
        Job job=new Job();
        List<Job> list=personalCenterService.selEmp(User_id);
        for (int i=0;i<3;i++){
            if (i==0){
                job.setUser_id(User_id);
                job.setJob_site(job1Name);
                job.setJob_time(job1Time);
                job.setJob_describe(job1Dec);
            }else if (i==1){
                job.setUser_id(User_id);
                job.setJob_site(job2Name);
                job.setJob_time(job2Time);
                job.setJob_describe(job2Dec);
            }else if (i==2){
                job.setUser_id(User_id);
                job.setJob_site(job3Name);
                job.setJob_time(job3Time);
                job.setJob_describe(job3Dec);
            }
            int count;
            if (list.size()>i){
               job.setJob_id(list.get(i).getJob_id());
                count = personalCenterService.updJob(job);
            }else {
                count=personalCenterService.subJob(job);
            }
            if (count<=0){
                return new ResponseEntity<>(2,HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(1,HttpStatus.OK);

    }
    @PostMapping("verConOne")
    public ResponseEntity<?> verConOne(int Encrypted_id,String Encrypted_answer){
        Encrypted encrypted=personalCenterService.selEncQueByENCId(Encrypted_id);
        if (encrypted.getEncrypted_answer().equals(Encrypted_answer)){
            return new ResponseEntity<>(1,HttpStatus.OK);
        }else {
            return new ResponseEntity<>(2,HttpStatus.OK);
        }
    }
}
