package com.example.minishop.model.repository.Impl;

import com.example.minishop.model.entity.mysql.Product;
import com.example.minishop.model.repository.Custom.ProductRepositoryCustom;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;

import java.util.List;

@RequiredArgsConstructor
public class ProductRepositoryCustomImpl implements ProductRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public ProductRepositoryCustomImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<Product> searchProducts(String keyword) {
        QProduct product = QProduct.product;
        return queryFactory.selectFrom(product)
                .where(StringUtils.hasText(keyword)
                        ? product.name.containsIgnoreCase(keyword)
                        : null)
                .fetch();
    }

}
