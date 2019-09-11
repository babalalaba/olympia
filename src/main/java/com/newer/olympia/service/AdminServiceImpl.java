package com.newer.olympia.service;

import com.newer.olympia.domain.Admis;
import com.newer.olympia.domain.Blogs;
import com.newer.olympia.domain.Blogs2;

import java.util.List;

public interface AdminServiceImpl {
    public Admis selAdmis(String Admis_name);
    public Admis selAdmisByUser_id(int Admis_id);
    public int updAdmPwd(Admis admis);
    public List<Blogs> selblogRep();
    public Blogs selblogByBlogsId(int blogs_id);
    public int BackupBlog(Blogs blogs);
    public int updBlogs(Blogs blogs);
    public int wwgBlogs(Blogs blogs);
    public int wwgBlogs2(Blogs2 blogs2);
    public int delBlogs2(int Blogs_id);
    public List<Blogs> selblogReject();
    public Blogs2 selblog2ByBlogsId(int blogs_id);
    public List<Blogs> selBlogByUser(int userId);
    public int gbUserSta(int User_id,int User_safety);
    public List<Blogs> selBlogNum1();
    public List<Blogs> selBlogNum2();
}
