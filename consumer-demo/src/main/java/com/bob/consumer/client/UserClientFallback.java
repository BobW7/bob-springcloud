package com.bob.consumer.client;

import com.bob.consumer.pojo.User;
import org.springframework.stereotype.Component;

@Component
public class UserClientFallback implements UserClient {
    @Override
    public User queryById(Long id) {
        User user = new User();
        user.setName("用户异常");
        return user;
    }
}
