package com.example.rabbitmq.oldtest;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/********************************************************************************
 *
 * Title: 接收
 *
 * Description:
 *
 * @author chenlm
 * create date on 2018/7/27
 *
 *******************************************************************************/

@Component
@RabbitListener(queues = "my-second")
public class MqAceptSecond {
    //参数名称会自动解析内容
    @RabbitHandler
    public void process(String hello) {
        System.out.println("Receiver2 : " + hello);
    }

}
