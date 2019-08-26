package com.newer.olympia.mapper;

import com.newer.olympia.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

//Mapper作用模块：个人中心
//创建人：易霖
//本Mapper作用目前是对user表进行增删改查
@Repository
public interface PersonalCenterMapper {
    @Select("select * from user where User_id=#{User_id}")
    public User selUserByUserId(int User_id);
}
