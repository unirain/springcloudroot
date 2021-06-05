package com.app.unify.autowirerank;

import org.springframework.web.bind.annotation.GetMapping;

/********************************************************************************
 *
 * Title: 
 *
 * Description:
 *
 * @author chenlm
 * create date on 2021/6/5 0005
 *
 *******************************************************************************/
public interface PersonServer {

    @GetMapping(value = "/wo-test")
    String ObtainPersonName(String userId);
}
