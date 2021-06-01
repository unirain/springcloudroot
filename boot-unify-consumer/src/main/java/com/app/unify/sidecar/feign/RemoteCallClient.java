package com.app.unify.sidecar.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

/********************************************************************************
 *
 * Title: 
 *
 * Description:
 *
 * @author chenlm
 * create date on 2021/5/28 0028
 *
 *******************************************************************************/
//@FeignClient(name = "mop-api-server",path = "/emop")
@FeignClient(name = "mop-api-server",url = "http://mop-api-server:8000/emop")
public interface RemoteCallClient {

    @PostMapping(value = "/check",consumes = {"application/json"}, produces = {"application/json"})
    String call(Map<String,String> map);
}
