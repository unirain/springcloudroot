package com;

import com.dianping.cat.Cat;
import com.dianping.cat.message.Transaction;
import com.dianping.cat.message.internal.AbstractMessage;

/********************************************************************************
 *
 * Title: 
 *
 * Description:
 *
 * @author chenlm
 * create date on 2020/11/5
 *
 *******************************************************************************/
public class Test {
    public void test1(){
        Transaction transaction= Cat.newTransaction("URL","chenlm.yl");
        try{

            Cat.logEvent("URL.Server","hello");
            Cat.logMetricForCount("OrderCount");
            System.out.println("woshi");
            transaction.setStatus(Transaction.SUCCESS);
        }catch(Exception e){
            transaction.setStatus(e);
        }finally {
            transaction.complete();
        }
    }
}
