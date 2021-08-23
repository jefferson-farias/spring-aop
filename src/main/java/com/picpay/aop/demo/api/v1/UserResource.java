package com.picpay.aop.demo.api.v1;

import com.picpay.aop.demo.api.v1.dtos.UserDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/users")
public interface UserResource {

    @PostMapping
    UserDTO create(UserDTO user);

    @GetMapping("{id}")
    UserDTO getById(@PathVariable Long id);
}
