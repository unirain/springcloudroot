package com.example.mapstruct;

import lombok.*;

import java.util.Date;

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
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserDTO {
    private String name;
    private String age;
    private Date createTime;
}
