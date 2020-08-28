package com.example.eurekaconsumer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/********************************************************************************
 *
 * Title: zuul路由测试
 *
 * Description:
 *
 * @author chenlm
 * create date on 2020/5/20
 *
 *******************************************************************************/
@RestController
@RequestMapping("/zuul-test-one")
public class ZuulRouteTestOne {
    @GetMapping("/show-v1")
    public  String showV1()throws Exception{
        return "我是zuul-test-one/showV1";
    }


    @GetMapping("/show-v2")
    public  String showV2()throws Exception{
        return "我是zuul-test-one/showV2";
    }
}
