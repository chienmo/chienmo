package com.ttt.hellospringboot.model.mapper;

import com.ttt.hellospringboot.entity.User;
import com.ttt.hellospringboot.model.dto.UserDto;

public class UserMapper {
    public static UserDto toUserDto(User user){
            UserDto tmp = new UserDto();
            tmp.setId(user.getId());
            tmp.setName(user.getName());
            tmp.setEmail(user.getEmail());
            tmp.setPhone(user.getPhone());
            tmp.setAvatar(user.getAvatar());
            return tmp;
    }
}
