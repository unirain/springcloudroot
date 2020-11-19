package com.example.consulconsume;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/********************************************************************************
 *
 * Title: 
 *
 * Description:
 *
 * @author chenlm
 * create date on 2020/9/10
 *
 *******************************************************************************/
@RestController
public class CallController {
    @Autowired
    private RemoteCall remoteCall;

    @RequestMapping("test-hello")
    public String hell(){
        return remoteCall.hello();

    }

}
