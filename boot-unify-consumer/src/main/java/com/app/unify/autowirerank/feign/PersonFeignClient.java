package com.app.unify.autowirerank.feign;

import com.app.unify.autowirerank.PersonServer;
import org.springframework.cloud.openfeign.FeignClient;

/********************************************************************************
 *
 * Title: 
 *
 * Description:
 *
 * @author chenlm
 * create date on 2021/6/5 0005
 *
 *******************************************************************************/
@FeignClient(value = "sati-app-auth",primary = true)
public interface PersonFeignClient extends PersonServer {
}
