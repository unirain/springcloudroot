package com.example.mapstruct;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

/********************************************************************************
 *
 * Title: 
 *
 * Description:
 *
 * @author chenlm
 * create date on 2020/12/8
 *
 *******************************************************************************/
public class MyTest {
    @Test
    public void should_conver(){
        User user=User.builder().userId(13L).age("29").name("chenlm").createTime(new Date()).build();
        //转换
        UserDTO userDTO=UserCovertBasic.INSTANCE.toConvertDTO(user);
        System.out.println(userDTO);

    }
    @Test
    public void should_list(){
        UserDTO userDTO1=UserDTO.builder().age("38").createTime(new Date()).name("张三").build();
        UserDTO userDTO2=UserDTO.builder().age("31").createTime(new Date()).name("李四").build();
        List<User> userList=UserCovertBasic.INSTANCE.fromConvertEntityList(Arrays.asList(userDTO1,userDTO2));
        userList.forEach(System.out::println);

    }
}
