package com.hook.classimport;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

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
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(ImportSelectorTest.class)
public @interface EnableOpen {
    String value();
    boolean isOk();
}
