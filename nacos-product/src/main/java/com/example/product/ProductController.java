package com.example.product;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/********************************************************************************
 *
 * Title: 生产者
 *
 * Description:
 *
 * @author chenlm
 * create date on 2020/12/7
 *
 *******************************************************************************/
@RestController
public class ProductController {
    @NacosInjected
    private NamingService namingService;
    @Value("${spring.application.name}")
    private String appName;

    @GetMapping("/getProductName")
    public String getName() {
        System.out.println("我被调用了");

        return "chenlm";
    }

    @Autowired
    private RestTemplate restTemplate;


    @RequestMapping(value = "/get", method = GET)
    @ResponseBody
    public List<Instance> get(@RequestParam String serviceName) throws NacosException {
        return namingService.getAllInstances(serviceName);
    }

    /**
     * spring boot 要自己注册上去给nacos
     * @throws NacosException
     */
    @PostConstruct
    public void register() throws NacosException {
        namingService.registerInstance(appName, "127.0.0.1", 8998);
    }

    /**
     * 自己去选择服务
     * @return
     * @throws Exception
     */
    @GetMapping("/call-self")
    public String callSelf() throws Exception {
        //尝试自己调用自己
        Instance instance = namingService.selectOneHealthyInstance(appName);
        String post_url = String.format("http://%s:%d/getProductName", instance.getIp(), instance.getPort());
        String result = restTemplate.getForObject(post_url, String.class, "");
        return result;
    }


    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }


}
