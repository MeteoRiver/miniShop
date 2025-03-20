package com.example.minishop.model.domain;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginModel {
    private String email;
    private String password;
}
