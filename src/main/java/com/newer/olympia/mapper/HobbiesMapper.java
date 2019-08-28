package com.newer.olympia.mapper;/*
 *@author  yangdu
 *@date 2019/8/28 - 14:00
 * */

import com.newer.olympia.domain.Blogs;
import com.newer.olympia.domain.Hobbies;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface HobbiesMapper {
    //查询兴趣爱好表
    public List<Hobbies> hobbiesAll(@Param("User_id")Integer User_id);
    //查询主页博客
/*
    @Select("select b.*,u.User_id,u.User_name,u.User_img,c.* from blogs b,user u,comment c where b.User_id=u.User_id and b.User_id=c.User_id and b.User_id=#{User_id}")
*/
    public List<Blogs> BlogsAll(@Param("User_id")Integer User_id);

}
