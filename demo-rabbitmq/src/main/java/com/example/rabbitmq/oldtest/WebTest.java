package com.example.rabbitmq.oldtest;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/********************************************************************************
 *
 * Title: 测试
 *
 * Description:
 *
 * @author chenlm
 * create date on 2020/1/19
 *
 *******************************************************************************/
@RestController
public class WebTest {

    @Autowired
    private AmqpTemplate rabbitTemplate;


    /**
     * m
     * @return
     * @throws Exception
     */
    @GetMapping("/test0")
    public String test0()throws Exception{
        rabbitTemplate.convertAndSend("clm","测试下没有交换器");
        return "ok";
    }


    @GetMapping("/test1")
    public String test1(){
        rabbitTemplate.convertAndSend("top-exchange", "top.message", "测试下TOP转发");
        return "ok";
    }

    @GetMapping("/test2")
    public String test2(){
        rabbitTemplate.convertAndSend("direct-exchange","direct-message","测试下direct转发");
        return "ok";

    }

    /**
     * 虽然有绑定键这个参数，可任意填写，系统不会认
     * @return
     */
    @GetMapping("/test3")
    public String test3(){
        rabbitTemplate.convertAndSend("fanout-exchange","测试下fanout转发");
        return "ok";

    }

    @GetMapping("/test4")
    public String test4()throws Exception{
        Map<String, Object> map = new HashMap<>();
        map.put("One","A");
        map.put("Two","B");
        MessageProperties properties=new MessageProperties();
        properties.setDeliveryMode(MessageDeliveryMode.NON_PERSISTENT);
        properties.setContentType("UTF-8");
        properties.getHeaders().putAll(map);
        rabbitTemplate.convertAndSend("headers-exchange","",new Message("测试下headers转发".getBytes(),properties));
        return "ok";

    }
}
