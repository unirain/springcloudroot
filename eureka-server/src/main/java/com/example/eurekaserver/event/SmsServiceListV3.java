package com.example.eurekaserver.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/********************************************************************************
 *
 * Title: 
 *
 * Description:
 *
 * @author chenlm
 * create date on 2020/9/25
 *
 *******************************************************************************/
@Component
public class SmsServiceListV3  implements ApplicationListener<OrderSuccessEvent> {
    @Override
    public void onApplicationEvent(OrderSuccessEvent event) {
        System.out.println("我收到了");
    }
}
