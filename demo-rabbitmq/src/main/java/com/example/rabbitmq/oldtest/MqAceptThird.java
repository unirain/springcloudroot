package com.example.rabbitmq.oldtest;


import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/********************************************************************************
 *
 * Title: 
 *
 * Description:
 *
 * @author chenlm
 * create date on 2018/7/31
 *
 *******************************************************************************/
@Component
@RabbitListener(queues = "my-third")
public class MqAceptThird {
    @RabbitHandler
    public void process(String hello) {
        System.out.println("Receiver3 : " + hello);
    }
}
