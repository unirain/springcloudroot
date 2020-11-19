package com.example.eurekaserver.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/********************************************************************************
 *
 * Title: 
 *
 * Description: 直接使用 @EventListener 监听 无需集成实现ApplicationListener
 *
 * @author chenlm
 * create date on 2020/9/21
 *
 *******************************************************************************/
@Component
public class SmsServiceListenV2 {

    @EventListener(OrderSuccessEvent.class)
    public void handlelisten(){
        System.out.println("xxxxx");
    }

}
