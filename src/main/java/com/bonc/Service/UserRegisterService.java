package com.bonc.Service;

import com.bonc.Entity.User;
import com.bonc.Mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ZK on 2017/2/23.
 */
@Service
public class UserRegisterService {

    @Autowired
    private UserMapper userMapper;

    public void register(User user){
        userMapper.insert(user);
    }

}
