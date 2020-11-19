package com.example.eurekaserver;

import com.example.eurekaserver.event.OrderService;
import com.example.startdemo.service.DemoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EurekaServerApplicationTests {
    private DemoService demoService;

    @Autowired
    private OrderService orderService;

    @Test
    public void contextLoads() {
        System.out.println("进来了");
        demoService.say();
    }
    @Test
    public void contextLoad1s() {
        orderService.order();
    }


}
