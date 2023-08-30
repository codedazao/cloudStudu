package client.invoke;

import com.dazao.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "userService")
public interface UserServiceInvokeRemote {
    @GetMapping("/user/{userId}")
    User getUserById(@PathVariable Integer userId);
}
