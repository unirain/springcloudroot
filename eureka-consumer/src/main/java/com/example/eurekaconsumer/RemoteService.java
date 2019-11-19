package com.example.eurekaconsumer;

/********************************************************************************
 *
 * Title: feign调用
 *
 * Description:
 *
 * @author chenlm
 * create date on 2019/11/19
 *
 *******************************************************************************/

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "eureka-client")
public interface RemoteService {

    @RequestMapping("/dc")
    String dc();

}
