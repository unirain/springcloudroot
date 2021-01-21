package com.hook.classimport;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/********************************************************************************
 *
 * Title: 
 *
 * Description:
 *
 * @author chenlm
 * create date on 2021/1/21 0021
 *
 *******************************************************************************/
public class ImportSelectorTest implements ImportSelector {
    @Override
    // 方法入参是注解的元数据对象，返回值是类的全路径名数组
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        if (importingClassMetadata.hasAnnotation("")) {
            // 判断是否包含某个注解
            //importingClassMetadata :由于spring时扫描bean注册，发现有import注解时，而import得bean又实现了ImportSelector
            //则会把当前扫描到得类引入importingClassMetadata，即使import注解被另外一个注解包装起来也一样，spring会自己解开
        }

        // 返回 Test 的全路径名，Test 会被放入到 Spring 容器中
        return new String[]{"com.hook.classimport.Test"};
    }
}
