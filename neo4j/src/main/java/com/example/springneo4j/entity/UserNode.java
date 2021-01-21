package com.example.springneo4j.entity;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

import java.io.Serializable;

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
@NodeEntity(value ="USER" )
public class UserNode implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String userId;
    private String companyId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("UserNode{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", userId='").append(userId).append('\'');
        sb.append(", companyId='").append(companyId).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
