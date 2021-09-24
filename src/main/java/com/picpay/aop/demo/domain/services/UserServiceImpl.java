package com.picpay.aop.demo.domain.services;

import com.picpay.aop.demo.domain.entities.User;
import com.picpay.aop.demo.domain.ports.driven.UserRecipient;
import com.picpay.aop.demo.domain.ports.driven.UserRepository;
import com.picpay.aop.demo.domain.ports.driver.UserService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
//@Service
//class UserServiceImpl implements UserService {
public class UserServiceImpl implements UserService { // equivalente ao caso de uso, controla somente regra de fluxo de execução

    private final UserRepository userRepository;
    private final UserRecipient userRecipient;

    @Override
    public User create(User user) {
        var userCreated = userRepository.create(user);

        userRecipient.notifyCreated(userCreated);

        return userCreated;
    }

    @Override
    public User getById(Long id) {
        return userRepository.getById(id);
    }
}
