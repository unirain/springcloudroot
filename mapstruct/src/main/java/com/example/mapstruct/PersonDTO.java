package com.example.mapstruct;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class PersonDTO {
    private String id;
    private String name;
}
