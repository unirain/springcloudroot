package com.hook.aware;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

/********************************************************************************
 *
 * Title: 获取 Bean 的名称。
 *
 * Description: 获取自己bean的name名称
 *
 * @author chenlm
 * create date on 2021/1/13 0013
 *
 *******************************************************************************/
@Component
public class BeanNameAwareTest implements BeanNameAware {
    @Override
    public void setBeanName(String s) {
        System.out.println(s);
    }
}
