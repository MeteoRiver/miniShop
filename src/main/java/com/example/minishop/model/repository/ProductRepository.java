package com.example.minishop.model.repository;

import com.example.minishop.model.entity.mysql.Product;
import com.example.minishop.model.entity.mysql.User;
import com.example.minishop.model.repository.Custom.ProductRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<User, Long>, ProductRepositoryCustom {
}
