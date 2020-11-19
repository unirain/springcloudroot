package com.example.consul;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RestController
public class FirstController {

    @RequestMapping("/hello")
    public String hello() {
        return "helle consul";
    }
}
