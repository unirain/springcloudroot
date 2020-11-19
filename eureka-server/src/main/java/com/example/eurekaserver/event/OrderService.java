package com.example.eurekaserver.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/********************************************************************************
 *
 * Title: 订单服务
 *
 * Description:
 *
 * @author chenlm
 * create date on 2020/9/21
 *
 *******************************************************************************/
@Service
public class OrderService {
    @Autowired
    private ApplicationContext applicationContext;
    public void order(){
        // 下单成功
        System.out.println("下单成功...");
        // 发布通知
        applicationContext.publishEvent(new OrderSuccessEvent(this));
        System.out.println("main线程结束...");
    }

}
