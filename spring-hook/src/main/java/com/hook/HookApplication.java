package com.hook;

import com.hook.beancreate.FactoryBeanTest;
import com.hook.classimport.EnableOpen;
import com.hook.classimport.ImportBeanDefinitionRegistrarTest;
import com.hook.classimport.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

import java.util.Objects;

/********************************************************************************
 *
 * Title: 
 *
 * Description:
 *
 * @author chenlm
 * create date on 2021/1/12 0012
 *
 *******************************************************************************/
@SpringBootApplication
//@EnableOpen(value = "彭于晏",isOk = true)
//@Import(ImportBeanDefinitionRegistrarTest.class)
public class HookApplication {
    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext run = SpringApplication.run(HookApplication.class, args);
//        Test bean = run.getBean(Test.class);
        Test bean = (Test) run.getBean("FactoryBeanTest");
        bean.hello();
    }
}
