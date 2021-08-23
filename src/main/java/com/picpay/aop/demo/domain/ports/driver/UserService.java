package com.picpay.aop.demo.domain.ports.driver;

import com.picpay.aop.demo.domain.entities.User;

public interface UserService {

    User create(User user);

    User getById(Long id);
}
