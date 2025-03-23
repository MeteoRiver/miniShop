package com.example.minishop.service.Impl;

import com.example.minishop.model.domain.ProductModel;
import com.example.minishop.model.entity.mysql.Product;
import com.example.minishop.model.repository.ProductRepository;
import com.example.minishop.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductModel Create(ProductModel productModel) {
        Product savedProduct = productRepository.save(Product.builder()
                .name(productModel.getName())
                .description(productModel.getDescription())
                .price(productModel.getPrice())
                .stock(productModel.getStock())
                .imageUrls(productModel.getImageUrls())
                .category(productModel.getCategory())
                .seller(productModel.getSellerId())
                .build());
        return ProductModel.fromEntity(savedProduct);
    }

    @Override
    public ProductModel Update(ProductModel product) {
        return null;
    }

    @Override
    public Boolean Delete(Long productId) {
        return null;
    }

    @Override
    public ProductModel FindById(Long productId) {
        return null;
    }

    @Override
    public List<ProductModel> FindAll() {
        return List.of();
    }

    @Override
    public List<ProductModel> FindByCategory(String category) {
        return List.of();
    }

    @Override
    public List<ProductModel> FindByKeyWord(String keyword) {
        return List.of();
    }
}
