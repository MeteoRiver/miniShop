package com.example.minishop.service;

import com.example.minishop.model.domain.ProductModel;

import java.util.List;

public interface ProductService {
    ProductModel Create(ProductModel product);
    ProductModel Update(ProductModel product);
    Boolean Delete(Long productId);
    ProductModel FindById(Long productId);
    List<ProductModel> FindAll();
    List<ProductModel> FindByCategory(String category);
    List<ProductModel> FindByKeyWord(String keyword);
}
