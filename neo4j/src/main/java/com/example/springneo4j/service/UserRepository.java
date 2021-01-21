package com.example.springneo4j.service;

import com.example.springneo4j.entity.UserNode;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

/********************************************************************************
 *
 * Title: 操作
 *
 * Description:
 *
 * @author chenlm
 * create date on 2020/12/7
 *
 *******************************************************************************/
@Repository
public interface UserRepository extends Neo4jRepository<UserNode,Long> {




}
