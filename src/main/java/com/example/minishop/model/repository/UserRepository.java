package com.example.minishop.model.repository;

import com.example.minishop.model.entity.mysql.User;
import com.example.minishop.model.repository.Custom.UserRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryCustom {
    boolean existsByEmail(String email);

    boolean existsByPhone(String phone);

}
