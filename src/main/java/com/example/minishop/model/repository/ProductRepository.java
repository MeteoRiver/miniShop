package com.example.minishop.model.repository;

import com.example.minishop.model.entity.mysql.Category;
import com.example.minishop.model.entity.mysql.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategory(Category category);
}
