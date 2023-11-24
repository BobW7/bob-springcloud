package com.bob.consumer;

import com.netflix.discovery.converters.Auto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RibbonTest {
    @Autowired
    private RibbonLoadBalancerClient client;

    @Test
    public void ribbonTest() {
        for (int i = 0; i < 100; i++) {
            ServiceInstance content = this.client.choose("user-service");
            System.out.println(content.getHost() + ":" + content.getPort());
        }
    }
}
