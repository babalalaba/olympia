package com.newer.olympia.service;
//管理员service
//维护人员易霖

import com.newer.olympia.domain.Admis;
import com.newer.olympia.domain.Blogs;
import com.newer.olympia.domain.Blogs2;
import com.newer.olympia.mapper.AdminsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService implements AdminServiceImpl {
    @Autowired
    private AdminsMapper adminsMapper;
    @Override
    public Admis selAdmis(String Admis_name) {
        return adminsMapper.selAdmis(Admis_name);
    }

    @Override
    public Admis selAdmisByUser_id(int Admis_id) {
        return adminsMapper.selAdmisByUser_id(Admis_id);
    }

    @Override
    public int updAdmPwd(Admis admis) {
        return adminsMapper.updAdmPwd(admis);
    }

    @Override
    public List<Blogs> selblogRep() {
        return adminsMapper.selblogRep();
    }

    @Override
    public Blogs selblogByBlogsId(int blogs_id) {
        return adminsMapper.selblogByBlogsId(blogs_id);
    }

    @Override
    public int BackupBlog(Blogs blogs) {
        return adminsMapper.BackupBlog(blogs);
    }

    @Override
    public int updBlogs(Blogs blogs) {
        return adminsMapper.updBlogs(blogs);
    }

    @Override
    public int wwgBlogs(Blogs blogs) {
        return adminsMapper.wwgBlogs(blogs);
    }

    @Override
    public int wwgBlogs2(Blogs2 blogs2) {
        return adminsMapper.wwgBlogs2(blogs2);
    }


    @Override
    public int delBlogs2(int Blogs_id) {
        return adminsMapper.delBlogs2(Blogs_id);
    }

    @Override
    public List<Blogs> selblogReject() {
        return adminsMapper.selblogReject();
    }

    @Override
    public Blogs2 selblog2ByBlogsId(int blogs_id) {
        return adminsMapper.selblog2ByBlogsId(blogs_id);
    }

    @Override
    public List<Blogs> selBlogByUser(int userId) {
        return adminsMapper.selBlogByUser(userId);
    }

    @Override
    public int gbUserSta(int User_id, int User_safety) {
        return adminsMapper.gbUserSta(User_id,User_safety);
    }

    @Override
    public List<Blogs> selBlogNum1() {
        return adminsMapper.selBlogNum1();
    }

    @Override
    public List<Blogs> selBlogNum2() {
        return adminsMapper.selBlogNum2();
    }
}
