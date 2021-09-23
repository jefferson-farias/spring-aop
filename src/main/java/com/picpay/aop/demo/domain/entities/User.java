package com.picpay.aop.demo.domain.entities;

import com.picpay.aop.demo.domain.utils.Assert;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.regex.Pattern;

@Getter
@NoArgsConstructor
@Entity(name = "user")
public class User { // Entidade é responsável por manter seu estado sempre consistente.

    private static final Pattern DOMAIN_PICPAY = Pattern.compile("@picpay");

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String email;

    @Builder
    public User(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        validateEmailPicpay(); // em caso de email sempre precisar ser dominio picpay.
    }

    private void validateEmailPicpay() {
        var isDomainPicpay = email.matches(DOMAIN_PICPAY.pattern());

        Assert.assertTrue(isDomainPicpay, "Invalid email!");
    }
}
