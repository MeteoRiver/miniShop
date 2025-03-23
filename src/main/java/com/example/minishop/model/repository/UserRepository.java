package com.example.minishop.model.repository;

import com.example.minishop.model.entity.mysql.User;
import com.example.minishop.model.repository.Custom.UserRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryCustom {
    boolean existsByEmail(String email);

    boolean existsByPhone(String phone);

}
