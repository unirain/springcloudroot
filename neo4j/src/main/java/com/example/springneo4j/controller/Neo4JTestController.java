package com.example.springneo4j.controller;

import com.example.springneo4j.entity.AccountNode;
import com.example.springneo4j.service.UserRepositoryService;
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
 * create date on 2020/12/7
 *
 *******************************************************************************/
@RestController
public class Neo4JTestController {
    @Autowired
    private UserRepositoryService userRepositoryService;

    @RequestMapping("/createNode")
    public String createNode(){
        userRepositoryService.CreateUserNode();
        return "ok";
    }


    @RequestMapping("/createShip")
    public String createWithShip(){
        userRepositoryService.CreateShip();
        return "ok";
    }

    @RequestMapping("/queryAccountByBank")
    public AccountNode queryAccount(String name){

        return userRepositoryService.getAcByBank(name);
    }
}
