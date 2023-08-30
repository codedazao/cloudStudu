package com.dazao.controller;

import com.dazao.User;
import com.dazao.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Resource
    UserService userService;


    /**
     * 根据用户id查询用户信息
     * @param userId
     * @return
     */
    @GetMapping("/user/{userId}")
    public User getUserById(@PathVariable Integer userId){
        System.out.println("我被调用了");
       return userService.getUserById(userId);
    }
}
