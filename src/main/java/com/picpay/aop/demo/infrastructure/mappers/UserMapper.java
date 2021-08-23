package com.picpay.aop.demo.infrastructure.mappers;

import com.picpay.aop.demo.api.v1.dtos.UserDTO;
import com.picpay.aop.demo.domain.entities.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User fromDto(UserDTO user) {
        return new User(user.getId(), user.getName(), user.getEmail());
    }

    public UserDTO toDto(User user) {
        return new UserDTO(user.getId(), user.getName(), user.getEmail());
    }
}
