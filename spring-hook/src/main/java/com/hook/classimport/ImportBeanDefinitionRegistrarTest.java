package com.hook.classimport;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/********************************************************************************
 *
 * Title: 
 *
 * Description: 该接口和 ImportSelector 类似，也是配合 @Import 使用，
 * 不过 ImportBeanDefinitionRegistrar 更为直接一点，它可以直接把 Bean 注册到容器中。
 *
 * @author chenlm
 * create date on 2021/1/21 0021
 *
 *******************************************************************************/
public class ImportBeanDefinitionRegistrarTest implements ImportBeanDefinitionRegistrar {
    @Override
    //入参除了注解元数据对象 AnnotationMetadata 外，
    // 还多了一个 BeanDefinitionRegistry 对象，
    // 在前面的文章讲过，该对象定义了关于 BeanDefinition 的一系列的操作，如：注册、移除、查询等
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        RootBeanDefinition rootBeanDefinition=new RootBeanDefinition(Test.class);
        rootBeanDefinition.setLazyInit(true);
        registry.registerBeanDefinition(Test.class.getName(),rootBeanDefinition);

    }
}
