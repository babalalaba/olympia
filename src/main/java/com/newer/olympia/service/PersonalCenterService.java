package com.newer.olympia.service;

import com.alibaba.fastjson.JSONObject;
import com.newer.olympia.domain.*;
import com.newer.olympia.mapper.PersonalCenterMapper;
import com.newer.olympia.util.HttpUtils;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

//Service作用模块：个人中心
//创建人：易霖
@Service
public class PersonalCenterService implements PersonalCenterServiceImpl  {
    @Autowired
    private PersonalCenterMapper personalCenterMapper;

    @Override
    public User selUserByUserId(int User_id) {
        return personalCenterMapper.selUserByUserId(User_id);
    }

    @Override
    public int subProByUserId(User user) {
        return personalCenterMapper.subProByUserId(user);
    }

    @Override
    public int upPwdByUserId(int User_id, String pwd) {
        return personalCenterMapper.upPwdByUserId(User_id,pwd);
    }

    @Override
    public List<Privacy> SelPri(int User_id) {
        return personalCenterMapper.SelPri(User_id);
    }

    @Override
    public int UpdPri(Privacy privacy) {
        return personalCenterMapper.UpdPri(privacy);
    }

    @Override
    //查询密保问题
    public List<Encrypted> selEncQueByUserId(int User_id) {
        return personalCenterMapper.selEncQueByUserId(User_id);
    }

    @Override
    //查询密保答案
    public List<Encrypted> selEncAnsByUserId(int User_id) {
        return personalCenterMapper.selEncAnsByUserId(User_id);
    }

    @Override
    public Encrypted selEncQueByENCId(int Encrypted_id) {
        return personalCenterMapper.selEncQueByENCId(Encrypted_id);
    }

    @Override
    //更新密保
    public int updEncrypted(Encrypted encrypted) {
        return personalCenterMapper.updEncrypted(encrypted);
    }

    @Override
    public int insEncrypted(Encrypted encrypted) {
        return personalCenterMapper.insEncrypted(encrypted);
    }

    @Override
    public int upChecodeByUserId(int User_id, String User_mobile) {
        return personalCenterMapper.upChecodeByUserId(User_id,User_mobile);
    }

    @Override
    public Hobbies selHobbies(int User_id) {
        return personalCenterMapper.selHobbies(User_id);
    }

    @Override
    public int subHobbies(Hobbies hobbies) {
        return personalCenterMapper.subHobbies(hobbies);
    }

    @Override
    public int updHobbies(Hobbies hobbies) {
        return personalCenterMapper.updHobbies(hobbies);
    }

    @Override
    public List<Education> selEdu(int User_id) {
        return personalCenterMapper.selEdu(User_id);
    }

    @Override
    public List<Job> selEmp(int User_id) {
        return personalCenterMapper.selEmp(User_id);
    }

    @Override
    public int subEdu(Education education) {
        return personalCenterMapper.subEdu(education);
    }

    @Override
    public int updEdu(Education education) {
        return personalCenterMapper.updEdu(education);
    }

    @Override
    public int subJob(Job job) {
        return personalCenterMapper.subJob(job);
    }

    @Override
    public int updJob(Job job) {
        return personalCenterMapper.updJob(job);
    }

    @Transactional
    public boolean test(int Privacy_describe1, int Privacy_describe2, int Privacy_describe3, int Privacy_describe4, int User_id) {
        int pri[]={Privacy_describe1,Privacy_describe2,Privacy_describe3,Privacy_describe4};
        for (int i = 1; i <= 4; i++) {
            Privacy privacy = new Privacy();
            privacy.setPrivacy_describe(i);
           /* if(i==3){
                privacy.setPrivacy_describe(8);
            }*/
            privacy.setPrivacy_state(pri[i-1]);
            privacy.setUser_id(User_id);
            int count = UpdPri(privacy);
            //如果其中一条数据修改失败，则回滚保存的数据
            if (count == 0) {
                try {
                    System.out.println("问题" + i + "保存失败！抛异常，数据回滚！");
                    int a = 6 / 0;
                } catch (Exception e) {
                    System.out.println("数据保存失败啦！！！报异常了！！！");
                    throw new RuntimeException("没保存成功，抛异常了！！！");
                }
                return false;
            } else {
                System.out.println("问题" + i + "保存成功！");
            }
        }
        return true;
    }
//获取短信验证码
    public Map<String,String> getMoblieNo(String User_mobile){
        String host = "https://chanyoo.market.alicloudapi.com";
        String path = "/sendsms";
        String method = "GET";
        String appcode = "2ccf2dad6532416e83135df2be9fabc4";
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Authorization", "APPCODE " + appcode);
        Map<String, String> querys = new HashMap<String, String>();
        //随机码
        String rand="";
        Random random=new Random();
        for (int i=0;i<6;i++){
            int count=random.nextInt(10);
            rand=rand+count;
        }
        querys.put("mobile", User_mobile);
        querys.put("content", "您的手机号："+User_mobile+"，验证码："+rand+"，请及时完成验证，如不是本人操作请忽略。【阿里云市场】");
        Map<String,String> map=new HashMap();
        try {
            HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
            System.out.println(response.toString());
            //获取response的body
            //访问结果
            String jg=EntityUtils.toString(response.getEntity());
            //将结果转为json
            System.out.println("具体内容为："+jg);
            JSONObject jo=JSONObject.parseObject(jg);
            //取到具体返回值
            String Result=jo.getString("errmsg");
            //如果返回值为ok则返回正确的随机验证码
            if (Result.equals("OK")){
                map.put("Result",Result);
                map.put("rand",rand.toString());
                return map;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }
}
