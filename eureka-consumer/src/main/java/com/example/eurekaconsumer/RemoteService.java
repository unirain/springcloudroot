package com.example.eurekaconsumer;

/********************************************************************************
 *
 * Title: feign调用
 *
 * Description: 1.fallbackFactory--错误的时候回调工产类
 *              2.fallback-错误时回调定义类
 *              3.name、value 指注册的时候spring.application.name
 *
 *
 * @author chenlm
 * create date on 2019/11/19
 *
 *******************************************************************************/

import com.example.eurekaconsumer.feigncallback.RemoteFeignClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@FeignClient(name = "eureka-client", fallbackFactory = RemoteFeignClientFallback.class
//,fallback = RemoteCallBack
)
public interface RemoteService {

    @RequestMapping("/dc")
    String dc();

    @PostMapping(value = "/insertMap")
    String callInsertMap(@RequestBody Map<String, String> map);

}
