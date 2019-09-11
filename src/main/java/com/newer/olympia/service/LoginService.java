package com.newer.olympia.service;

import com.newer.olympia.domain.User;
import com.newer.olympia.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements LoginServiceImpl {
    @Autowired
    private LoginMapper loginMapper;

    @Override
    public User loginFun(String User_mobile, String User_pwd) {
        return loginMapper.loginFun(User_mobile,User_pwd);
    }

    @Override
    public int zcFun(User user) {
        return loginMapper.zcFun(user);
    }
}
