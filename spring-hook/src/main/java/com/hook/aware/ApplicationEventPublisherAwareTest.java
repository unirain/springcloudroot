package com.hook.aware;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

/********************************************************************************
 *
 * Title:  发布者需要继承这个
 *
 * Description: 发布事件的发布者,当然 使用 ApplicationContext 也可以发布,他实现了ApplicationEventPublisher
 *
 * @author chenlm
 * create date on 2021/1/13 0013
 *
 *******************************************************************************/
@Component
public class ApplicationEventPublisherAwareTest implements ApplicationEventPublisherAware {
    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
       //用来发布事件的


    }
}
