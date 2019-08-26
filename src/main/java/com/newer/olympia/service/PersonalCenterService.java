package com.newer.olympia.service;

import com.newer.olympia.domain.User;
import com.newer.olympia.mapper.PersonalCenterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//Service作用模块：个人中心
//创建人：易霖
@Service
public class PersonalCenterService implements PersonalCenterServiceImpl {
    @Autowired
    private PersonalCenterMapper personalCenterMapper;
    @Override
    public User selUserByUserId(int User_id) {
        return personalCenterMapper.selUserByUserId(User_id);
    }
}
