package com.bob.consumer.controller;

import com.bob.consumer.client.UserClient;
import com.bob.consumer.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumerFeign")
@Slf4j
@DefaultProperties(defaultFallback = "defaultFallback")
public class ConsumerFeignController {

    @Autowired
    private UserClient userClient;
    @RequestMapping("/{id}")
    public User queryById(@PathVariable Long id){
        return userClient.queryById(id);
    }

    public String defaultFallback(){
        return "默认提示：网络太过拥挤！";
    }
}
