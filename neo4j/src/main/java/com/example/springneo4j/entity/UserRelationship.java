package com.example.springneo4j.entity;

import org.junit.Test;
import org.neo4j.ogm.annotation.*;

/********************************************************************************
 *
 * Title: 账号用户关系
 *
 * Description:
 *
 * @author chenlm
 * create date on 2020/12/7
 *
 *******************************************************************************/
@RelationshipEntity(type = "UserWithAccount")
public class UserRelationship {

    @Id
    @GeneratedValue
    private Long id;

    private String indexName;

    @EndNode
    private AccountNode accountNode;

    @StartNode
    private UserNode userNode;

    /**
     * 余额
     */
    private String amount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIndexName() {
        return indexName;
    }

    public void setIndexName(String indexName) {
        this.indexName = indexName;
    }

    public AccountNode getAccountNode() {
        return accountNode;
    }

    public void setAccountNode(AccountNode accountNode) {
        this.accountNode = accountNode;
    }

    public UserNode getUserNode() {
        return userNode;
    }

    public void setUserNode(UserNode userNode) {
        this.userNode = userNode;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
