package com.example.nacosconfig;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/********************************************************************************
 *
 * Title: 
 *
 * Description:
 *
 * @author chenlm
 * create date on 2020/12/8
 *
 *******************************************************************************/
@RestController
public class ConfigController {
    @NacosValue(value = "${myname:无}",autoRefreshed = true)
    private String name;

    @GetMapping("/config-getName")
    public String getNameC(){
        return name;
    }
}
