package com.example.springneo4j.service;

import com.example.springneo4j.entity.UserRelationship;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

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
@Repository
public interface UserRelationShipRepository extends Neo4jRepository<UserRelationship,Long> {

}
