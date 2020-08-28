package com.example.eurekaconsumer.feigncallback;

import com.example.eurekaconsumer.RemoteService;
import org.springframework.stereotype.Component;

import java.util.Map;

/********************************************************************************
 *
 * Title: 
 *
 * Description: 可以用于feign里面的fallback
 *
 * @author chenlm
 * create date on 2020/7/17
 *
 *******************************************************************************/
//@Component
public class RemoteCallBack implements RemoteService {
    @Override
    public String dc() {
        return "error";
    }

    @Override
    public String callInsertMap(Map<String, String> map) {
        return "error";
    }
}
