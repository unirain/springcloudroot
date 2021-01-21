package com.example.springneo4j.service;

import com.example.springneo4j.entity.AccountNode;
import com.example.springneo4j.entity.UserNode;
import com.example.springneo4j.entity.UserRelationship;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
@Service
public class UserRepositoryService {
    private Logger logger = LoggerFactory.getLogger(UserRepositoryService.class);
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserRelationShipRepository userRelationShipRepository;



    public void CreateUserNode() {
        System.out.println(userRepository);
        UserNode userNode = new UserNode();
        userNode.setName("张三");
        userNode.setCompanyId("12343");
        UserNode result = userRepository.save(userNode);
        logger.info(result.toString());
    }

    public void CreateShip() {
        UserNode userNode = new UserNode();
        userNode.setName("小王");
        userNode.setCompanyId("12343");
        userRepository.save(userNode);
        AccountNode accountNode=new AccountNode();
        accountNode.setBank("厦门银行");
        accountRepository.save(accountNode);
        UserRelationship userRelationship=new UserRelationship();
        userRelationship.setAccountNode(accountNode);
        userRelationship.setAmount("1099");
        userRelationship.setUserNode(userNode);
        userRelationShipRepository.save(userRelationship);
    }

    public AccountNode getAcByBank(String name){
        AccountNode accountNode=accountRepository.queryByBank(name);
        return accountNode;
    }


}
