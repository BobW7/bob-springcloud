package com.bob.consumer.controller;

import com.bob.consumer.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/{id}")
    public User query(@PathVariable Long id) {
        /*//通过restTemplate给提供服务的模块发送请求，并且将响应（JSON）反序列化为本模块的pojo
        String url = "http://localhost:9001/user/" + id;
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("user-service");
        ServiceInstance serviceInstance = serviceInstances.get(0);
        url = "http://"+serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/user/" + id;*/
        String url = "http://user-service/user" + id;
        return restTemplate.getForObject(url, User.class);
    }
}
