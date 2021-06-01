package com.app.unify.sidecar;

import com.app.unify.sidecar.feign.RemoteCallClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/********************************************************************************
 *
 * Title: 
 *
 * Description:
 *
 * @author chenlm
 * create date on 2021/5/28 0028
 *
 *******************************************************************************/
@RestController
public class SidecarController {
    @Autowired
    private RemoteCallClient remoteCallClient;

    @GetMapping("/test1")
    public String questone(){
        return remoteCallClient.call(new HashMap<>());

    }
}
