package com.app.normolboot.configurationproxy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/********************************************************************************
 *
 * Title:  proxyBeanMethods 验证
 *
 * Description:
 *
 * @author chenlm
 * create date on 2021/6/1 0001
 *
 *******************************************************************************/
@Configuration(proxyBeanMethods = false)
public class Config {

    @Value("${my.name}")
    private String name;

    @Value("${my.age}")
    private String age;


    public FlyCar flyCar(Car car){
        System.out.println("flycar  1");
        FlyCar flyCar=new FlyCar();
        flyCar.setCar(car);
        return flyCar;
    }


    @Bean
    public Car car(){
        return new Car();
    }
}
