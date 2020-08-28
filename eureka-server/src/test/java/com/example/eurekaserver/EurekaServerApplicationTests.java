package com.example.eurekaserver;

import com.example.startdemo.service.DemoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EurekaServerApplicationTests {
    private DemoService demoService;

    @Test
    public void contextLoads() {
        System.out.println("进来了");
        demoService.say();
    }

}
