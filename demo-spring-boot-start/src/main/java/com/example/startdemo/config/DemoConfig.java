package com.example.startdemo.config;

import com.example.startdemo.properties.DemoProperties;
import com.example.startdemo.service.DemoService;
import com.example.startdemo.service.Ds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/********************************************************************************
 *
 * Title: 配置类
 *
 * Description:
 *
 * @author chenlm
 * create date on 2020/5/28
 *
 *******************************************************************************/
@Configuration
//必须指定class，否则无法注册
@EnableConfigurationProperties(DemoProperties.class)
//prefix:property名称的前缀，可有可无
//name ：数组，property完整名称或部分名称（可与prefix组合使用，组成完整的property名称），与value不可同时使用
//havingValue:可与name组合使用，比较获取到的属性值与havingValue给定的值是否相同，相同才加载配置
@ConditionalOnProperty(prefix = "demo",name = "isopen" ,matchIfMissing = true)
public class DemoConfig {
//    @Autowired
//    private DemoProperties demoProperties;
//
//    @Bean(name = "demo")
//    public DemoService demoService(){
//        return new DemoService(demoProperties.getSayWhat(), demoProperties.getToWho());
//    }
    @Bean
    public Ds ds(){
        return new Ds();
    }

}
