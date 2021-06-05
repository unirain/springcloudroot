package com.app.unify.autowirerank.localimpl;

import com.app.unify.autowirerank.PersonServer;
import org.springframework.stereotype.Service;

/********************************************************************************
 *
 * Title: 本地实现
 *
 * Description:
 *
 * @author chenlm
 * create date on 2021/6/5 0005
 *
 *******************************************************************************/
@Service
public class PersonLocalImplServer implements PersonServer {

    @Override
    public String ObtainPersonName(String userId) {
        return "chenliming";
    }
}
