package com.newer.olympia.mapper;

import com.newer.olympia.domain.*;
import org.apache.ibatis.annotations.Insert;
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
    //查询当前用户信息
    @Select("select * from user where User_id=#{User_id}")
    public User selUserByUserId(int User_id);
    //存储用户基本信息
    @Update("update user set User_last_name=#{User_last_name},User_name=#{User_name},User_email=#{User_email},User_birthday=#{User_birthday}" +
            ",User_sex=#{User_sex},User_mobile=#{User_mobile},User_state=#{User_state},User_province=#{User_province},User_city=#{User_city}" +
            ",User_describe=#{User_describe},User_birthplace=#{User_birthplace},User_job=#{User_job},User_marriage=#{User_marriage}" +
            ",User_faith=#{User_faith},User_politics=#{User_politics} where User_id=#{User_id}")
    public int subProByUserId(User user);
    //更改用户密码
    @Update("update user set user_pwd=#{pwd} where user_id=#{User_id}")
    public int upPwdByUserId(int User_id,String pwd);
    //查询权限表返回List<Privacy>集合
    @Select("Select * from privacy where user_id=#{User_id}")
    public List<Privacy> SelPri(int User_id);
    //当该问题属于当前用户，且传进问题的类型与数据库对应字段一致时，改变权限状态
    @Update("update privacy set Privacy_state=#{Privacy_state} where user_id=#{User_id} and Privacy_describe=#{Privacy_describe}")
    public int UpdPri(Privacy privacy);
    //查询当前用户密保问题
    @Select("select encrypted_id,Encrypted_question from encrypted where user_id=#{user_id}")
    public List<Encrypted> selEncQueByUserId(int User_id);
    //查询当前用户密保答案
    @Select("select encrypted_id,Encrypted_answer from encrypted where user_id=#{user_id}")
    public List<Encrypted> selEncAnsByUserId(int User_id);
    //根据密保id查询密保信息
    @Select("select * from encrypted where Encrypted_id=#{Encrypted_id}")
    public Encrypted selEncQueByENCId(int Encrypted_id);
    //修改密保答案
    @Update("update encrypted set Encrypted_question=#{Encrypted_question},Encrypted_answer=#{Encrypted_answer} where user_id=#{user_id}" +
            " and Encrypted_id=#{Encrypted_id}")
    public int updEncrypted(Encrypted encrypted);
    //添加密保问题方法
    @Insert("insert into encrypted values(#{Encrypted_id},#{Encrypted_question},#{Encrypted_answer},#{User_id})")
    public int insEncrypted(Encrypted encrypted);

    //更改用户手机密保
    @Update("update user set User_mobile=#{User_mobile} where user_id=#{User_id}")
    public int upChecodeByUserId(int User_id,String User_mobile);

    //查询用户爱好
    @Select("select * from hobbies")
    public Hobbies selHobbies(int User_id);

    //保存用户爱好
    @Insert("insert into hobbies values(#{User_id},#{Hobbies_hobby},#{Hobbies_music},#{Hobbies_telecast},#{Hobbies_book}," +
            "#{Hobbies_movie},#{Hobbies_writer},#{Hobbies_game},#{Hobbies_else})")
    public int subHobbies(Hobbies hobbies);

    //更新用户爱好
    @Update("update hobbies set Hobbies_hobby=#{Hobbies_hobby},Hobbies_music=#{Hobbies_music},Hobbies_telecast=#{Hobbies_telecast}" +
            ",Hobbies_book=#{Hobbies_book},Hobbies_movie=#{Hobbies_movie},Hobbies_writer=#{Hobbies_writer},Hobbies_game=#{Hobbies_game}" +
            ",Hobbies_else=#{Hobbies_else} where User_id=#{User_id}")
    public int updHobbies(Hobbies hobbies);

    //查询用户教育经历
    @Select("select * from education where User_id=#{user_id}")
    public List<Education> selEdu(int User_id);
    //查询用户工作经历
    @Select("select * from job where User_id=#{user_id}")
    public List<Job> selEmp(int User_id);
    //保存用户的教育信息
    @Insert("insert into education values(default,#{Education_site},#{Education_time},#{Education_describe},#{User_id})")
    public int subEdu(Education education);
    //更新用户的教育信息
    @Update("update education set Education_site=#{Education_site},Education_time=#{Education_time},Education_describe=#{Education_describe}" +
            " where Education_id=#{Education_id} and User_id=#{User_id}")
    public int updEdu(Education education);
    //保存用户的工作信息
    @Insert("insert into job values(default,#{Job_site},#{Job_time},#{Job_describe},#{User_id})")
    public int subJob(Job job);
    //更新用户的工作信息
    @Update("update job set Job_site=#{Job_site},Job_time=#{Job_time},Job_describe=#{Job_describe} where Job_id=#{Job_id} and User_id=#{User_id}")
    public int updJob(Job job);
}
