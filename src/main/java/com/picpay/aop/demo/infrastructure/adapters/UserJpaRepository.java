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
//    @SuppressException
    default User getById(Long id) {
//        if (1 == 1) {
//            throw new RuntimeException("errorrrrrr");
//        }

        return findById(id).orElse(null);
    }
}
