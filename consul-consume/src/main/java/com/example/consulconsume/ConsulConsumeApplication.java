package com.example.consulconsume;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ConsulConsumeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsulConsumeApplication.class, args);
    }

}
