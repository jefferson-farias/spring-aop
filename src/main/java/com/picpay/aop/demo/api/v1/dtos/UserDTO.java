package com.picpay.aop.demo.api.v1.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private static final long serialVersionUID = 7139325143373386841L;

    private Long id;
    private String name;
    private String email;
}
