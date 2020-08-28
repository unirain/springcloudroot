package com.example.startdemo.service;

/********************************************************************************
 *
 * Title: 服务测试
 *
 * Description:
 *
 * @author chenlm
 * create date on 2020/5/28
 *
 *******************************************************************************/
public class DemoService {
    private String sayWhat;
    private String toWho;

    public DemoService(String sayWhat, String toWho) {
        this.sayWhat = sayWhat;
        this.toWho = toWho;
    }
    public  String say(){
        return this.sayWhat + "!  " + this.toWho;
    }
}
