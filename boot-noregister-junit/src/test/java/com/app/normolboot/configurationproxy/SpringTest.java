package com.app.normolboot.configurationproxy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/********************************************************************************
 *
 * Title: 
 *
 * Description:
 *
 * @author chenlm
 * create date on 2021/6/1 0001
 *
 *******************************************************************************/

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("dev")
public class SpringTest {

    @Autowired
    private Car car;
    @Autowired
    private Config config;

    @Test
    public void should_print(){
        car.play();

    }
}
