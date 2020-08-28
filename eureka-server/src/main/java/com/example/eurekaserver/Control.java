package com.example.eurekaserver;

import com.example.startdemo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/********************************************************************************
 *
 * Title: 
 *
 * Description:
 *
 * @author chenlm
 * create date on 2020/5/29
 *
 *******************************************************************************/
@RestController
public class Control {
    @Autowired
    private DemoService service;

    @GetMapping("/v1/test")
    public String get(){

        return service.say();
    }

    @GetMapping(value = "/remote-test",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Map<String,String> getR(String name){
        Map<String,String> map=new HashMap<>();
        map.put(name,"很帅");
        map.put("age","20");
        return map;
    }
}
