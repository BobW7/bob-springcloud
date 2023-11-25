package com.bob.consumer.client;

import com.bob.consumer.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "user-service",fallback = UserClientFallback.class)
public interface UserClient {
    @GetMapping("/user/{id}")
    public User queryById(@PathVariable Long id);
}
