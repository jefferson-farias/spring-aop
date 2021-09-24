package com.picpay.aop.demo.domain.services;

import com.picpay.aop.demo.domain.entities.User;
import com.picpay.aop.demo.domain.ports.driven.UserRecipient;
import com.picpay.aop.demo.domain.ports.driven.UserRepository;
import com.picpay.aop.demo.support.TestSupport;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class UserServiceImplTest extends TestSupport {

    @Mock
    private UserRepository userRepository;

    @Spy
    private UserRecipient userRecipient;

    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void shouldCreateUser() {
        var user = new User(null, "jefferson", "email@picpay.com");
        var expected = new User(1l, "jefferson", "email@picpay.com");

        when(userRepository.create(user)).thenReturn(expected);

        var result = userService.create(user);

        assertThat(result).isEqualTo(expected);
        verify(userRecipient).notifyCreated(expected);
    }
}
