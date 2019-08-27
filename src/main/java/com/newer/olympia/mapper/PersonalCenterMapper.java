package com.newer.olympia.mapper;

import com.newer.olympia.domain.Privacy;
import com.newer.olympia.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

//Mapper作用模块：个人中心
//创建人：易霖
//本Mapper作用目前是对user表进行增删改查
//对权限表进行查询、更改
@Repository
public interface PersonalCenterMapper {
    @Select("select * from user where User_id=#{User_id}")
    public User selUserByUserId(int User_id);
    @Update("update user set User_last_name=#{User_last_name},User_name=#{User_name},User_email=#{User_email},User_birthday=#{User_birthday}" +
            ",User_sex=#{User_sex},User_mobile=#{User_mobile},User_state=#{User_state},User_province=#{User_province},User_city=#{User_city}" +
            ",User_describe=#{User_describe},User_birthplace=#{User_birthplace},User_job=#{User_job},User_marriage=#{User_marriage}" +
            ",User_faith=#{User_faith},User_politics=#{User_politics} where User_id=#{User_id}")
    public int subProByUserId(User user);
    @Select("Select * from privacy where user_id=#{User_id}")
    public List<Privacy> SelPri(int User_id);
    //当该问题属于当前用户，且传进问题的类型与数据库对应字段一致时，改变权限状态
    @Update("updata privacy set Privacy_state=#{Privacy_state} where user_id=#{User_id} and Privacy_describe=#{Privacy_describe}")
    public int UpdPri(Privacy privacy);
}
