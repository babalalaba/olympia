package com.newer.olympia.service;

import com.newer.olympia.domain.Encrypted;
import com.newer.olympia.domain.Privacy;
import com.newer.olympia.domain.User;
import com.newer.olympia.mapper.PersonalCenterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//Service作用模块：个人中心
//创建人：易霖
@Service
public class PersonalCenterService implements PersonalCenterServiceImpl  {
    @Autowired
    private PersonalCenterMapper personalCenterMapper;

    @Override
    public User selUserByUserId(int User_id) {
        return personalCenterMapper.selUserByUserId(User_id);
    }

    @Override
    public int subProByUserId(User user) {
        return personalCenterMapper.subProByUserId(user);
    }

    @Override
    public int upPwdByUserId(int User_id, String pwd) {
        return personalCenterMapper.upPwdByUserId(User_id,pwd);
    }

    @Override
    public List<Privacy> SelPri(int User_id) {
        return personalCenterMapper.SelPri(User_id);
    }

    @Override
    public int UpdPri(Privacy privacy) {
        return personalCenterMapper.UpdPri(privacy);
    }

    @Override
    //查询密保问题
    public List<Encrypted> selEncQueByUserId(int User_id) {
        return personalCenterMapper.selEncQueByUserId(User_id);
    }

    @Override
    //查询密保答案
    public List<Encrypted> selEncAnsByUserId(int User_id) {
        return personalCenterMapper.selEncAnsByUserId(User_id);
    }

    @Override
    //更新密保
    public int updEncrypted(Encrypted encrypted) {
        return personalCenterMapper.updEncrypted(encrypted);
    }

    @Override
    public int insEncrypted(Encrypted encrypted) {
        return personalCenterMapper.insEncrypted(encrypted);
    }

    @Transactional
    public boolean test(int Privacy_describe1, int Privacy_describe2, int Privacy_describe3, int Privacy_describe4, int User_id) {
        int pri[]={Privacy_describe1,Privacy_describe2,Privacy_describe3,Privacy_describe4};
        for (int i = 1; i <= 4; i++) {
            Privacy privacy = new Privacy();
            privacy.setPrivacy_describe(i);
           /* if(i==3){
                privacy.setPrivacy_describe(8);
            }*/
            privacy.setPrivacy_state(pri[i-1]);
            privacy.setUser_id(User_id);
            int count = UpdPri(privacy);
            //如果其中一条数据修改失败，则回滚保存的数据
            if (count == 0) {
                try {
                    System.out.println("问题" + i + "保存失败！抛异常，数据回滚！");
                    int a = 6 / 0;
                } catch (Exception e) {
                    System.out.println("数据保存失败啦！！！报异常了！！！");
                    throw new RuntimeException("没保存成功，抛异常了！！！");
                }
                return false;
            } else {
                System.out.println("问题" + i + "保存成功！");
            }
        }
        return true;
    }

}
