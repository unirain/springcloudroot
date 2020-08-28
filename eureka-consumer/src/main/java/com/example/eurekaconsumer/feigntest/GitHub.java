package com.example.eurekaconsumer.feigntest;

import feign.Param;
import feign.RequestLine;

import java.util.List;

/********************************************************************************
 *
 * Title: 
 *
 * Description:
 *
 * @author chenlm
 * create date on 2020/8/17
 *
 *******************************************************************************/
public interface GitHub {
    @RequestLine("GET /repos/{owner}/{repo}/contributors")
    List<Contributor> contributors(@Param("owner") String owner, @Param("repo") String repo);
}
