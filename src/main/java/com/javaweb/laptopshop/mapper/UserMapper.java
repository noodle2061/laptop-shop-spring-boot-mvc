package com.javaweb.laptopshop.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.javaweb.laptopshop.domain.User;
import com.javaweb.laptopshop.domain.dto.RegisterDTO;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "fullname", expression = "java(registerDTO.getFirstName() + \" \" + registerDTO.getLastName())")
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "address", ignore = true)
    @Mapping(target = "avatar", expression = "java(\"default-avatar.png\")")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "password", ignore = true)
    public User toUser(RegisterDTO registerDTO);
}
