package com.example.springneo4j.service;

import com.example.springneo4j.entity.AccountNode;
import com.example.springneo4j.entity.UserNode;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

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
@Repository
public interface AccountRepository extends Neo4jRepository<AccountNode, Long> {

    @Query(value = "match(a:ACCOUNT) where a.bank={0} return a")
    AccountNode queryByBank(String bankName);
}
