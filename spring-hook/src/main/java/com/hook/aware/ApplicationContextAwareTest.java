package com.hook.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/********************************************************************************
 *
 * Title: 获取ApplicationContext
 *
 * Description:
 *
 * @author chenlm
 * create date on 2021/1/21 0021
 *
 *******************************************************************************/
@Component
public class ApplicationContextAwareTest implements ApplicationContextAware {
    @Autowired
    private ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }
}
