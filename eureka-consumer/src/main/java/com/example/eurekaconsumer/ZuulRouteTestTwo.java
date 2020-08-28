package com.example.eurekaconsumer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/********************************************************************************
 *
 * Title: 
 *
 * Description:
 *
 * @author chenlm
 * create date on 2020/7/2
 *
 *******************************************************************************/
@RestController
@RequestMapping("/zuul-test-two")
public class ZuulRouteTestTwo {
    @GetMapping("/show-v1")
    public  String showV1()throws Exception{
        return "我是zuul-test-two/showV1";
    }


    @GetMapping("/show-v2")
    public  String showV2()throws Exception{
        return "我是zuul-test-two/showV2";
    }
}
