package com.picpay.aop.demo.infrastructure.config;

import com.picpay.aop.demo.domain.ports.driven.UserRecipient;
import com.picpay.aop.demo.domain.ports.driven.UserRepository;
import com.picpay.aop.demo.domain.ports.driver.UserService;
import com.picpay.aop.demo.domain.services.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServicesBeanConfig {

    @Bean
    UserService userService(UserRepository repository, UserRecipient recipient) {
        return new UserServiceImpl(repository, recipient);
    }
}
