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
public class Show {

    @GetMapping("/show-v1")
    public  String showV1()throws Exception{
        return "我是没有前缀的showV1";
    }

}
