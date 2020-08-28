package com.example.rabbitmq.oldtest;


import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/********************************************************************************
 *
 * Title: 配置
 *
 * Description:
 * 生产者 去对交换机， 在由交换机去匹配队列
 * 一个队列允许有多个监听器，多个监听器会轮询工作
 * t
 *
 * @author chenlm
 * create date on 2018/7/27
 *
 *******************************************************************************/
@Configuration
public class MqConfig {
    /**
     * 一个默认的队列 -clm
     * 他其实会使用默认 DirectExchange交换机，key就是队列的名字
     *
     *
     * @return
     */
    @Bean
    public Queue helloQueue() {
        return new Queue("clm");
    }


    @Bean
    public Queue myFirstMq() {
        return new Queue("my-first");
    }

    @Bean
    public Queue mySecondMq() {
        return new Queue("my-second");
    }

    @Bean
    public Queue myThirdMq() {
        return new Queue("my-third");
    }

    /**
     * 允许使用通配符的交换机 通配符可以是任何符号
     *
     * @return
     */
    @Bean
    TopicExchange topExchange() {
        return new TopicExchange("top-exchange");
    }

    /**
     * 完全匹配
     *
     * @return
     */
    @Bean
    DirectExchange directExchange() {
        return new DirectExchange("direct-exchange");
    }

    /**
     * 广播式，只关心和它绑定的队列，不去关心
     *
     * @return
     */
    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanout-exchange");
    }

    /**
     * /**
     *      * 指定消息头的匹配
     *      *
     *      * 发送到这个交换区的数据 必须带有头信息
     * @return
     */
    @Bean
    HeadersExchange headersExchange() {
        return new HeadersExchange("headers-exchange");
    }


    /************************绑定队列********************/

    @Bean
    Binding bindingTopExchange(Queue myFirstMq, TopicExchange exchange) {
        return BindingBuilder.bind(myFirstMq).to(exchange).with("top.message");
    }

    @Bean
    Binding bindingTopExchange2(Queue mySecondMq, TopicExchange exchange) {
        return BindingBuilder.bind(mySecondMq).to(exchange).with("top.#");
    }

    @Bean
    Binding bindingExchangeMessages(Queue myThirdMq, DirectExchange exchange) {
        return BindingBuilder.bind(myThirdMq).to(exchange).with("direct-message");
    }


    /**
     * 此时绑定的时候无法选择绑定键
     *
     * @param mySecondMq
     * @param exchange
     * @return
     */
    @Bean
    Binding bindingExchangeMessages3(Queue mySecondMq, FanoutExchange exchange) {
        return BindingBuilder.bind(mySecondMq).to(exchange);
    }


    /**
     * 指定消息头的匹配
     *
     * 发送到这个交换区的数据 必须带有头信息
     * @param myFirstMq
     * @param exchange
     * @return
     */
    @Bean
    Binding bindingExchangeMessages13(Queue myFirstMq, HeadersExchange exchange) {
        Map<String, Object> map = new HashMap<>();
        map.put("One","A");
        map.put("Two","B");
        //whereAll表示全部匹配
        //return BindingBuilder.bind(queue).to(headersExchange).whereAll(map).match();
        //whereAny表示部分匹配
        return BindingBuilder.bind(myFirstMq).to(exchange).whereAny(map).match();
    }


}
