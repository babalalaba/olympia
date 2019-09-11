package com.newer.olympia.mapper;

import com.newer.olympia.domain.Admis;
import com.newer.olympia.domain.Blogs;
import com.newer.olympia.domain.Blogs2;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

//管理员Mapper
//维护:易霖
@Repository
public interface AdminsMapper {
    //查询管理员账号密码
    @Select("select * from admis where Admis_name=#{Admis_name}")
    public Admis selAdmis(String Admis_name);
    @Select("select * from admis where Admis_id=#{Admis_id}")
    public Admis selAdmisByUser_id(int Admis_id);
    @Update("update admis set Admis_pwd=#{Admis_pwd} where Admis_id=#{Admis_id}")
    public int updAdmPwd(Admis admis);
    //查询举报的方法
    @Select("select * from blogs where Blogs_state=2")
    public List<Blogs> selblogRep();

    @Select("select * from blogs where blogs_id=#{blogs_id}")
    public Blogs selblogByBlogsId(int blogs_id);
    //将没修改之前的帖子保存到备份表里
    @Insert("insert into Blogs2 values(#{Blogs_id},#{User_id},#{Blogs_content},#{Blogs_type},#{Blogs_img}," +
            "#{Blogs_time},#{Blogs_like},#{Blogs_state},#{Blogs_season})")
    public int BackupBlog(Blogs blogs);

    //确认违规后，更改blogs1表的动态内容
    @Update("update blogs set Blogs_content=#{Blogs_content},Blogs_img=#{Blogs_img},Blogs_state=#{Blogs_state},Blogs_season=#{Blogs_season} where Blogs_id=#{Blogs_id}")
    public int updBlogs(Blogs blogs);
    @Update("update blogs set Blogs_state=#{Blogs_state},Blogs_season=#{Blogs_season} where Blogs_id=#{Blogs_id}")
    public int wwgBlogs(Blogs blogs);

    @Update("update blogs set Blogs_content=#{Blogs_content},Blogs_img=#{Blogs_img}, Blogs_state=#{Blogs_state},Blogs_season=#{Blogs_season} where Blogs_id=#{Blogs_id}")
    public int wwgBlogs2(Blogs2 blogs2);
    @Delete("delete from blogs2 where Blogs_id=#{Blogs_id}")
    public int delBlogs2(int Blogs_id);
    //查询被驳回的帖子
    @Select("select * from blogs where Blogs_state=4")
    public List<Blogs> selblogReject();
    //根据用户驳回的blogs_id查询对应回收站的博客
    @Select("select * from blogs2 where blogs_id=#{blogs_id}")
    public Blogs2 selblog2ByBlogsId(int blogs_id);
    //根据用户id查询帖子
    @Select("select * from blogs where User_id=#{userId}")
    public List<Blogs> selBlogByUser(int userId);
    //更改用户状态
    @Update("update user set User_safety=#{User_safety} where User_id=#{User_id}")
    public int gbUserSta(int User_id,int User_safety);
    @Select("select * from blogs where Blogs_type=1")
    public List<Blogs> selBlogNum1();
    @Select("select * from blogs where Blogs_type=2")
    public List<Blogs> selBlogNum2();

}
