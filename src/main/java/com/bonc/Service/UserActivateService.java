package com.bonc.Service;

import com.bonc.Entity.User;
import com.bonc.Mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ZK on 2017/2/23.
 */
@Service
public class UserActivateService {

    @Autowired
    private UserMapper userMapper;

    public void activate(Long userId){
        User user = userMapper.findByUserId(userId);
        user.setIsUsed(1);
        userMapper.update(user);
    }
}
