package com.hook.beanafter;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/********************************************************************************
 *
 * Title: 初始化之前 和之后对bean进行处理
 *
 * Description:针对的是所有的 Bean。
 *
 * @author chenlm
 * create date on 2021/1/21 0021
 *
 *******************************************************************************/
//@Component
public class BeanPostProcessorTest implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(beanName + " 初始化前执行操作");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(beanName + " 初始化后执行操作");
        return bean;
    }
}
