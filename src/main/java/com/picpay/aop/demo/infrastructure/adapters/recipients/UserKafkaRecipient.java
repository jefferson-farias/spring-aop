package com.picpay.aop.demo.infrastructure.adapters.recipients;

import com.picpay.aop.demo.domain.entities.User;
import com.picpay.aop.demo.domain.ports.driven.UserRecipient;
import com.picpay.aop.demo.infrastructure.mappers.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserKafkaRecipient implements UserRecipient {

    private final UserMapper mapper;
    private final ApplicationEventPublisher publisher;

    @Override
    public void notifyCreated(User user) {
        var dto = mapper.toDto(user);

        publisher.publishEvent(dto);
        // publica em topico do kafka, por exemplo
    }
}
