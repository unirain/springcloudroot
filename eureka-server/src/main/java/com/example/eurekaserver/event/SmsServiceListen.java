package com.example.eurekaserver.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/********************************************************************************
 *
 * Title: 监听
 *
 * Description:
 *
 * @author chenlm
 * create date on 2020/9/21
 *
 *******************************************************************************/
@Component
public class SmsServiceListen implements ApplicationListener<OrderSuccessEvent> {
    @Override
    public void onApplicationEvent(OrderSuccessEvent orderSuccessEvent) {
          this.sendSms();
    }

    /**
     * 发送短信
     */
    public void sendSms() {
        System.out.println("发送短信...");
    }
}
