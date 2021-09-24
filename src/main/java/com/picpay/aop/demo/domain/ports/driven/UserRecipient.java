package com.picpay.aop.demo.domain.ports.driven;

import com.picpay.aop.demo.domain.entities.User;

public interface UserRecipient {

    void notifyCreated(User user);
}
