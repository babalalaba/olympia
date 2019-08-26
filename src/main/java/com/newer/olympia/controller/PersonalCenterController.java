package com.newer.olympia.controller;

import com.newer.olympia.domain.User;
import com.newer.olympia.service.PersonalCenterService;
import com.newer.olympia.util.HttpUtils;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
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
}
