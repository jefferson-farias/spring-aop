package com.picpay.aop.demo.infrastructure.controllers;

import com.picpay.aop.demo.api.v1.UserResource;
import com.picpay.aop.demo.api.v1.dtos.UserDTO;
import com.picpay.aop.demo.domain.ports.driver.UserService;
import com.picpay.aop.demo.infrastructure.aspects.logger.Logger;
import com.picpay.aop.demo.infrastructure.mappers.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UserController implements UserResource {

    private final UserService userService;
    private final UserMapper userMapper;

    @Override
    public UserDTO create(UserDTO user) {
        return Optional.of(user)
                .map(userMapper::fromDto)
                .map(userService::create)
                .map(userMapper::toDto)
                .orElse(null);
    }

    @Override
    @Logger(UserController.class)
    public UserDTO getById(Long id) {
        var user = userService.getById(id);

        if (user == null) {
            return null;
        }

        return userMapper.toDto(user);
    }
}
