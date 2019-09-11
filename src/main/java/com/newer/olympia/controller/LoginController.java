package com.newer.olympia.controller;

import com.newer.olympia.domain.User;
import com.newer.olympia.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        }catch (Exception e){
            list.add(2);
            list.add(null);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
}
