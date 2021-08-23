package com.picpay.aop.demo.domain.ports.driven;

import com.picpay.aop.demo.domain.entities.User;

public interface UserRepository {

    User create(User user);

    User getById(Long id);
}
