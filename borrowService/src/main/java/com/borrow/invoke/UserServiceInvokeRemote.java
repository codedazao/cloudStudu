package com.borrow.invoke;

import com.dazao.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "userService")
public interface UserServiceInvokeRemote {
    @GetMapping("/user/{userId}")
    User getUserById(@PathVariable Integer userId);
}
