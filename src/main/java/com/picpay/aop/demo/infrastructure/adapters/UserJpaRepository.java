package com.picpay.aop.demo.infrastructure.adapters;

import com.picpay.aop.demo.domain.entities.User;
import com.picpay.aop.demo.domain.ports.driven.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJpaRepository extends UserRepository, JpaRepository<User, Long> {

    @Override
    default User create(User user) {
        return save(user);
    }

    @Override
    default User getById(Long id) {
        return findById(id).orElse(null);
    }
}
