package com.hook.beanafter;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/********************************************************************************
 *
 * Title: Bean 工厂的后置处理器，一般用来修改上下文中的 BeanDefinition，修改 Bean 的属性值。
 *
 * Description:
 *
 * @author chenlm
 * create date on 2021/1/21 0021
 *
 *******************************************************************************/
//@Component
public class BeanFactoryPostProcessorTest implements BeanFactoryPostProcessor {

    // 入参是一个 Bean 工厂：ConfigurableListableBeanFactory。该方法执行时，所有 BeanDefinition 都已被加载，但还未实例化 Bean。
    // 可以对其进行覆盖或添加属性，甚至可以用于初始化 Bean。
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        String[] beanNames = configurableListableBeanFactory.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            BeanDefinition beanDefinition = configurableListableBeanFactory.getBeanDefinition(beanName);
            System.out.println(beanDefinition);
        }
    }
}
