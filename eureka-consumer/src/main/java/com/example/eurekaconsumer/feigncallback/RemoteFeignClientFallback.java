package com.example.eurekaconsumer.feigncallback;

import com.example.eurekaconsumer.RemoteService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

/********************************************************************************
 *
 * Title: feign失败回调
 *
 * Description: 用于feign里面的FallbackFactory，调用失败回调这个
 *
 * @author chenlm
 * create date on 2020/7/17
 *
 *******************************************************************************/
@Component
public class RemoteFeignClientFallback implements FallbackFactory<RemoteService> {


    @Override
    public RemoteService create(Throwable throwable) {
        return new RemoteService() {
            @Override
            public String dc() {
                return "error";
            }

            @Override
            public String callInsertMap(Map<String, String> map) {
                map.forEach((k,v)->System.out.println("错误回调"+k+"is "+v));
                return "null";
            }
        };
    }
}
