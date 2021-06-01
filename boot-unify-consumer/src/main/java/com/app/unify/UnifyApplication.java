package com.app.unify;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/********************************************************************************
 *
 * Title: 
 *
 * Description:
 *
 * @author chenlm
 * create date on 2021/5/28 0028
 *
 *******************************************************************************/
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class UnifyApplication {
    public static void main(String[] args) {
        SpringApplication.run(UnifyApplication.class, args);
    }
}
