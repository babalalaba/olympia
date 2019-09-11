package com.newer.olympia.controller;

import com.newer.olympia.domain.Privacy;
import com.newer.olympia.domain.User;
import com.newer.olympia.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;
    @PostMapping("loginFun")
    public ResponseEntity<?> loginFun(String User_mobile,String User_pwd){
        List list=new ArrayList();
        User user=loginService.loginFun(User_mobile,User_pwd);
        if (user!=null){
            list.add(1);
            list.add(user);
        }else {
            list.add(2);
            list.add(null);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @PostMapping("zcFun")
    public  ResponseEntity<?> zcFun(User user){
        List list=new ArrayList();
        try {
            loginService.zcFun(user);
            list.add(1);
            User user1=loginService.loginFun(user.getUser_mobile(),user.getUser_pwd());
            list.add(user1);
            for (int i=1;i<5;i++){
                Privacy privacy = new Privacy();
                privacy.setPrivacy_describe(i);
                privacy.setUser_id(user1.getUser_id());
                loginService.insertPrivacy(privacy);
            }
        }catch (Exception e){
            list.add(2);
            list.add(null);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
}
