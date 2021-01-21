package com.hook.beancreate;

import com.hook.classimport.Test;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/********************************************************************************
 *
 * Title: 
 *
 * Description:  FactoryBean 也是一种 Bean，不同于普通的 Bean，
 * 它是用来创建 Bean 实例的，属于工厂 Bean，不过它和普通的创建不同，
 * 它提供了更为灵活的方式，其实现有点类似于设计模式中的工厂模式和修饰器模式。
 *
 * @author chenlm
 * create date on 2021/1/21 0021
 *
 *******************************************************************************/
@Component
public class FactoryBeanTest implements FactoryBean<Test> {
    @Override
    public Test getObject() throws Exception {
        // 这里可以灵活的创建 Bean，如：代理、修饰
        return new Test();
    }

    @Override
//    / Bean的类型
    public Class<?> getObjectType() {
        return null;
    }

    // 是否是单例
    @Override
    public boolean isSingleton() {
        return true;
    }
}
