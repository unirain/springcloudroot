package com.hook.aware;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/********************************************************************************
 *
 * Title:  运行时环境
 * Description: 获取环境配置  它表示整个的运行时环境，可以设置和获取配置属性。
 *
 * @author chenlm
 * create date on 2021/1/13 0013
 *
 *******************************************************************************/
@Component
public class EnvironmentAwareTest implements EnvironmentAware {
    @Override
    public void setEnvironment(Environment environment) {
        System.out.println(environment.toString());
    }
}
