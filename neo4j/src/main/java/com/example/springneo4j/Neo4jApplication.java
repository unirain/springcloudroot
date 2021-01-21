package com.example.springneo4j;

import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

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
@SpringBootApplication
@EnableNeo4jRepositories
public class Neo4jApplication {
    public static void main(String[] args) {
        SpringApplication.run(Neo4jApplication.class, args);
    }


}
