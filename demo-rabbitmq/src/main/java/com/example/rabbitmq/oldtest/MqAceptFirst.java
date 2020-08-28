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
@RabbitListener(queues = "my-first")
public class MqAceptFirst {
    @RabbitHandler
    public void process(String hello) {
        System.out.println("Receiver1 : " + hello);
    }

    /**
     * byte类型入口
     * @param hello
     */
    @RabbitHandler
    public void process2(byte[] hello) {
        System.out.println("Receiver1--第二个");

        System.out.println("Receiver1 : " + new String(hello));
    }
}
