package com.hook.beanafter;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/********************************************************************************
 *
 * Title:  bean初始化后调用
 *
 * Description:
 *
 * @author chenlm
 * create date on 2021/1/21 0021
 *
 *******************************************************************************/
@Component
public class InitializingBeanTest implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBeanTest初始化好了");
    }
}
