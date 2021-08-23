package com.picpay.aop.demo.domain.services;

import com.picpay.aop.demo.domain.entities.User;
import com.picpay.aop.demo.domain.ports.driven.UserRepository;
import com.picpay.aop.demo.domain.ports.driver.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User create(User user) {
        return userRepository.create(user);
    }

    @Override
    public User getById(Long id) {
        return userRepository.getById(id);
    }
}
