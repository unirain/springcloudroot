package com;

import com.dianping.cat.Cat;
import com.dianping.cat.message.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/********************************************************************************
 *
 * Title: 
 *
 * Description:
 *
 * @author chenlm
 * create date on 2020/11/12
 *
 *******************************************************************************/
@RequestMapping("/cat-test")
@RestController
public class TestCon {

    @Autowired
    private Comm comm;


    @GetMapping("/trace")
    public  String test(){
        System.out.println("进来了");
        Transaction transaction= Cat.newTransaction("URL-yl","chenlm.yl");
        try{

            Cat.logEvent("URL.Server","hello");
            Cat.logEvent("chenliming","dfasdfas");
            Cat.logMetricForCount("OrderCount");
            System.out.println("woshi");
            comm.get();
            transaction.setStatus(Transaction.SUCCESS);
        }catch(Exception e){
            transaction.setStatus(e);
        }finally {
            transaction.complete();
        }
        return "ok";

    }
}
