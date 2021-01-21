package com.example.springneo4j.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.Labels;
import org.neo4j.ogm.annotation.NodeEntity;

/********************************************************************************
 *
 * Title: 账号
 *
 * Description:
 *
 * @author chenlm
 * create date on 2020/12/7
 *
 *******************************************************************************/
@NodeEntity(value ="ACCOUNT" )
@Data
@Accessors(chain = true)
public class AccountNode {
    @Id
    @GeneratedValue
    private Long id;
    private String bank;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }
}
