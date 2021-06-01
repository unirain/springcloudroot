package com.app.normolboot.configurationproxy;

import lombok.Getter;
import lombok.Setter;

/********************************************************************************
 *
 * Title: 
 *
 * Description:
 *
 * @author chenlm
 * create date on 2021/6/1 0001
 *
 *******************************************************************************/
@Setter
@Getter
public class FlyCar {

    private Car car;


    private String name;

    public void play(){
        System.out.println("my name is "+getName());
    }
}
