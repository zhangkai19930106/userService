package com.bonc.Service;

import com.bonc.Entity.User;
import com.bonc.Mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Created by ZK on 2017/2/23.
 */
@Service
public class UserValidateService {

    @Autowired
    private UserMapper userMapper;

    //验证登录密码是否正确
    public User validatePassword(String userName,String inputPassword){
        User user = userMapper.findByName(userName);
        String password = user.getPassWord();
        if (password.equals(inputPassword)){
            return user;
        }else {
            return null;
        }
    }

    //验证用户名是否已存在
    public boolean validateUserName(String userName){
        User user = userMapper.findByName(userName);
        if (null == user){
            return true;
        }else {
            return false;
        }
    }

    //验证身份证号码是否已存在
    public boolean validateRealId(String realId){
        User user = userMapper.findByRealId(realId);
        if (null == user){
            return true;
        }else {
            return false;
        }
    }

    //验证手机号码是否已存在
    public boolean validatePhoneNum(String phoneNum){
        User user = userMapper.findByPhoneNum(phoneNum);
        if (null == user){
            return true;
        }else {
            return false;
        }
    }

    //验证邮箱地址是否已存在
    public boolean validateMail(String mailAddr){
        User user = userMapper.findByMail(mailAddr);
        if (null == user){
            return true;
        }else {
            return false;
        }
    }
}
