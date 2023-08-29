package com.dazao.service.impl;

import com.dazao.User;
import com.dazao.mapper.UserMapper;
import com.dazao.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl  implements UserService {
    @Resource
    UserMapper userMapper;
    @Override
    public User getUserById(Integer userId) {
        return userMapper.getUserById(userId);
    }
}
