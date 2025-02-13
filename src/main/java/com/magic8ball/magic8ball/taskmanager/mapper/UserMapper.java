package com.magic8ball.magic8ball.taskmanager.mapper;


import com.magic8ball.magic8ball.taskmanager.Entities.UserEntity;
import com.magic8ball.magic8ball.taskmanager.dto.UserReqDto;
import com.magic8ball.magic8ball.taskmanager.dto.UserResDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper MAPPER = Mappers.getMapper(UserMapper.class);

    UserResDto userEntityToUserDTO(UserEntity userEntity);

    UserEntity userDTOToUserEntity(UserReqDto userDTO);
}