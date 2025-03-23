package com.example.minishop.model.repository.Custom;

import com.example.minishop.model.entity.mysql.Product;

import java.util.List;

public interface ProductRepositoryCustom {
    List<Product> searchProducts(String keyword);

}
