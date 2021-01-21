package com.hook.aware;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

/********************************************************************************
 *
 * Title: 
 *
 * Description:
 *
 * @author chenlm
 * create date on 2021/1/13 0013
 *
 *******************************************************************************/
@Component
public class ResourceLoaderAwareTest implements ResourceLoaderAware {
    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        System.out.println(resourceLoader);
    }
}

