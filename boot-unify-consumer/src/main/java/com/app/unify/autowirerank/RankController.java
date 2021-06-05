package com.app.unify.autowirerank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/********************************************************************************
 *
 * Title: 
 *
 * Description:FeignClient 默认primary=true,所以会优先注入
 *
 * 这边联想到 feign 中得feignclient容器，这个容器是SpringClientFactory，我本以为这个feignclient 得bean也是从这个容器获取得，
 * 但是看了代码发现并不是这样，可以看下FeignClientsRegistrar 他只是把一些bean注入到ioc容器内，但是SpringClientFactory并没有在那个时候用到，SpringClientFactory
 * 是真正调用得时候ribbon那时候会有用
 *
 * @author chenlm
 * create date on 2021/6/5 0005
 *
 *******************************************************************************/
@RestController
@RequestMapping("/rank")
public class RankController {
    @Autowired
    private PersonServer personServer;


    @GetMapping("/test1")
    public String test1() {
        return personServer.ObtainPersonName("90");
    }
}
