package com.example.minishop.model.domain;

import com.example.minishop.model.entity.mysql.User;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class UserModel {
    private Long id;

    @Pattern(regexp = "^[0-9a-zA-Z]([-_\\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\\.]?[0-9a-zA-Z])*\\.[a-zA-Z]{2,3}$",
            message = "이메일 주소의 형식은 ~~@~~.~~입니다.")
    private String email;

    private String name;

    @Pattern(regexp = "^(?=.*[a-zA-Z])((?=.*\\d)|(?=.*\\W)).{8,128}$",
            message = "비밀번호는 8자리 이상 대소문자+숫자+특수문자 조합으로 구성되어야합니다.")
    private String password;

    @Pattern(regexp = "^01//d{1}-\\d{3,4}-\\d{4}$",
            message = "휴대폰 번호는 01으로 시작하는 11자리 숫자와 '-'로 구성되어야 합니다.")
    private String phone;
    private String role = "USER";  // "USER", "ADMIN","SELLER"
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();

    public static UserModel fromEntity(User user) {
        return UserModel.builder()
                .id(user.getId())
                .email(user.getEmail())
                .name(user.getName())
                .password(user.getPassword())
                .phone(user.getPhone())
                .role(user.getRole())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .build();
    }

}
