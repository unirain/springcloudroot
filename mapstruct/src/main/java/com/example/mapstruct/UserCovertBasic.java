package com.example.mapstruct;

import org.mapstruct.MapMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

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
@Mapper(componentModel = "spring")
public interface UserCovertBasic {
    UserCovertBasic INSTANCE = Mappers.getMapper(UserCovertBasic.class);
    /**
     * 字段数量类型数量相同，利用工具BeanUtils也可以实现类似效果
     * @param source
     * @return
     */
    UserDTO toConvertDTO(User source);

    List<User> fromConvertEntityList(List<UserDTO> userDTOList);


    User fromConvertEntity(UserDTO userVO1);

//    @Mappings({
//            @Mapping(source ="userID",target = "id")
//    })
    PersonDTO convertPersonDTO(User user);
}
