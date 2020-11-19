package com.example.consulconsume;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/********************************************************************************
 *
 * Title: 
 *
 * Description:
 *
 * @author chenlm
 * create date on 2020/9/10
 *
 *******************************************************************************/
@FeignClient(name = "service-producer")
public interface RemoteCall {

    @RequestMapping("/hello")
    String hello();
}
