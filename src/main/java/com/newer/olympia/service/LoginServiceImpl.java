package com.newer.olympia.service;

import com.newer.olympia.domain.User;

public interface LoginServiceImpl {
    public User loginFun(String User_mobile, String User_pwd);
    public int zcFun(User user);
}
