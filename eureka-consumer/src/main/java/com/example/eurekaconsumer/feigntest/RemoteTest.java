package com.example.eurekaconsumer.feigntest;

import feign.Feign;

import java.util.List;

/********************************************************************************
 *
 * Title: 测试
 *
 * Description:
 *
 * @author chenlm
 * create date on 2020/8/17
 *
 *******************************************************************************/
public class RemoteTest {

    public static void main(String[] args) {
        GitHub github = Feign.builder()
//                .decoder(new GsonDecoder())
                .target(GitHub.class, "https://api.github.com");

        // Fetch and print a list of the contributors to this library.
        List<Contributor> contributors = github.contributors("OpenFeign", "feign");
        for (Contributor contributor : contributors) {
            System.out.println(contributor.getLogin() + " (" + contributor.getContributions() + ")");
        }
    }

}
