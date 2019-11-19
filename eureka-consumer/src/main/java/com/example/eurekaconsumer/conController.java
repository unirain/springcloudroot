package com.example.eurekaconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/********************************************************************************
 *
 * Title: 
 *
 * Description:
 *
 * @author chenlm
 * create date on 2018/6/6
 *
 *******************************************************************************/
@RestController
public class conController {
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RemoteService remoteService;

    /**
     * loadBalancerClient 调用
     * 编码太过麻烦
     * @return
     */
    @GetMapping("/loadBalancerClient-consumer")
    public String lc(){
        //获取客户端服务
        ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-client");
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/dc";
        System.out.println(url);
        //发送请求
        return restTemplate.getForObject(url, String.class);
    }


    /**
     * ribbon调用
     * 使用应用的名称，此时restTemplate必须有配置负载均衡 @LoadBalanced
     * @return
     */
    @GetMapping("/ribbon-consumer")
    public String rc(){
        return restTemplate.getForObject("http://eureka-client/dc", String.class);
    }

    /**
     * feign 调用
     * 方便快速，推荐 只要定义接口就行，就像本地调用
     * @return
     */
    @GetMapping("/feign-consumer")
    public String fc(){
        System.out.println("feign方式正在进行");
        return remoteService.dc();
    }
}
