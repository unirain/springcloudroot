package com;

import com.dianping.cat.Cat;
import com.dianping.cat.message.Transaction;
import org.springframework.stereotype.Component;

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
@Component
public class Comm {

    public String get(){
        Transaction transaction= Cat.newTransaction("URL","chenlm.yl.yl");
        try{
            System.out.println("woshi");
            transaction.setStatus(Transaction.SUCCESS);
        }catch(Exception e){
            transaction.setStatus(e);
        }finally {
            transaction.complete();
        }
        return "ok";
    }
}
