package com.example.eurekaserver.event;

import org.springframework.context.ApplicationEvent;

/********************************************************************************
 *
 * Title: 下单成功事件
 *
 * Description:
 *
 * @author chenlm
 * create date on 2020/9/21
 *
 *******************************************************************************/
public class OrderSuccessEvent extends ApplicationEvent {
    public OrderSuccessEvent(Object source) {
        super(source);
    }
}
