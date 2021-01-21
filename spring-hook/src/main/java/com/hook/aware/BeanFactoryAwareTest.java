package com.hook.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Component;

/********************************************************************************
 *
 * Title: 获取beanFactory
 *
 * Description: 初始化之后会调用
 *
 * @author chenlm
 * create date on 2021/1/12 0012
 *
 *******************************************************************************/
@Component
public class BeanFactoryAwareTest implements BeanFactoryAware {
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("我进来了");

    }
}
