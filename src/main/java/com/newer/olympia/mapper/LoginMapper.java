package com.newer.olympia.mapper;

import com.newer.olympia.domain.Privacy;
import com.newer.olympia.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginMapper {
    @Select("select * from user where User_mobile=#{User_mobile} and User_pwd=#{User_pwd}")
    public User loginFun(String User_mobile,String User_pwd);
    @Insert("insert into user (User_id,User_last_name,User_name,User_pwd,User_mobile,User_sex,User_img,User_title_img) value(default,#{User_last_name},#{User_name}," +
            "#{User_pwd},#{User_mobile},#{User_sex},'author-main1.jpg','top-header1.jpg')")
    public int zcFun(User user);
    @Insert("insert into privacy value(default,#{Privacy_describe},2,#{User_id})")
    public int insertPrivacy(Privacy privacy);
}
