package com.example.product;

import com.alibaba.nacos.spring.context.annotation.discovery.EnableNacosDiscovery;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/********************************************************************************
 *
 * Title: 
 *
 * Description:
 *
 * @author chenlm
 * create date on 2020/12/7
 *
 *******************************************************************************/
@SpringBootApplication
public class NacosProductApplication {
    public static void main(String[] args) {
        SpringApplication.run(NacosProductApplication.class,args);
    }
}
